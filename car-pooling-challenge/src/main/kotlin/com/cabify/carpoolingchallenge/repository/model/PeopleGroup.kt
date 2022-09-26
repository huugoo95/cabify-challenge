package com.cabify.carpoolingchallenge.repository.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "people_groups")
data class PeopleGroup(
    @Id
    val id: Long? = 0,
    @Column
    val people: Int? = 0
)
