package com.example.fixturesapplication.di.modules

import com.example.data.repository.FavoriteRepoImpl
import com.example.data.repository.MatchesRepoImp
import com.example.domain.repository.FavoriteRepository
import com.example.domain.repository.MatchesRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindMatchsRepository(repositoryImpl: MatchesRepoImp): MatchesRepository

    @Binds
    @Singleton
    abstract fun bindLocalRepository(localRepoImpl: FavoriteRepoImpl):FavoriteRepository
}