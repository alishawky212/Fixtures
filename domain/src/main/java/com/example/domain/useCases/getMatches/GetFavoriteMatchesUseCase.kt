package com.example.domain.useCases.getMatches

import com.example.domain.models.Match
import com.example.domain.repository.FavoriteRepository
import com.example.domain.useCases.getMatches.GetMatchesStrategy
import io.reactivex.Flowable
import javax.inject.Inject

class GetFavoriteMatchesUseCase @Inject constructor(
    private val localRepository: FavoriteRepository
) : GetMatchesStrategy {
    override fun get():Flowable<List<Match>>{
        return localRepository.getFavoriteMatches()
    }
}