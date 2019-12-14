package com.example.data

import com.example.domain.models.*
import java.util.*

fun createAwayTeamDomain():Team = Team(
    id = 1,
    name = "Tottenham Hotspur FC"
)

fun createHomeTeamDomain():Team = Team(
    id = 2,
    name = "Crystal Palace FC"
)

fun createFullTimeDomain(): MatchResult = MatchResult(
    awayTeam = 1,
    homeTeam = 2
)

fun createScoreDomain():Score = Score(
    duration = "REGULAR",
    winner = ScoreState.HOME_TEAM,
    fullTime = createFullTimeDomain()
)

fun creatMatch():Match = Match(
    awayTeam = createAwayTeamDomain(),
    homeTeam = createHomeTeamDomain(),
    date = Date(),
    status = MatchStatus.FINISHED,
    score = createScoreDomain(),
    isFavorite = true,
    id = 12
)