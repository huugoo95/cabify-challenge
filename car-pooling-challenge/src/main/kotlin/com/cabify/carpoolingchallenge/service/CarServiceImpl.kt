package com.cabify.carpoolingchallenge.service

import com.cabify.carpoolingchallenge.dto.CarsLoadRequest
import com.cabify.carpoolingchallenge.model.Car
import com.cabify.carpoolingchallenge.repository.CarRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CarServiceImpl(
    @Autowired
    private val carRepository: CarRepository
) : CarService {

    override fun putCars(carsLoadRequest: List<CarsLoadRequest>): String {
        val cars = carsLoadRequest.map { Car(it.id, it.seats) }
        carRepository.deleteAll()
        carRepository.saveAll(cars)
        return "ok"
    }
}
