package com.example.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.db.dao.DataBaseDao
import com.example.data.db.entity.*

@Database(entities = [
    FullTimeEntity::class,
    AwayTeamEntity::class,
    HomeTeamEntity::class,
    MatchEntity::class,
   ScoreEntity::class],version = 1, exportSchema = true)
abstract class MyDatabase : RoomDatabase() {

    abstract fun dataBaseDao(): DataBaseDao
}