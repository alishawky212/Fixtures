package com.example.data

import com.example.data.models_dto.*
import com.example.domain.models.MatchStatus
import com.example.domain.models.ScoreState

fun createAwayTeamDTO() = TeamDTO(
    id = 11,
    name = "Tottenham Hotspur FC"
)

fun createFullTimeDTO() = FullTimeDTO(
    awayTeam = 1,
    homeTeam = 1
)

fun createExtraTimeDTO() = ExtraTimeDTO(
    awayTeam = null,
    homeTeam = null
)

fun createHomeTeamDTO() = TeamDTO(
    id = 12,
    name = "Crystal Palace FC"
)

fun createHalfTimeDTO() = HalfTimeDTO(
    awayTeam = 0,
    homeTeam = 1
)

fun createPenaltiesDTO() = PenaltiesDTO(
    awayTeam = 0,
    homeTeam = 0
)

fun createScoreDTO() = ScoreDTO(
    extraTime = createExtraTimeDTO(),
    fullTime = createFullTimeDTO(),
    winner = ScoreState.DRAW,
    duration = "REGULAR",
    halfTime = createHalfTimeDTO(),
    penalties = createPenaltiesDTO()
)

fun createSeasonDTO() = SeasonDTO(
    currentMatchday = 5,
    id = 14,
    endDate = "2020-05-17",
    startDate = "2019-08-09"
)

fun createMatchDTO() = MatchDTO(
    awayTeam = createAwayTeamDTO(),
    id = 1,
    homeTeam = createHomeTeamDTO(),
    isFavorite = false,
    utcDate = "2020-05-17T00:00:00Z",
    status = MatchStatus.FINISHED,
    score = createScoreDTO(),
    group = "",
    lastUpdated = "",
    matchday = 5,
    referees = listOf(),
    season = createSeasonDTO(),
    stage = ""
)
fun createAreaDto() = AreaDTO(
    id = 1,
    name = "England"
)

fun createMatchCompetitionDTO() = CompetitionDTO(
    area = createAreaDto(),
    name = "Premier League",
    id = 2021,
    lastUpdated = "2019-11-11T12:40:04Z",
    code = "PL",
    plan = "TIER_ONE"
)

fun createCompitationResponseDto() =
    CompetitionResponseDTO(
        competition = createMatchCompetitionDTO(),
        count = 380,
        filters = FiltersDTO(),
        matches = listOf(createMatchDTO())
    )