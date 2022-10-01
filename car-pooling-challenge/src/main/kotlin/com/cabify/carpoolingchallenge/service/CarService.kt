package com.cabify.carpoolingchallenge.service

import com.cabify.carpoolingchallenge.dto.CarsLoadRequest
import com.cabify.carpoolingchallenge.repository.model.Car

interface CarService{
    fun loadCars(carsLoadRequest : List<CarsLoadRequest>): String

    fun getCarsAvailableByPeopleGroup(people: Int): Car?

}
