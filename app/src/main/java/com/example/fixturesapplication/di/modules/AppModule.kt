package com.example.fixturesapplication.di.modules

import android.content.Context
import com.example.fixturesapplication.MyApplication
import dagger.Binds
import dagger.Module
import javax.inject.Singleton


@Module
abstract class AppModule {
    @Binds
    @Singleton
    internal abstract fun application(app: MyApplication): Context
}