package com.cabify.carpoolingchallenge.repository

import com.cabify.carpoolingchallenge.repository.model.Car
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CarRepository : JpaRepository<Car, Long>{

    //fun findAllBySeatsFree(requestSeats : Int) : List<Car>
}
