package com.example.data.models_dto


import com.google.gson.annotations.SerializedName

data class FullTimeDTO(
    @SerializedName("awayTeam")
    val awayTeam: Int?,
    @SerializedName("homeTeam")
    val homeTeam: Int?
)