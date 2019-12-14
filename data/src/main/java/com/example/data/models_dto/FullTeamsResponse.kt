package com.example.data.models_dto

import com.google.gson.annotations.SerializedName

data class FullTeamsResponse(
    @SerializedName("teams")
    val teams:List<FullTeamDto>
)