package com.example.domain.useCases

import com.example.domain.repository.FavoriteRepository
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Completable
import org.junit.Before
import org.junit.Test

import org.mockito.Mockito

class SaveMatchUseCaseTest {

    private lateinit var useCase: AddMatchToFavoriteUseCase
    private val mockRepository = mock<FavoriteRepository> {  }

    @Before
    fun setUp() {
        useCase = AddMatchToFavoriteUseCase(mockRepository)
    }

    @Test
    fun favoriteMatch() {
        Mockito.`when`(mockRepository.removeMatch(creatMatch()))
            .thenReturn(Completable.complete())

        useCase.favoriteMatch(creatMatch())

        verify(mockRepository).insertMatch(creatMatch())

    }
}