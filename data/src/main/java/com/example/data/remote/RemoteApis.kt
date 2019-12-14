package com.example.data.remote

import com.example.data.models_dto.CompetitionResponseDTO
import io.reactivex.Single
import retrofit2.http.GET

interface RemoteApis {
    @GET("competitions/2021/matches")
    fun getMatches():Single<CompetitionResponseDTO>
}