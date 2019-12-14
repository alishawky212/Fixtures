package com.example.data.mappers

import com.example.data.models_dto.MatchDTO
import com.example.data.parseServerDate
import com.example.domain.models.Match
import javax.inject.Inject

class MatchesMapper @Inject constructor(
    private val teamMapper: TeamMapper,
    private val scoreMapper: ScoreMapper){

     fun mapToDomain(matchDTO: MatchDTO):Match =
        Match(
            homeTeam = teamMapper.mapToDomain(matchDTO.homeTeam),
            awayTeam = teamMapper.mapToDomain(matchDTO.awayTeam),
            status = matchDTO.status,
            score = scoreMapper.mapToDomain(matchDTO.score),
            date = matchDTO.utcDate.parseServerDate(),
            id = matchDTO.id,
            isFavorite = matchDTO.isFavorite
        )

    fun mapToDomain(list: List<MatchDTO>): List<Match> = list.map { mapToDomain(it) }
}