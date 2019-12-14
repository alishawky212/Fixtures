package com.example.data.db.converters

import androidx.room.TypeConverter
import com.example.domain.models.MatchStatus

class StatusConverter {
    @TypeConverter fun statusToTnt(value: MatchStatus) = value.toInt()
    @TypeConverter fun intTostatus(value: Int) = value.toEnum<MatchStatus>()

}

@Suppress("NOTHING_TO_INLINE")
inline fun <T : Enum<T>> T.toInt(): Int = this.ordinal

inline fun <reified T : Enum<T>> Int.toEnum(): T = enumValues<T>()[this]