package com.cabify.carpoolingchallenge.dto

import javax.validation.constraints.Positive

class FindJourneyRequest(
    @field:Positive
    val ID: Long
)
