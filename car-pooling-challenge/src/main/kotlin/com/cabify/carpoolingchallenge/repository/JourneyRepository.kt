package com.cabify.carpoolingchallenge.repository

import com.cabify.carpoolingchallenge.repository.model.Journey
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JourneyRepository : JpaRepository<Journey, Long>
