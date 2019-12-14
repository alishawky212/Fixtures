package com.example.data.models_dto

import com.google.gson.annotations.SerializedName

data class FullTeamDto (
    val id: Int = 0,
    @SerializedName("crestUrl")
    val crestUrl: String
)
