package com.example.data.mappers

import com.example.data.db.entity.HomeTeamEntity
import com.example.domain.models.Team
import javax.inject.Inject

class HomeTeamEntityMapper @Inject constructor() {
    fun mapHomeTeamToEnitiy(homeTeam: Team): HomeTeamEntity =
        HomeTeamEntity(
            homeTeamId = homeTeam.id,
            homeTeamName = homeTeam.name,
            homeTeamImage = homeTeam.img
        )

    fun mapHomeTeamEntityToDomain(entity: HomeTeamEntity): Team =
        Team(
            id = entity.homeTeamId,
            name = entity.homeTeamName,
            img = entity.homeTeamImage
        )
}