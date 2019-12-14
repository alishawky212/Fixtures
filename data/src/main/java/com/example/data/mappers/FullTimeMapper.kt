package com.example.data.mappers

import com.example.data.models_dto.FullTimeDTO
import com.example.domain.models.MatchResult
import javax.inject.Inject

class FullTimeMapper @Inject constructor() {
    fun mapToDomain(fullTimeDTO: FullTimeDTO): MatchResult =
        MatchResult(
            awayTeam = fullTimeDTO.awayTeam ?: 0,
            homeTeam = fullTimeDTO.homeTeam ?: 0
        )
}