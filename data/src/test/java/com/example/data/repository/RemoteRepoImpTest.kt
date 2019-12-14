package com.example.data.repository

import com.example.data.creatMatch
import com.example.data.createCompitationResponseDto
import com.example.data.mappers.*
import com.example.data.remote.RemoteApis
import com.example.domain.repository.FavoriteRepository
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Flowable
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when` as _when

class RemoteRepoImpTest {

    private lateinit var remoteRepoImp: MatchesRepoImp
    private val localRepository = mock<FavoriteRepository>()
    private val mockApi = mock<RemoteApis>()
    private val mapper = MatchesMapper(
        TeamMapper(),
        ScoreMapper(FullTimeMapper())
    )

    private val remoteModel = createCompitationResponseDto()
    private val match = listOf(creatMatch())

    @Before
    fun setUp() {
        remoteRepoImp = MatchesRepoImp(mockApi, mapper)
    }

    @Test
    fun getMatches() {
        _when(mockApi.getMatches()).thenReturn(Single.just(remoteModel))
        _when(localRepository.getFavoriteMatches()).thenReturn(Flowable.just(match))

        val test = remoteRepoImp.getMatches().test()

        verify(mockApi).getMatches()
        test.assertValue(mapper.mapToDomain(remoteModel.matches))
    }
}