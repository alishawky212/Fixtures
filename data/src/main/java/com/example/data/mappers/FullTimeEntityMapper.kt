package com.example.data.mappers

import com.example.data.db.entity.FullTimeEntity
import com.example.domain.models.MatchResult
import javax.inject.Inject

class FullTimeEntityMapper @Inject constructor() {
    fun mapFullTimeToEntity(fullTime: MatchResult):FullTimeEntity =
        FullTimeEntity(
            homeTeam = fullTime.homeTeam,
            awayTeam = fullTime.awayTeam
        )

    fun mapEntityToDomain(entity: FullTimeEntity): MatchResult =
        MatchResult(
            awayTeam = entity.awayTeam,
            homeTeam = entity.homeTeam
        )
}