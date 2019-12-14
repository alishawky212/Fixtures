package com.example.fixturesapplication.model

import com.example.domain.models.MatchStatus
import java.util.*

data class MatchUIModel(
    val id:Int,
    val homeTeam:TeamUIModel,
    val awayTeam:TeamUIModel,
    val time:String,
    val date:Date,
    val status: MatchStatus,
    val result: ResultUIModel,
    val isFavorite:Boolean
):ListItem() {
    override fun getType() = ItemType.TYPE_GENERAL
}