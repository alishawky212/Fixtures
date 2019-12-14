package com.example.domain.useCases

import com.example.domain.repository.FavoriteRepository
import com.example.domain.repository.MatchesRepository
import com.example.domain.useCases.getMatches.GetFullMatchesUseCase
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Flowable
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import java.util.*

class GetMatchesUseCaseTest {

    private lateinit var useCase: GetFullMatchesUseCase
    private val mockRepository = mock<MatchesRepository> {}
    private val mockFavoritRepo = mock<FavoriteRepository>()
    private val calendar = Calendar.getInstance()

    private val matchesList = listOf(creatMatch())

    @Before
    fun setUp() {
        useCase =
            GetFullMatchesUseCase(mockRepository, mockFavoritRepo, calendar)
    }

    @Test
    fun getRemoteMatches() {
        Mockito.`when`(mockRepository.getMatches()).thenReturn(Single.just(matchesList))
        Mockito.`when`(mockFavoritRepo.getFavoriteMatches()).thenReturn(Flowable.just(matchesList))

        val test = useCase.get().test()

        verify(mockRepository).getMatches()

        test.assertNoErrors()
        test.assertComplete()
        test.assertValueCount(1)
        test.assertValue(matchesList)

    }
}