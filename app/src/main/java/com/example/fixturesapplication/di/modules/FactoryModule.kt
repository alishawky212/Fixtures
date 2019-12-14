package com.example.fixturesapplication.di.modules

import androidx.lifecycle.ViewModel
import com.example.domain.useCases.getMatches.GetFavoriteMatchesUseCase
import com.example.domain.useCases.getMatches.GetFullMatchesUseCase
import com.example.domain.useCases.getMatches.GetMatchesStrategy
import com.example.fixturesapplication.di.StrategyKey
import com.example.fixturesapplication.viewModel.MatchesViewModel
import com.example.fixturesapplication.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FactoryModule {
    @Binds
    @IntoMap
    @ViewModelKey(MatchesViewModel::class)
    internal abstract fun bindMatchesViewModel(masterViewModel: MatchesViewModel): ViewModel


    @Binds
    @IntoMap
    @StrategyKey(GetMatchesStrategy.Factory.Type.FAVORITE)
    abstract fun bindFavoriteStrategy(favoriteMatchesUseCase: GetFavoriteMatchesUseCase):GetMatchesStrategy

    @Binds
    @IntoMap
    @StrategyKey(GetMatchesStrategy.Factory.Type.FULL)
    abstract fun bindFullStratgey(getFullMatchesUseCase: GetFullMatchesUseCase):GetMatchesStrategy
}
