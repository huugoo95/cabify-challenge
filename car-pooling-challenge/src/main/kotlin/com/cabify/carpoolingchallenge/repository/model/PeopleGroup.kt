package com.cabify.carpoolingchallenge.repository.model

import org.hibernate.annotations.CreationTimestamp
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "people_groups")
data class PeopleGroup(
    @Id
    val id: Long? = 0,
    @Column
    val people: Int? = 0,
    @Column
    @field:CreationTimestamp
    var createdDate: Date? = null,

    @ManyToOne
    var car: Car? = null
)
