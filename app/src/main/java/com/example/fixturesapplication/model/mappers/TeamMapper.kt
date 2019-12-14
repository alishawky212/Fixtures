package com.example.fixturesapplication.model.mappers

import com.example.domain.models.Team
import com.example.fixturesapplication.model.TeamUIModel
import javax.inject.Inject

class TeamMapper @Inject constructor() {

    fun mapToPresentation(awayTeam: Team):TeamUIModel =
        TeamUIModel(
            id = awayTeam.id,
            name = awayTeam.name
        )

    fun mapToDomain(awayTeam: TeamUIModel): Team =
        Team(
            id = awayTeam.id,
            name = awayTeam.name
        )
}