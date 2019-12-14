package com.example.domain.useCases

import com.example.domain.models.*
import java.util.*

fun createAwayTeam():Team = Team(
    id = 1,
    name = "Tottenham Hotspur FC"
)

fun createHomeTeam():Team = Team(
    id = 2,
    name = "Crystal Palace FC"
)

fun creatFullTime(): MatchResult = MatchResult(
    awayTeam = 1,
    homeTeam = 2
)

fun createScore():Score = Score(
    duration = "REGULAR",
    winner = ScoreState.HOME_TEAM,
    fullTime = creatFullTime()
)

fun creatMatch():Match = Match(
    awayTeam = createAwayTeam(),
    homeTeam = createHomeTeam(),
    date = Date(),
    status = MatchStatus.FINISHED,
    score = createScore(),
    isFavorite = true,
    id = 1
)