package com.example.data.models_dto


import com.google.gson.annotations.SerializedName

data class AreaDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)