package com.example.data.mappers

import com.example.data.db.entity.MatchEntity
import com.example.domain.models.Match
import javax.inject.Inject

class MatchEntityMapper @Inject constructor(
    private val awayTeamEntityMapper: TeamEntityMapper,
    private val homeTeamEntityMapper: HomeTeamEntityMapper,
    private val scoreEntityMapper: ScoreEntityMapper
) {
    fun mapMatchToMatchEntity(match:Match):MatchEntity =
        MatchEntity(
            awayTeam = awayTeamEntityMapper.mapTeamToEntity(match.awayTeam),
            score = scoreEntityMapper.mapScoreToEntity(match.score),
            status = match.status,
            date = match.date,
            homeTeam = homeTeamEntityMapper.mapHomeTeamToEnitiy(match.homeTeam),
            matchId = match.id
        )

    fun mapMatchsToDomain(entity: List<MatchEntity>): List<Match> =
        entity.map {
            mapEntityToDomain(it)
        }

    fun mapEntityToDomain(entity: MatchEntity):Match =
        Match(
            id = entity.matchId,
            homeTeam = homeTeamEntityMapper.mapHomeTeamEntityToDomain(entity.homeTeam),
            awayTeam = awayTeamEntityMapper.mapEntityTeamToDomain(entity.awayTeam),
            score = scoreEntityMapper.mapScoreToDomain(entity.score),
            status = entity.status,
            date = entity.date,
            isFavorite = true
        )
}