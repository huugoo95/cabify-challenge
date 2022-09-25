package com.cabify.carpoolingchallenge.service

import com.cabify.carpoolingchallenge.dto.CarsLoadRequest

interface CarService{
    fun putCars(carsLoadRequest : List<CarsLoadRequest>): String
}
