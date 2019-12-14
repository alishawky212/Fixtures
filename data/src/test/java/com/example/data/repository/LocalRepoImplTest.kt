package com.example.data.repository

import com.example.data.creatMatch
import com.example.data.creatMatchEntityModel
import com.example.data.db.dao.DataBaseDao
import com.example.data.mappers.*
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when` as _when


class LocalRepoImplTest {

    private lateinit var localRepoImpl: FavoriteRepoImpl
    private val dao = mock<DataBaseDao> {  }
    private val mapper = MatchEntityMapper(
        awayTeamEntityMapper = TeamEntityMapper(),
        homeTeamEntityMapper = HomeTeamEntityMapper(),
        scoreEntityMapper = ScoreEntityMapper(
            fullTimeEntityMapper = FullTimeEntityMapper()
        )
    )
    private val favoriteMatches = listOf(creatMatchEntityModel())
    private val favoriteEntity = creatMatchEntityModel()
    private val match = creatMatch()


    @Before
    fun setUp() {
        localRepoImpl = FavoriteRepoImpl(
            dao = dao,
            matchEntityMapper = mapper
        )
    }

    @Test
    fun isFavorite() {
        _when(dao.get(id = 1)).thenReturn(Single.just(favoriteMatches))
        val test = localRepoImpl.isFavorite(1).test()
        verify(dao).get(1)
        test.assertValue(mapper.mapMatchsToDomain(favoriteMatches))
    }

    @Test
    fun getFavoriteMatches() {
        _when(dao.getFavoriteMatches()).thenReturn(Flowable.just(favoriteMatches))
        val test = localRepoImpl.getFavoriteMatches().test()
        verify(dao).getFavoriteMatches()
        test.assertValue(mapper.mapMatchsToDomain(favoriteMatches))

    }

    @Test
    fun removeMatch() {
        _when(dao.delete(favoriteEntity)).thenReturn(Completable.complete())
        val test = localRepoImpl.removeMatch(match).test()
        verify(dao).delete(favoriteEntity)
        test.assertNoErrors()
        test.assertComplete()
    }

    @Test
    fun insertMatch() {
        _when(dao.insertMatch(favoriteEntity)).thenReturn(Completable.complete())
        val test = localRepoImpl.insertMatch(match).test()
        verify(dao).insertMatch(favoriteEntity)
        test.assertComplete()
    }
}