package com.example.fixturesapplication.model.mappers

import com.example.fixturesapplication.model.DateItem
import java.text.SimpleDateFormat
import java.util.*

private const val UI_DATE_FORMAT = "dd-MM-yyyy"
val dateFormatter = SimpleDateFormat(UI_DATE_FORMAT,Locale.ENGLISH)

private const val TIME_FORMAT = "hh:mm"
val timeFormatter = SimpleDateFormat(TIME_FORMAT,Locale.ENGLISH)

fun Date.map():DateItem{
    return DateItem(dateFormatter.format(this))
}

fun Date.formatToTime():String{
    return timeFormatter.format(this)
}

