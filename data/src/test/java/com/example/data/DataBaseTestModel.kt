package com.example.data

import com.example.data.db.entity.*
import com.example.domain.models.MatchStatus
import com.example.domain.models.ScoreState
import java.util.*

fun createAwayTeamEntity():AwayTeamEntity = AwayTeamEntity(
    awayTeamId = 1,
    awayTeamName = "Tottenham Hotspur FC"
)

fun createHomeTeamEntity():HomeTeamEntity = HomeTeamEntity(
    homeTeamId = 2,
    homeTeamName = "Crystal Palace FC"
)

fun createFullTimeEntity():FullTimeEntity = FullTimeEntity(
    awayTeam = 1,
    homeTeam = 2
)

fun createScoreEntity():ScoreEntity = ScoreEntity(
    duration = "REGULAR",
    winner = ScoreState.HOME_TEAM,
    fullTime = createFullTimeEntity()
)

fun creatMatchEntityModel():MatchEntity = MatchEntity(
    awayTeam = createAwayTeamEntity(),
    homeTeam = createHomeTeamEntity(),
    date = Date(),
    status = MatchStatus.FINISHED,
    score = createScoreEntity(),
    matchId = 12
)