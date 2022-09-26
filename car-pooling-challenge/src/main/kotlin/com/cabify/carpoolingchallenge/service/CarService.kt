package com.cabify.carpoolingchallenge.service

import com.cabify.carpoolingchallenge.dto.CarsLoadRequest
import com.cabify.carpoolingchallenge.repository.model.Car
import com.cabify.carpoolingchallenge.repository.model.PeopleGroup

interface CarService{
    fun loadCars(carsLoadRequest : List<CarsLoadRequest>): String

    fun getCarsAvailableByPeopleGroup(peopleGroup: PeopleGroup): Car?
}
