package com.example.data.repository

import com.example.data.db.dao.DataBaseDao
import com.example.data.mappers.MatchEntityMapper
import com.example.domain.models.Match
import com.example.domain.repository.FavoriteRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class FavoriteRepoImpl @Inject constructor(
    private val dao: DataBaseDao,
    private val matchEntityMapper: MatchEntityMapper
):FavoriteRepository {

    override fun updateMatch(match: Match): Completable {
        return dao.updateMatch(matchEntityMapper.mapMatchToMatchEntity(match))
    }

    override fun isFavorite(id: Int): Single<List<Match>> {
        return dao.get(id).map { matchEntityMapper.mapMatchsToDomain(it) }

    }

    override fun getFavoriteMatches(): Flowable<List<Match>> {
        return dao.getFavoriteMatches().map { matchEntityMapper.mapMatchsToDomain(it) }
    }

    override fun removeMatch(match: Match) :Completable{
        return dao.delete(matchEntityMapper.mapMatchToMatchEntity(match))
    }

    override fun insertMatch(match: Match): Completable {
        return dao.insertMatch(matchEntityMapper.mapMatchToMatchEntity(match))
    }
}