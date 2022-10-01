package com.cabify.carpoolingchallenge.service

import com.cabify.carpoolingchallenge.dto.CarResponse
import com.cabify.carpoolingchallenge.dto.FindJourneyRequest
import com.cabify.carpoolingchallenge.dto.NewJourneyRequest
import org.springframework.http.ResponseEntity

interface JourneyService{
    fun requestJourney(journeyRequest: NewJourneyRequest) : ResponseEntity<Any>

    fun cancelJourney(cancelJourneyRequest : FindJourneyRequest) : ResponseEntity<Any>

    fun locateJourney(locateGroupRequest : FindJourneyRequest) : ResponseEntity<CarResponse>

}
