package com.cabify.carpoolingchallenge.repository.model

import javax.persistence.*

@Entity
@Table(name = "cars")
data class Car(
    @Id
    val id: Long? = 0,
    @Column
    var seats: Int? = 0,

    @OneToMany(mappedBy = "car")
    var journey: List<Journey>? = null
)
