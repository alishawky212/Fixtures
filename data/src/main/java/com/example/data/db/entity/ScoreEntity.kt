package com.example.data.db.entity


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.data.db.converters.ScoreStateConverter
import com.example.domain.models.ScoreState

@Entity
@TypeConverters(ScoreStateConverter::class)
data class ScoreEntity(
    @PrimaryKey(autoGenerate = true)
    val scoreId:Int = 0,
    val duration: String,
    @Embedded
    val fullTime: FullTimeEntity,
    val winner: ScoreState
)