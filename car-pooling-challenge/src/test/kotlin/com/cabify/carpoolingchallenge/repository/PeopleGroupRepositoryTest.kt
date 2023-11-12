package com.cabify.carpoolingchallenge.repository

import com.cabify.carpoolingchallenge.repository.model.PeopleGroup
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class PeopleGroupRepositoryTest(
        @Autowired
        private val peopleGroupRepository: PeopleGroupRepository
) {
    @Test
    fun `should return a peopleGroup who is waiting `() {
        //Given
        val peopleGroupNew = PeopleGroup(people = 3)
        val peopleGroupCreated = peopleGroupRepository.save(peopleGroupNew)
        // When
        val peopleGroupDb = peopleGroupRepository.findTop1ByPeopleIsLessThanEqualAndCarIsNullOrderByCreatedDateAsc(3)
        //Then
        assert(peopleGroupCreated == peopleGroupDb)
    }

    @Test
    fun `should return a null peopleGroup waiting `() {
        //Given
        // When
        val peopleGroupDb = peopleGroupRepository.findTop1ByPeopleIsLessThanEqualAndCarIsNullOrderByCreatedDateAsc(3)
        //Then
        assert(peopleGroupDb == null)
    }

}