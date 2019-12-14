package com.example.data.models_dto


import com.google.gson.annotations.SerializedName

data class SeasonDTO(
    @SerializedName("currentMatchday")
    val currentMatchday: Int,
    @SerializedName("endDate")
    val endDate: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("startDate")
    val startDate: String
)