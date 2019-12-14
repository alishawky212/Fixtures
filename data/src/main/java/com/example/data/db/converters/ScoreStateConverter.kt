package com.example.data.db.converters

import androidx.room.TypeConverter
import com.example.domain.models.ScoreState

class ScoreStateConverter {
    @TypeConverter
    fun scoreStatusToTnt(value: ScoreState) = value.toInt()
    @TypeConverter
    fun intToScoreStatus(value: Int) = value.toEnum<ScoreState>()
}