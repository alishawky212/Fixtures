package com.example.data.models_dto


import com.google.gson.annotations.SerializedName

data class CompetitionResponseDTO(
    @SerializedName("competition")
    val competition: CompetitionDTO,
    @SerializedName("count")
    val count: Int,
    @SerializedName("filters")
    val filters: FiltersDTO,
    @SerializedName("matches")
    val matches: List<MatchDTO>
)