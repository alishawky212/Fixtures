package com.example.data.mappers

import com.example.data.createHomeTeamDomain
import com.example.data.createHomeTeamEntity
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class HomeTeamEntityMapperTest {

    private lateinit var homeTeamEntityMapper: HomeTeamEntityMapper

    @Before
    fun setUp() {
        homeTeamEntityMapper = HomeTeamEntityMapper()
    }

    @Test
    fun mapHomeTeamToEnitiy() {
        val homeTeam = createHomeTeamDomain()
        val homeTeamEntity = homeTeamEntityMapper.mapHomeTeamToEnitiy(homeTeam)
        assertTrue(homeTeam.id == homeTeamEntity.homeTeamId)
    }

    @Test
    fun mapHomeTeamEntityToDomain() {
        val homeTeamEntity = createHomeTeamEntity()
        val homeTeamDomain = homeTeamEntityMapper.mapHomeTeamEntityToDomain(homeTeamEntity)
        assertTrue(homeTeamEntity.homeTeamId == homeTeamDomain.id)
    }
}