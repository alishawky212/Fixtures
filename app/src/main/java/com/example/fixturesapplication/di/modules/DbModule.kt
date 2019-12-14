package com.example.fixturesapplication.di.modules

import android.content.Context
import androidx.room.Room
import com.example.data.db.MyDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {
    @Singleton
    @Provides
    fun provideMyDatabase(context: Context) = Room.databaseBuilder(context, MyDatabase::class.java, "mydatabase")
        .build()

    @Singleton
    @Provides
    fun provideAlbumDao(myDatabase: MyDatabase) = myDatabase.dataBaseDao()
}