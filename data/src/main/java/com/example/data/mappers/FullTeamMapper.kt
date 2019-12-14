package com.example.data.mappers

import com.example.data.models_dto.FullTeamDto
import com.example.domain.models.FullTeam
import javax.inject.Inject

class FullTeamMapper @Inject constructor() {
    fun mapToDomain(fullTeamDto: FullTeamDto) =
        FullTeam(fullTeamDto.id,fullTeamDto.crestUrl)

    fun mapListToDomain(fullTeamsDto: List<FullTeamDto>) =
        fullTeamsDto.map {
            mapToDomain(it)
        }
}