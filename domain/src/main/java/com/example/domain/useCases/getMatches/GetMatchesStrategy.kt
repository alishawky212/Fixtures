package com.example.domain.useCases.getMatches

import com.example.domain.models.Match
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Provider

interface GetMatchesStrategy {
    fun get(): Flowable<List<Match>>

    class Factory @Inject constructor(
        private val mutableMap: MutableMap<Type,Provider<GetMatchesStrategy>>
    ){
        fun get(type:Type):GetMatchesStrategy{
            return mutableMap[type]!!.get()
        }

        enum class Type{
            FAVORITE,FULL
        }
    }
}