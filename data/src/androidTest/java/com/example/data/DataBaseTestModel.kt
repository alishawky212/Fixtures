package com.example.data

import com.example.data.db.entity.*
import com.example.domain.models.MatchStatus
import com.example.domain.models.ScoreState

fun createAwayTeam():AwayTeamEntity = AwayTeamEntity(
    awayTeamId = 1,
    awayTeamName = "Tottenham Hotspur FC"
)

fun createHomeTeam():HomeTeamEntity = HomeTeamEntity(
    homeTeamId = 2,
    homeTeamName = "Crystal Palace FC"
)

fun creatFullTime():FullTimeEntity = FullTimeEntity(
    awayTeam = 1,
    homeTeam = 2
)

fun createScore():ScoreEntity = ScoreEntity(
    duration = "REGULAR",
    winner = ScoreState.HOME_TEAM,
    fullTime = creatFullTime()
)

fun creatMatchEntity():MatchEntity = MatchEntity(
    awayTeam = createAwayTeam(),
    homeTeam = createHomeTeam(),
    utcDate = "2020-05-17T00:00:00Z",
    status = MatchStatus.FINISHED,
    score = createScore(),
    matchId = 12
)