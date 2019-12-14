package com.example.data.db.entity

import androidx.room.*
import com.example.data.db.converters.DateConverter
import com.example.data.db.converters.StatusConverter
import com.example.domain.models.MatchStatus
import java.util.*

@Entity
@TypeConverters(StatusConverter::class, DateConverter::class)
data class MatchEntity(
    @PrimaryKey
    val matchId:Int,
    @Embedded
    val awayTeam: AwayTeamEntity,
    @Embedded
    val homeTeam: HomeTeamEntity,
    @Embedded
    val score: ScoreEntity,
    val status: MatchStatus,
    val date: Date
)
