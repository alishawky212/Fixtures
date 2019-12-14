package com.example.domain.useCases

import com.example.domain.repository.FavoriteRepository
import com.example.domain.useCases.getMatches.GetFavoriteMatchesUseCase
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Flowable
import org.junit.Before
import org.junit.Test

import org.mockito.Mockito

class GetFavoriteMatchesUseCaseTest {

    private lateinit var useCase: GetFavoriteMatchesUseCase
    private val mockRepository = mock<FavoriteRepository> {  }

    private val matchesList = listOf(creatMatch())

    @Before
    fun setUp() {
        useCase = GetFavoriteMatchesUseCase(mockRepository)
    }

    @Test
    fun getFavoriteMatches() {
        Mockito.`when`(mockRepository.getFavoriteMatches()).thenReturn(Flowable.just(matchesList))

        val test = useCase.get().test()

        verify(mockRepository).getFavoriteMatches()

        test.assertNoErrors()
        test.assertComplete()
        test.assertValueCount(1)
        test.assertValue(matchesList)
    }
}