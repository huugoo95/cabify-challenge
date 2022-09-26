package com.cabify.carpoolingchallenge.service.impl

import com.cabify.carpoolingchallenge.dto.CarsLoadRequest
import com.cabify.carpoolingchallenge.repository.model.Car
import com.cabify.carpoolingchallenge.repository.CarRepository
import com.cabify.carpoolingchallenge.repository.model.PeopleGroup
import com.cabify.carpoolingchallenge.service.CarService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CarServiceImpl(
    @Autowired
    private val carRepository: CarRepository
) : CarService {

    override fun loadCars(carsLoadRequest: List<CarsLoadRequest>): String {
        val cars = carsLoadRequest.map { Car(it.id, it.seats) }
        carRepository.deleteAll()
        carRepository.saveAll(cars)
        return "ok"
    }

    override fun getCarsAvailableByPeopleGroup(peopleGroup: PeopleGroup): Car? {
        val cars = carRepository.findAll()
        //ToDo get availables cars
        //var carSeatMap = mutableMapOf<Car, Int?>()
        //val carSeatMap = cars.map { car -> car to car.seats?.minus(car.journey?.sumOf { it.peopleGroup?.people!! } ?: 0) }.toMap()
        //val car = cars.first { car -> car.seats.minus(car.journey.sumOf {  it.peopleGroup?.people } ?: 0) >= peopleGroup.people }
        //val journey = Journey(peopleGroup = peopleGroup, car = car)
        return cars.firstOrNull()
    }

}
