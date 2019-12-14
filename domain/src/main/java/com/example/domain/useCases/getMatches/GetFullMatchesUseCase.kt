package com.example.domain.useCases.getMatches

import com.example.domain.models.Match
import com.example.domain.repository.FavoriteRepository
import com.example.domain.repository.MatchesRepository
import io.reactivex.Flowable
import io.reactivex.functions.BiFunction
import java.util.*
import javax.inject.Inject

class GetFullMatchesUseCase @Inject constructor(
    private val matchesRepository: MatchesRepository,
    private val favoriteRepository: FavoriteRepository,
    private val calendar: Calendar
) : GetMatchesStrategy {
    override fun get(): Flowable<List<Match>> = Flowable.combineLatest(
        matchesRepository.getMatches().toFlowable(),
        favoriteRepository.getFavoriteMatches(),
        BiFunction { matches, favorites ->
            matches.forEach {
                if (favorites.contains(it)){
                    it.isFavorite = true
                    favoriteRepository.updateMatch(it).subscribe()
                }else{
                    it.isFavorite = false
                }
            }
            val filteredMatches = matches.filter {
                val date = it.date
                val s = Calendar.getInstance()
                s.time = date
                s.set(Calendar.HOUR_OF_DAY,0)
                s.set(Calendar.MINUTE,0)
                s.set(Calendar.SECOND,0)

                calendar.set(Calendar.HOUR_OF_DAY,0)
                calendar.set(Calendar.MINUTE,0)
                calendar.set(Calendar.SECOND,0)
                !before(s,calendar)
            }
            filteredMatches
        })

    fun before(c1: Calendar, c2: Calendar): Boolean {
        val c1Year = c1.get(Calendar.YEAR)
        val c1Month = c1.get(Calendar.MONTH)
        val c1Day = c1.get(Calendar.DAY_OF_MONTH)

        val c2Year = c2.get(Calendar.YEAR)
        val c2Month = c2.get(Calendar.MONTH)
        val c2Day = c2.get(Calendar.DAY_OF_MONTH)

        return when {
            c1Year < c2Year -> true
            c1Year > c2Year -> false
            else -> when {
                c1Month > c2Month -> false
                c1Month < c2Month -> true
                else -> c1Day < c2Day
            }
        }
    }
}