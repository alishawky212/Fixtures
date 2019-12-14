package com.example.data.mappers

import com.example.data.db.entity.ScoreEntity
import com.example.data.models_dto.ScoreDTO
import com.example.domain.models.Score
import com.example.domain.models.ScoreState
import javax.inject.Inject

class ScoreMapper @Inject constructor(
    private val fullTimeMapper: FullTimeMapper
){
    fun mapToDomain(scoreDTO: ScoreDTO):Score =
        Score(
            duration = scoreDTO.duration,
            fullTime = fullTimeMapper.mapToDomain(scoreDTO.fullTime),
            winner = scoreDTO.winner ?: ScoreState.NOT_PLAYED
        )
}