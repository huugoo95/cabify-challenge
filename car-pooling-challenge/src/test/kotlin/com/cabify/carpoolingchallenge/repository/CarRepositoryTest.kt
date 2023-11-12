package com.cabify.carpoolingchallenge.repository

import com.cabify.carpoolingchallenge.repository.model.Car
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class CarRepositoryTest(
        @Autowired
        private val carRepository: CarRepository
) {
    @Test
    fun `should return an example Car`() {
        //Given
        val newCar1 = carRepository.save(Car(id = 2, seats = 5))
        val newCar2 = carRepository.save(Car(id = 2, seats = 5))
        // When
        val freeCarList = carRepository.findAllBySeatsFree(5)
        //Then
        assert(freeCarList.containsAll(listOf(newCar1, newCar2)))
    }

    @Test
    fun `should return an empty cars list`() {
        //Given
        //when
        val freeCarList = carRepository.findAllBySeatsFree(0)
        //Then
        assert(freeCarList.isEmpty())
    }
}