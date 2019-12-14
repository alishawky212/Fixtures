package com.example.fixturesapplication.model.mappers

import com.example.domain.models.MatchResult
import com.example.domain.models.Score
import com.example.fixturesapplication.model.ResultUIModel
import javax.inject.Inject

class ResultUIModelMapper @Inject constructor() {
    fun mapToPresentastion(score: Score): ResultUIModel =
        ResultUIModel(
            homeTeam = score.fullTime.homeTeam,
            awayTeam = score.fullTime.awayTeam,
            winner = score.winner,
            duration = score.duration
        )

    fun mapToDomain(result: ResultUIModel): Score =
        Score(
            fullTime = MatchResult(
                awayTeam = result.awayTeam,
                homeTeam = result.homeTeam
            ),
            duration = result.duration,
            winner = result.winner
        )
}