package com.example.fixturesapplication.model.mappers

import com.example.domain.models.Match
import com.example.fixturesapplication.model.ListItem
import com.example.fixturesapplication.model.MatchUIModel
import java.util.*
import javax.inject.Inject

class MatchUIMapper @Inject constructor(
    private val resultUIModelMapper: ResultUIModelMapper,
    private val teamMapper: TeamMapper
) {
    private fun mapToPresentation(match: Match): MatchUIModel =
        MatchUIModel(
            id = match.id,
            homeTeam = teamMapper.mapToPresentation(match.homeTeam),
            awayTeam = teamMapper.mapToPresentation(match.awayTeam),
            time = match.date.formatToTime(),
            date = match.date,
            status = match.status,
            result = resultUIModelMapper.mapToPresentastion(match.score),
            isFavorite = match.isFavorite
        )

    fun mapToPresentation(matchesList: List<Match>): List<ListItem> {
        val matchesListItem = ArrayList<ListItem>()
        val groupedList = groupDataIntoHashMap(matchesList)
        groupedList.keys.forEach { date ->
            val dateItem = date.map()
            matchesListItem.add(dateItem)

            groupedList[date]?.forEach {
                val matchItem = mapToPresentation(it)
                matchesListItem.add(matchItem)
            }

        }
        return matchesListItem
    }

    fun mapToDomain(matchUIModel: MatchUIModel): Match =
        Match(
            id = matchUIModel.id,
            awayTeam = teamMapper.mapToDomain(matchUIModel.awayTeam),
            homeTeam = teamMapper.mapToDomain(matchUIModel.homeTeam),
            date = matchUIModel.date,
            status = matchUIModel.status,
            score = resultUIModelMapper.mapToDomain(matchUIModel.result),
            isFavorite = matchUIModel.isFavorite
        )

    private fun groupDataIntoHashMap(list: List<Match>): Map<Date, List<Match>> {
        return list.sortedBy {
            it.date
        }.groupBy { match ->
            val calendar = Calendar.getInstance()
            calendar.time = match.date
            calendar.set(Calendar.HOUR_OF_DAY, 0)
            calendar.set(Calendar.MINUTE, 0)
            calendar.set(Calendar.SECOND, 0)
            calendar.set(Calendar.MILLISECOND, 0)
            calendar.time
        }
    }
}