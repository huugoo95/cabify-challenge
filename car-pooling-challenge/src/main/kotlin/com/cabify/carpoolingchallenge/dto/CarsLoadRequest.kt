package com.cabify.carpoolingchallenge.dto

import org.hibernate.validator.constraints.Range
import javax.validation.constraints.Positive

class CarsLoadRequest(
    @get:Positive
    val id: Long,
    @field:Range(min=4, max=6)
    val seats: Int
)
