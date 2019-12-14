package com.example.data.mappers

import com.example.data.createFullTimeDomain
import com.example.data.createFullTimeEntity
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class FullTimeEntityMapperTest {

    private lateinit var fullTimeEntityMapper: FullTimeEntityMapper

    @Before
    fun setUp() {
        fullTimeEntityMapper = FullTimeEntityMapper()
    }

    @Test
    fun mapFullTimeToEntity() {
        val fullTimeDomain = createFullTimeDomain()
        val fullTimeEntity = fullTimeEntityMapper.mapFullTimeToEntity(fullTimeDomain)
        assertTrue(fullTimeDomain.awayTeam == fullTimeEntity.awayTeam)
    }

    @Test
    fun mapEntityToDomain() {
        val fullTimeEntity = createFullTimeEntity()
        val fullTimeDomain = fullTimeEntityMapper.mapEntityToDomain(fullTimeEntity)
        assertTrue(fullTimeDomain.awayTeam == fullTimeEntity.awayTeam)
    }
}