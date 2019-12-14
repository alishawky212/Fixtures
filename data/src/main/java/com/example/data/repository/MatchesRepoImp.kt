package com.example.data.repository

import com.example.data.mappers.MatchesMapper
import com.example.data.models_dto.MatchDTO
import com.example.data.remote.RemoteApis
import com.example.domain.models.Match
import com.example.domain.repository.FavoriteRepository
import com.example.domain.repository.MatchesRepository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class MatchesRepoImp @Inject constructor(
    private val remoteApis: RemoteApis,
    private val mapper: MatchesMapper
) : MatchesRepository {
    override fun getMatches(): Single<List<Match>> = remoteApis.getMatches().toObservable()
        .map {
            it.matches
        }.flatMap {
            return@flatMap Observable.fromIterable(it)
        }.map {
            mapper.mapToDomain(it)
        }.toList()
}
