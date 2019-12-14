package com.example.fixturesapplication.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.domain.repository.FavoriteRepository
import com.example.domain.repository.MatchesRepository
import com.example.domain.useCases.AddMatchToFavoriteUseCase
import com.example.domain.useCases.RemoveMatchFromFavoriteUseCase
import com.example.domain.useCases.getMatches.GetFavoriteMatchesUseCase
import com.example.domain.useCases.getMatches.GetFullMatchesUseCase
import com.example.domain.useCases.getMatches.GetMatchesStrategy
import com.example.fixturesapplication.creatMatchDomain
import com.example.fixturesapplication.createMatchModel
import com.example.fixturesapplication.model.MatchUIModel
import com.example.fixturesapplication.model.UIState
import com.example.fixturesapplication.model.mappers.MatchUIMapper
import com.example.fixturesapplication.model.mappers.ResultUIModelMapper
import com.example.fixturesapplication.model.mappers.TeamMapper
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.Rule
import java.util.*
import javax.inject.Provider
import org.mockito.Mockito.`when` as _when


class MatchesViewModelTest {

    private lateinit var favoriteMatchesUseCase:AddMatchToFavoriteUseCase
    private lateinit var removeMatchUseCase:RemoveMatchFromFavoriteUseCase
    private val matchesRepository = mock<MatchesRepository> {}
    private val localRepository = mock<FavoriteRepository>{}
    private val teamMapper = TeamMapper()
    private val resultMapper = ResultUIModelMapper()
    private val matchUiMapper = MatchUIMapper(resultMapper,teamMapper)
    private lateinit var matchesViewModel: MatchesViewModel
    private val factory = GetMatchesStrategy.Factory(mutableMapOf(GetMatchesStrategy.Factory.Type.FULL to Provider<GetMatchesStrategy> {
        return@Provider GetFullMatchesUseCase(matchesRepository, localRepository,Calendar.getInstance())
    }, GetMatchesStrategy.Factory.Type.FAVORITE to Provider<GetMatchesStrategy> {
        return@Provider GetFavoriteMatchesUseCase(localRepository)
    }))
    private val getMatchesStrategy = mock<GetMatchesStrategy> {}

    private val matches = listOf(creatMatchDomain())

    @get:Rule
    var rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        favoriteMatchesUseCase = AddMatchToFavoriteUseCase(localRepository)
        removeMatchUseCase = RemoveMatchFromFavoriteUseCase(localRepository)
        matchesViewModel = MatchesViewModel(
            factory = factory,
            matchUIMapper = matchUiMapper,
            ioScheduler = Schedulers.trampoline(),
            removeMatchUseCase = removeMatchUseCase,
            saveMatchUseCase = favoriteMatchesUseCase)


    }

    @Test
    fun getMatchesRemote() {
        matchesViewModel.type = GetMatchesStrategy.Factory.Type.FULL
        _when(getMatchesStrategy.get()).thenReturn(Flowable.just(matches))
        _when(localRepository.getFavoriteMatches()).thenReturn(Flowable.just(listOf(creatMatchDomain())))
        _when(matchesRepository.getMatches()).thenReturn(Single.just(listOf(creatMatchDomain())))
        getMatchesStrategy.get()
        matchesViewModel.getMatches()
        val result = matchesViewModel.matchesLiveData.value
        Assert.assertEquals(creatMatchDomain().id, ((result as UIState.SuccessState).data[1] as MatchUIModel).id )
    }


    @Test
    fun getMatchesLocal(){
        matchesViewModel.type = GetMatchesStrategy.Factory.Type.FAVORITE
        _when(getMatchesStrategy.get()).thenReturn(Flowable.just(matches))
        _when(localRepository.getFavoriteMatches()).thenReturn(Flowable.just(matches))

        matchesViewModel.getMatches()

        val result = matchesViewModel.matchesLiveData.value
        Assert.assertEquals(creatMatchDomain().id, ((result as UIState.SuccessState).data[1] as MatchUIModel).id )
    }
}