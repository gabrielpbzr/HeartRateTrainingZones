package com.gabrielpbzr.heartratetrainingzones.usecases

import com.gabrielpbzr.heartratetrainingzones.domain.Gender
import com.gabrielpbzr.heartratetrainingzones.domain.HeartRateZone
import com.gabrielpbzr.heartratetrainingzones.domain.HeartRateZoneCalculator
import com.gabrielpbzr.heartratetrainingzones.domain.User
import java.time.LocalDate

class CalculateHeartRateTrainingZones() {

    fun calculateTrainingZonesForUser(date: LocalDate, gender: Gender) : Array<HeartRateZone> {
        val user = User(birthDate = date, gender = gender)
        val calculator = HeartRateZoneCalculator(user)

        return calculator.getHeartRateZones()
    }
}