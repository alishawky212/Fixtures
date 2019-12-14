package com.example.fixturesapplication.di

import com.example.domain.useCases.getMatches.GetMatchesStrategy
import dagger.MapKey

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class StrategyKey(val value: GetMatchesStrategy.Factory.Type)