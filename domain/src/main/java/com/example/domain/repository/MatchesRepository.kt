package com.example.domain.repository

import com.example.domain.models.FullTeam
import com.example.domain.models.Match
import io.reactivex.Single

interface MatchesRepository {
    fun getMatches():Single<List<Match>>
    fun getTeamById():Single<List<FullTeam>>
}