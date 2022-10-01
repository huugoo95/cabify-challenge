package com.cabify.carpoolingchallenge.controller

import com.cabify.carpoolingchallenge.dto.CarsLoadRequest
import com.cabify.carpoolingchallenge.service.CarService
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@Validated
class CarsController(
    private val carService: CarService
) {

    @PutMapping("cars")
    fun loadCars(@Valid @RequestBody request: List<CarsLoadRequest>) : ResponseEntity<Any> =
        carService.loadCars(request)

}
