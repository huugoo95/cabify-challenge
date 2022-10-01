package com.cabify.carpoolingchallenge.service

import com.cabify.carpoolingchallenge.dto.CarsLoadRequest
import com.cabify.carpoolingchallenge.repository.model.Car
import org.springframework.http.ResponseEntity

interface CarService {
    fun loadCars(carsLoadRequest: List<CarsLoadRequest>): ResponseEntity<Any>

    fun getCarsAvailableByPeopleGroup(people: Int): Car?

}
