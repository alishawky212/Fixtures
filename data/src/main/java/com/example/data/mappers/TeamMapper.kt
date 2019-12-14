package com.example.data.mappers

import com.example.data.models_dto.TeamDTO
import com.example.domain.models.Team
import javax.inject.Inject

class TeamMapper @Inject constructor(){
    fun mapToDomain(awayTeamDTO: TeamDTO):Team =
        Team(
            id = awayTeamDTO.id,
            name = awayTeamDTO.name
        )
}