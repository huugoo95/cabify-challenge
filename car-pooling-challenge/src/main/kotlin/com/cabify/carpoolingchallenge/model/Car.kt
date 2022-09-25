package com.cabify.carpoolingchallenge.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "cars")
data class Car(
    @Id
    val id: Long? = 0,
    @Column
    val seats: Int? = 0
)
