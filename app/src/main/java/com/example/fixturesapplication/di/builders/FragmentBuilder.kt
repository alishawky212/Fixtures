package com.example.fixturesapplication.di.builders


import com.example.fixturesapplication.view.MatchesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentBuilder {
    @ContributesAndroidInjector
    fun bindMasterFragment(): MatchesFragment
}