package com.example.domain.models

import java.util.*


data class Match(
    val id:Int,
    val awayTeam: Team,
    val homeTeam: Team,
    val score: Score,
    val status: MatchStatus,
    val date: Date,
    var isFavorite:Boolean
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Match

        if (id != other.id) return false
        if (awayTeam != other.awayTeam) return false
        if (homeTeam != other.homeTeam) return false
        if (date != other.date) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + awayTeam.hashCode()
        result = 31 * result + homeTeam.hashCode()
        result = 31 * result + date.hashCode()
        return result
    }
}
enum class MatchStatus{
    SCHEDULED , LIVE , IN_PLAY , PAUSED , FINISHED , POSTPONED , SUSPENDED , CANCELED
}