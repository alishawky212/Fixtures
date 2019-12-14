package com.example.data.db.dao

import androidx.room.*
import com.example.data.db.entity.MatchEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface DataBaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMatch(matchEntity: MatchEntity):Completable

    @Query("SELECT * FROM MatchEntity")
    fun getFavoriteMatches():Flowable<List<MatchEntity>>

    @Update
    fun updateMatch(matchEntity: MatchEntity):Completable

    @Delete
    fun delete(matchEntity: MatchEntity):Completable

    @Query(value = "SELECT * FROM MatchEntity where matchId LIKE :id")
    fun get(id:Int): Single<List<MatchEntity>>
}