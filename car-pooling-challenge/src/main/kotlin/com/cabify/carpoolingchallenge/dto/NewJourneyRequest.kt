package com.cabify.carpoolingchallenge.dto

import org.hibernate.validator.constraints.Range
import javax.validation.constraints.Positive

class NewJourneyRequest(
    @field:Positive
    val id: Long,
    @field:Range(min=1, max=6)
    val people: Int
)
