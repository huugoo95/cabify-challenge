package com.cabify.carpoolingchallenge.repository.model

import javax.persistence.*

@Entity
@Table(name = "people_groups")
data class PeopleGroup(
    @Id
    val id: Long? = 0,
    @Column
    val people: Int? = 0,

    @ManyToOne
    var car: Car? = null
)
