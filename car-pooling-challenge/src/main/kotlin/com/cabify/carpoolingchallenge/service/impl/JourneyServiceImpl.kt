package com.cabify.carpoolingchallenge.service.impl

import com.cabify.carpoolingchallenge.dto.JourneyRequest
import com.cabify.carpoolingchallenge.repository.JourneyRepository
import com.cabify.carpoolingchallenge.repository.PeopleGroupRepository
import com.cabify.carpoolingchallenge.repository.model.Journey
import com.cabify.carpoolingchallenge.repository.model.PeopleGroup
import com.cabify.carpoolingchallenge.service.CarService
import com.cabify.carpoolingchallenge.service.JourneyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class JourneyServiceImpl(
    @Autowired
    private val peopleGroupRepository: PeopleGroupRepository,
    @Autowired
    private val journeyRepository: JourneyRepository,
    @Autowired
    private val carService: CarService
) : JourneyService {
    override fun requestJourney(journeyRequest: JourneyRequest) : String {
        val peopleGroup = peopleGroupRepository.save(PeopleGroup(journeyRequest.id, journeyRequest.people))
        val car = carService.getCarsAvailableByPeopleGroup(peopleGroup)
        car?.let {
            journeyRepository.save(Journey(peopleGroup = peopleGroup, car = it))
            return "journey started"
        }
        return "journey booked"
    }
}
