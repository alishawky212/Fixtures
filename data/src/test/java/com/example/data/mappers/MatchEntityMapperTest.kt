package com.example.data.mappers

import com.example.data.creatMatch
import com.example.data.creatMatchEntityModel
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class MatchEntityMapperTest {

    private lateinit var matchEntityMapper: MatchEntityMapper
    private val awayTeamMapper = TeamEntityMapper()
    private val homeTeamMapper = HomeTeamEntityMapper()
    private val fullTimeEntityMapper = FullTimeEntityMapper()
    private val scoreEntityMapper = ScoreEntityMapper(fullTimeEntityMapper)


    @Before
    fun setUp() {
        matchEntityMapper = MatchEntityMapper(awayTeamMapper,homeTeamMapper,scoreEntityMapper)
    }

    @Test
    fun mapMatchToMatchEntity() {
        val match = creatMatch()
        val matchEntity = matchEntityMapper.mapMatchToMatchEntity(match)
        assertTrue(match.id == matchEntity.matchId)
    }

    @Test
    fun mapMatchsToDomain() {
        val matchEntity = creatMatchEntityModel()
        val match = matchEntityMapper.mapEntityToDomain(matchEntity)
        assertTrue(matchEntity.matchId == match.id)
    }
}