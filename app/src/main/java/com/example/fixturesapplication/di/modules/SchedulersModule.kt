package com.example.fixturesapplication.di.modules

import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named

const val IO_SCHEDULER = "IO_SCHEDULER"
const val MAIN_THREAD_SCHEDULER = "MAIN_THREAD_SCHEDULER"
@Module
class SchedulersModule {
    @Provides
    @Named(value = IO_SCHEDULER)
    fun bindIoScheduler() = Schedulers.io()

    @Provides
    @Named(value = MAIN_THREAD_SCHEDULER)
    fun bindMainThreadScheduler() = AndroidSchedulers.mainThread()
}