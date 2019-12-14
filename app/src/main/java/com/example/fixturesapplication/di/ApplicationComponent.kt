package com.example.fixturesapplication.di

import com.example.fixturesapplication.MyApplication
import com.example.fixturesapplication.di.builders.FragmentBuilder
import com.example.fixturesapplication.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class, NetworkModule::class,
    SchedulersModule::class,FragmentBuilder::class,
    DbModule::class,FactoryModule::class,
    RepositoryModule::class,DateModule::class,AppModule::class])
interface ApplicationComponent {
    fun inject(app: MyApplication)
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MyApplication): Builder
        fun build(): ApplicationComponent
    }
}