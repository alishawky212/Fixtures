package com.example.fixturesapplication.di.modules

import dagger.Module
import dagger.Provides
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Singleton

private const val Server_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"

@Module
class DateModule {
    @Provides
    @Singleton
    fun provideCalender():Calendar{
        return Calendar.getInstance()
    }

    @Provides
    @Singleton
    fun provideDateFormate():SimpleDateFormat{
        return SimpleDateFormat(Server_FORMAT, Locale.ENGLISH)
    }
}