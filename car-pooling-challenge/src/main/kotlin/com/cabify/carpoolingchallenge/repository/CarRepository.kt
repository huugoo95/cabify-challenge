package com.cabify.carpoolingchallenge.repository

import com.cabify.carpoolingchallenge.repository.model.Car
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CarRepository : JpaRepository<Car, Long> {

    @Query(
        value = "SELECT c.id, c.seats " +
                "FROM cars c " +
                "WHERE seats - COALESCE(select sum(p.people) from people_groups p where p.car_id = c.id, 0) >= :minFreeSeats",
        nativeQuery = true
    )
    fun findAllBySeatsFree(minFreeSeats: Int): List<Car>
}
