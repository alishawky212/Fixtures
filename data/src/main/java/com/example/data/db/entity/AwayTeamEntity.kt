package com.example.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AwayTeamEntity(
    @PrimaryKey
    val awayTeamId: Int,
    val awayTeamName: String,
    val awayTeamImage:String
)