package com.example.domain.useCases

import com.example.domain.repository.FavoriteRepository
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Completable
import org.junit.Test
import org.junit.Before
import org.mockito.Mockito

class RemoveMatchUseCaseTest {

    private lateinit var useCase: RemoveMatchFromFavoriteUseCase
    private val mockRepository = mock<FavoriteRepository> { }
    private val match = creatMatch()

    @Before
    fun setUp(){
        useCase = RemoveMatchFromFavoriteUseCase(mockRepository)
    }

    @Test
    fun removeMatch() {
        Mockito.`when`(mockRepository.removeMatch(match))
            .thenReturn(Completable.complete())

        useCase.removeMatch(match)

        verify(mockRepository).removeMatch(match)
    }
}