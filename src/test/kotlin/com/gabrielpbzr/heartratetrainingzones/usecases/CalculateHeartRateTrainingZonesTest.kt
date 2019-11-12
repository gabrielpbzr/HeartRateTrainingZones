package com.gabrielpbzr.heartratetrainingzones.usecases

import com.gabrielpbzr.heartratetrainingzones.domain.*
import java.time.LocalDate
import kotlin.test.Test
import kotlin.test.assertTrue

class CalculateHeartRateTrainingZonesTest {

    @Test
    fun calculateHeartRateZonesForAMaleUser() {
        val useCase = CalculateHeartRateTrainingZones()
        val trainingZones = useCase.calculateTrainingZonesForUser(LocalDate.of(1988, 2, 25), Gender.MALE)
        val expected = arrayOf(
            HeartRateZone("Zone 1", 113, 123),
            HeartRateZone("Zone 2", 123, 142),
            HeartRateZone("Zone 3", 142, 155),
            HeartRateZone("Zone 4", 155, 168),
            HeartRateZone("Zone 5", 168, 178),
            HeartRateZone("Zone 6", 178, 189)
        )

        assertTrue(expected contentEquals trainingZones)
    }

    @Test
    fun calculateHeartRateZonesForAFemaleUser() {
        val useCase = CalculateHeartRateTrainingZones()
        val trainingZones = useCase.calculateTrainingZonesForUser(LocalDate.of(1988, 2, 25), Gender.FEMALE)
        val expected = arrayOf(
            HeartRateZone("Zone 1", 113, 123),
            HeartRateZone("Zone 2", 123, 142),
            HeartRateZone("Zone 3", 142, 155),
            HeartRateZone("Zone 4", 155, 168),
            HeartRateZone("Zone 5", 168, 178),
            HeartRateZone("Zone 6", 178, 189)
        )

        assertTrue(expected contentEquals trainingZones)
    }
}