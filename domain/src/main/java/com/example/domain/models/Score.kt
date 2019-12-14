package com.example.domain.models

data class Score(
    val duration: String,
    val fullTime: MatchResult,
    val winner: ScoreState
)

enum class ScoreState{
    HOME_TEAM,AWAY_TEAM,DRAW,NOT_PLAYED
}