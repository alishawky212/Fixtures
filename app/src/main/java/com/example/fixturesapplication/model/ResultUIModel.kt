package com.example.fixturesapplication.model

import com.example.domain.models.ScoreState

data class ResultUIModel(
    val duration: String,
    val winner: ScoreState,
    val homeTeam:Int,
    val awayTeam:Int
)