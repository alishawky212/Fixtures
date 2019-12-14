package com.example.domain.repository

import com.example.domain.models.Match
import io.reactivex.Single

interface MatchesRepository {
    fun getMatches():Single<List<Match>>
}