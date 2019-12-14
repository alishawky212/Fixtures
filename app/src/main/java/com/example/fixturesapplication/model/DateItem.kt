package com.example.fixturesapplication.model

data class DateItem(
    val date:String
):ListItem() {
    override fun getType() = ItemType.TYPE_DATE
}