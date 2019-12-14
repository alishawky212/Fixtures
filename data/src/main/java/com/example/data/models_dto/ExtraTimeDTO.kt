package com.example.data.models_dto


import com.google.gson.annotations.SerializedName

data class ExtraTimeDTO(
    @SerializedName("awayTeam")
    val awayTeam: Int?,
    @SerializedName("homeTeam")
    val homeTeam: Int?
)