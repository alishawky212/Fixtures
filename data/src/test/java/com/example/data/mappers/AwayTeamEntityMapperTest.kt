package com.example.data.mappers

import com.example.data.createAwayTeamDomain
import com.example.data.createAwayTeamEntity
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class AwayTeamEntityMapperTest {

    private lateinit var awayTeamEntityMapper: TeamEntityMapper

    @Before
    fun setUp() {
        awayTeamEntityMapper = TeamEntityMapper()
    }

    @Test
    fun mapAwayTeamToEntity() {
        val awayTeamDomain = createAwayTeamDomain()
       val awayTeamEntity = awayTeamEntityMapper.mapTeamToEntity(awayTeamDomain)
        assertTrue(awayTeamEntity.awayTeamId == awayTeamDomain.id)
    }

    @Test
    fun mapAwayEntityTeamToDomain() {
        val awayTeamEntity = createAwayTeamEntity()
        val awayTeamDomain = awayTeamEntityMapper.mapEntityTeamToDomain(awayTeamEntity)
        assertTrue(awayTeamEntity.awayTeamId == awayTeamDomain.id)

    }
}