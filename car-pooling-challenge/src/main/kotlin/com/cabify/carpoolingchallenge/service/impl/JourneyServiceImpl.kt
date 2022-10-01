package com.cabify.carpoolingchallenge.service.impl

import com.cabify.carpoolingchallenge.dto.CarResponse
import com.cabify.carpoolingchallenge.dto.FindJourneyRequest
import com.cabify.carpoolingchallenge.dto.NewJourneyRequest
import com.cabify.carpoolingchallenge.repository.PeopleGroupRepository
import com.cabify.carpoolingchallenge.repository.model.Car
import com.cabify.carpoolingchallenge.repository.model.PeopleGroup
import com.cabify.carpoolingchallenge.service.CarService
import com.cabify.carpoolingchallenge.service.JourneyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class JourneyServiceImpl(
    @Autowired
    private val peopleGroupRepository: PeopleGroupRepository,
    @Autowired
    private val carService: CarService,
) : JourneyService {
    override fun requestJourney(journeyRequest: NewJourneyRequest): ResponseEntity<Any> {
        if (existesGroupById(journeyRequest.id))
            return ResponseEntity.ok("Already requested")

        val peopleGroup = PeopleGroup(journeyRequest.id, journeyRequest.people)
        val assignedCar = carService.getCarsAvailableByPeopleGroup(journeyRequest.people)
        assignedCar?.let {
            peopleGroup.car = it
            peopleGroupRepository.save(peopleGroup)
            return ResponseEntity.ok("journey started in car " + it.id)
        }
        peopleGroupRepository.save(peopleGroup)
        return ResponseEntity.accepted().build()
    }

    override fun cancelJourney(cancelJourneyRequest: FindJourneyRequest): ResponseEntity<Any> {
        val optionalGroup = peopleGroupRepository.findById(cancelJourneyRequest.ID)
        if (!optionalGroup.isPresent) {
            return ResponseEntity.notFound().build()
        }
        optionalGroup.get().car?.let {
            optionalGroup.get().id?.let { groupToDeleteId -> peopleGroupRepository.deleteById(groupToDeleteId) }
            reFieldCar(it)
            return ResponseEntity.ok("Refilled Car")
        }

        cancelJourneyAndDeleteGroup(cancelJourneyRequest.ID)
        return ResponseEntity.ok("No car no refill")
    }

    private fun reFieldCar(
        car: Car
    ) {
        var actualFreeSeats = car.seats!!.minus(car.peopleGroup.sumOf { it.people!! })
        var shouldContinueRefillingCar = true
        while (shouldContinueRefillingCar) {
            val nextPeopleGroup = getNextPeopleGroupForMaxPersons(actualFreeSeats)
            nextPeopleGroup?.let { next ->
                next.car = car
                actualFreeSeats = actualFreeSeats.minus(next.people!!)
                peopleGroupRepository.save(next)
            }
            if (actualFreeSeats < 1 || nextPeopleGroup == null) {
                shouldContinueRefillingCar = false
            }
        }
    }

    override fun locateJourney(locateGroupRequest: FindJourneyRequest): ResponseEntity<CarResponse> {
        val peopleGroup = peopleGroupRepository.findById(locateGroupRequest.ID)
        if (!peopleGroup.isPresent)
            return ResponseEntity.notFound().build()

        peopleGroup.get().car?.let {
            return ResponseEntity.ok(CarResponse(it.id, it.seats))
        }
        //ToDo  update ResponseEntity
        return ResponseEntity.ok(CarResponse(null, null))
    }

    private fun existesGroupById(id: Long): Boolean {
        return peopleGroupRepository.existsById(id)
    }

    private fun getNextPeopleGroupForMaxPersons(personsNumber: Int): PeopleGroup? {
        return peopleGroupRepository.findTop1ByPeopleIsLessThanEqualAndCarIsNull(personsNumber)
    }

    private fun cancelJourneyAndDeleteGroup(id: Long) {
        peopleGroupRepository.deleteById(id)
    }
}
