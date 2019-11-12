package com.gabrielpbzr.heartratetrainingzones.domain

import java.time.LocalDate
import java.time.Period

data class User(val birthDate: LocalDate, val gender: Gender) {

    fun getAge(): Int {
        val difference = Period.between(birthDate, LocalDate.now())
        return difference.years
    }
}