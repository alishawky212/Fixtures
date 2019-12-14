package com.example.domain.repository

import com.example.domain.models.Match
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

interface FavoriteRepository {
    fun insertMatch(match: Match):Completable
    fun removeMatch(match: Match):Completable
    fun getFavoriteMatches():Flowable<List<Match>>
    fun isFavorite(id:Int):Single<List<Match>>
    fun updateMatch(match: Match):Completable
}