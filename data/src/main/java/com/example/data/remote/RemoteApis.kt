package com.example.data.remote

import com.example.data.models_dto.CompetitionResponseDTO
import com.example.data.models_dto.FullTeamDto
import com.example.data.models_dto.FullTeamsResponse
import com.example.data.models_dto.FullTimeDTO
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteApis {
    @GET("competitions/2021/matches")
    fun getMatches():Single<CompetitionResponseDTO>

    @GET("competitions/2021/teams")
    fun getTeam(): Single<FullTeamsResponse>
}