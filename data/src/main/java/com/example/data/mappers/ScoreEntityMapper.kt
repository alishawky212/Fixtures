package com.example.data.mappers

import com.example.data.db.entity.ScoreEntity
import com.example.domain.models.Score
import javax.inject.Inject

class ScoreEntityMapper @Inject constructor(
    private val fullTimeEntityMapper: FullTimeEntityMapper
) {
    fun mapScoreToEntity(score: Score):ScoreEntity =
        ScoreEntity(
            duration = score.duration,
            fullTime = fullTimeEntityMapper.mapFullTimeToEntity(score.fullTime),
            winner = score.winner
        )

    fun mapScoreToDomain(scoreEntity: ScoreEntity): Score =
        Score(
            duration = scoreEntity.duration,
            winner = scoreEntity.winner,
            fullTime = fullTimeEntityMapper.mapEntityToDomain(scoreEntity.fullTime)
        )
}