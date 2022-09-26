package com.cabify.carpoolingchallenge.controller

import com.cabify.carpoolingchallenge.dto.JourneyRequest
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
    fun requestJourney(@Valid @RequestBody journeyRequest: JourneyRequest): ResponseEntity<String> = ResponseEntity.ok(journeyService.requestJourney(journeyRequest))

    @PostMapping("dropoff")
    fun cancelJourney(): ResponseEntity<String> = TODO()


}
