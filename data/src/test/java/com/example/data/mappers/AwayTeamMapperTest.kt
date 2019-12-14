package com.example.data.mappers

import com.example.data.createAwayTeamDTO
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class AwayTeamMapperTest {

    private lateinit var awayTeamMapper: TeamMapper

    @Before
    fun setUp() {
        awayTeamMapper = TeamMapper()
    }

    @Test
    fun mapToDomain() {
        val awayTeamDTO = createAwayTeamDTO()
        val awayTeamEntity = awayTeamMapper.mapToDomain(awayTeamDTO)
        assertTrue(awayTeamDTO.name == awayTeamEntity.name)
    }
}