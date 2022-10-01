package com.cabify.carpoolingchallenge.repository

import com.cabify.carpoolingchallenge.repository.model.PeopleGroup
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PeopleGroupRepository : JpaRepository<PeopleGroup, Long>{

    fun findTop1ByPeopleIsLessThanEqualAndCarIsNull(numberPersons : Int) : PeopleGroup?
}
