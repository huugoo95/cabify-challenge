package com.cabify.carpoolingchallenge.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.function.Consumer
import javax.validation.ConstraintViolation
import javax.validation.ConstraintViolationException

@ControllerAdvice
class ExceptionController : ResponseEntityExceptionHandler(){

    @ExceptionHandler(ConstraintViolationException::class)
    fun handle(constraintViolationException: ConstraintViolationException): ResponseEntity<*>? {
        val violations: Set<ConstraintViolation<*>> = constraintViolationException.constraintViolations
        val errorMessage: String = if (violations.isNotEmpty()) {
            val builder = StringBuilder()
            violations.forEach(Consumer { violation: ConstraintViolation<*> ->
                builder.append(
                    violation.propertyPath.toString() + " " + violation.message + "\n"
                )
            })
            builder.toString()
        } else {
            "ConstraintViolationException occured."
        }
        return ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST)
    }

}
