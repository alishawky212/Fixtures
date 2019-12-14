package com.example.data.models_dto

import com.example.domain.models.ScoreState
import com.google.gson.annotations.SerializedName

data class ScoreDTO(
    @SerializedName("duration")
    val duration: String,
    @SerializedName("extraTime")
    val extraTime: ExtraTimeDTO,
    @SerializedName("fullTime")
    val fullTime: FullTimeDTO,
    @SerializedName("halfTime")
    val halfTime: HalfTimeDTO,
    @SerializedName("penalties")
    val penalties: PenaltiesDTO,
    @SerializedName("winner")
    val winner: ScoreState?
)