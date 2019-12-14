package com.example.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "full_time_table")
data class FullTimeEntity(
    @PrimaryKey(autoGenerate = true)
    val fullTimeId:Int = 0,
    val awayTeam: Int,
    val homeTeam: Int
)