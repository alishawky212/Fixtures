package com.example.data

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

private const val Server_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"
val serverFormat = SimpleDateFormat(Server_FORMAT, Locale.ENGLISH)


fun String.parseServerDate():Date{
    try {
        return serverFormat.parse(this)
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    return Date()
}

