package com.example.fixturesapplication

import com.example.domain.models.*
import com.example.fixturesapplication.model.DateItem
import com.example.fixturesapplication.model.MatchUIModel
import com.example.fixturesapplication.model.ResultUIModel
import com.example.fixturesapplication.model.TeamUIModel
import java.util.*

fun createDateItem() = DateItem("23-11-2019")

fun createAwayTeam() = TeamUIModel(
    id = 1,
    name = "Tottenham Hotspur FC"
)

fun createHomeTeam() = TeamUIModel(
    id = 2,
    name = "Crystal Palace FC"
)

fun createResultModel() = ResultUIModel(
    duration = "REGULAR",
    awayTeam = 1,
    homeTeam = 2,
    winner = ScoreState.HOME_TEAM
)

fun createMatchModel() = MatchUIModel(
    id = 11,
    date = Date(),
    homeTeam = createHomeTeam(),
    awayTeam = createAwayTeam(),
    status = MatchStatus.FINISHED,
    isFavorite = false,
    time = "03:00",
    result = createResultModel()
)


fun createAwayTeamDomain(): Team = Team(
    id = 1,
    name = "Tottenham Hotspur FC"
)

fun createHomeTeamDomain(): Team = Team(
    id = 2,
    name = "Crystal Palace FC"
)

fun creatFullTimeDomain(): MatchResult = MatchResult(
    awayTeam = 1,
    homeTeam = 2
)

fun createScoreDomain(): Score = Score(
    duration = "REGULAR",
    winner = ScoreState.HOME_TEAM,
    fullTime = creatFullTimeDomain()
)

fun creatMatchDomain(): Match = Match(
    awayTeam = createAwayTeamDomain(),
    homeTeam = createHomeTeamDomain(),
    date = Date(),
    status = MatchStatus.FINISHED,
    score = createScoreDomain(),
    isFavorite = true,
    id = 1
)