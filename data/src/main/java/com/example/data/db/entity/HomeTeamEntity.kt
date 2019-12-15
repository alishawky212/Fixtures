package com.example.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HomeTeamEntity(
    @PrimaryKey
    val homeTeamId: Int,
    val homeTeamName: String,
    val homeTeamImage:String
)