package com.example.data.models_dto

import com.google.gson.annotations.SerializedName

data class CompetitionDTO(
    @SerializedName("area")
    val area: AreaDTO,
    @SerializedName("code")
    val code: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lastUpdated")
    val lastUpdated: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("plan")
    val plan: String
)