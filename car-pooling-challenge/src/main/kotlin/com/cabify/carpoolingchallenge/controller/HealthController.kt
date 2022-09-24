package com.cabify.carpoolingchallenge.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthController {

    @GetMapping("status")
    fun getStatus(): String = STATUS_OK

    companion object {
        const val STATUS_OK = "OK"
    }
}
