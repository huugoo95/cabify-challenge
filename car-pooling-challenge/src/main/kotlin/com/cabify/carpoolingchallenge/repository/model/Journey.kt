package com.cabify.carpoolingchallenge.repository.model

import javax.persistence.*

@Entity
@Table(name = "journeys")
data class Journey(
    @Id
    val id: Long? = 0,

    @ManyToOne
    val car: Car? = null,

    @ManyToOne
    val peopleGroup: PeopleGroup? = null,

    val isFinished : Boolean = false
)
