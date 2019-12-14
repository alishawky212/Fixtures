package com.example.data.mappers

import com.example.data.db.entity.AwayTeamEntity
import com.example.domain.models.Team
import javax.inject.Inject

class TeamEntityMapper @Inject constructor() {
    fun mapTeamToEntity(awayTeam: Team):AwayTeamEntity =
        AwayTeamEntity(
            awayTeamId = awayTeam.id,
            awayTeamName = awayTeam.name
        )

    fun mapEntityTeamToDomain(entity: AwayTeamEntity): Team =
        Team(
            id = entity.awayTeamId,
            name = entity.awayTeamName
        )
}