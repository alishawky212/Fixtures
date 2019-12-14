package com.example.data.models_dto

import com.example.domain.models.MatchStatus
import com.google.gson.annotations.SerializedName

data class MatchDTO(
    @SerializedName("awayTeam")
    val awayTeam: TeamDTO,
    @SerializedName("group")
    val group: String,
    @SerializedName("homeTeam")
    val homeTeam: TeamDTO,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lastUpdated")
    val lastUpdated: String,
    @SerializedName("matchday")
    val matchday: Int,
    @SerializedName("referees")
    val referees: List<Any>,
    @SerializedName("score")
    val score: ScoreDTO,
    @SerializedName("season")
    val season: SeasonDTO,
    @SerializedName("stage")
    val stage: String,
    @SerializedName("status")
    val status: MatchStatus,
    @SerializedName("utcDate")
    val utcDate: String,
    var isFavorite:Boolean
)
