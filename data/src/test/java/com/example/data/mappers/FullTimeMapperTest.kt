package com.example.data.mappers

import com.example.data.createFullTimeDTO
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class FullTimeMapperTest {

    private lateinit var fullTimeMapper: FullTimeMapper

    @Before
    fun setUp() {
        fullTimeMapper = FullTimeMapper()
    }

    @Test
    fun mapToDomain() {
        val fullTimeDTO = createFullTimeDTO()
        val fullTimeDomain = fullTimeMapper.mapToDomain(fullTimeDTO)
        assertTrue(fullTimeDTO.awayTeam == fullTimeDomain.awayTeam)
    }
}