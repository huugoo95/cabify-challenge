package com.cabify.carpoolingchallenge.service.impl

import com.cabify.carpoolingchallenge.dto.CarsLoadRequest
import com.cabify.carpoolingchallenge.repository.CarRepository
import com.cabify.carpoolingchallenge.repository.PeopleGroupRepository
import com.cabify.carpoolingchallenge.repository.model.Car
import com.cabify.carpoolingchallenge.service.CarService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CarServiceImpl(
    @Autowired
    private val carRepository: CarRepository,
    @Autowired
    private val peopleGroupRepository: PeopleGroupRepository
) : CarService {

    override fun loadCars(carsLoadRequest: List<CarsLoadRequest>): String {
        val cars = carsLoadRequest.map { Car(it.id, it.seats) }
        peopleGroupRepository.deleteAll()
        carRepository.deleteAll()
        carRepository.saveAll(cars)
        return "ok"
    }

    override fun getCarsAvailableByPeopleGroup(minFreeSeats: Int): Car? {
        val cars = carRepository.findAllBySeatsFree(minFreeSeats)
        return cars.firstOrNull()
    }

}
