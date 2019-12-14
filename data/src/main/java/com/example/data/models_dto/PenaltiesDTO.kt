package com.example.data.models_dto


import com.google.gson.annotations.SerializedName

data class PenaltiesDTO(
    @SerializedName("awayTeam")
    val awayTeam: Any,
    @SerializedName("homeTeam")
    val homeTeam: Any
)