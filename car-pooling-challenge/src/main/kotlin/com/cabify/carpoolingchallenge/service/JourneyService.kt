package com.cabify.carpoolingchallenge.service

import com.cabify.carpoolingchallenge.dto.JourneyRequest

interface JourneyService{
    fun requestJourney(journeyRequest: JourneyRequest) : String
}
