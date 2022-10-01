package com.cabify.carpoolingchallenge.controller

import com.cabify.carpoolingchallenge.dto.CarResponse
import com.cabify.carpoolingchallenge.dto.FindJourneyRequest
import com.cabify.carpoolingchallenge.dto.NewJourneyRequest
import com.cabify.carpoolingchallenge.service.JourneyService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class JourneyController(
    private val journeyService: JourneyService
) {

    @PostMapping("journey")
    fun requestJourney(@Valid @RequestBody journeyRequest: NewJourneyRequest): ResponseEntity<Any> =
        journeyService.requestJourney(journeyRequest)

    @PostMapping("dropoff")
    fun cancelJourney(@Valid cancelJourneyRequest: FindJourneyRequest): ResponseEntity<Any> =
        journeyService.cancelJourney(cancelJourneyRequest)

    @PostMapping("locate")
    fun locateGroup(@Valid locateGroupRequest: FindJourneyRequest): ResponseEntity<CarResponse> =
        journeyService.locateJourney(locateGroupRequest)


}
