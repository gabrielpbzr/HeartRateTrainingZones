package com.gabrielpbzr.heartratetrainingzones.domain

import java.time.LocalDate
import kotlin.test.Test
import kotlin.test.assertEquals

class HeartRateZoneCalculatorTest {
    private val birthDate : LocalDate = LocalDate.now().minusYears(31)
    @Test
    fun shouldCalculateAerobicLimitForMaleUser() {

        val maleUser = User(birthDate = birthDate, gender = Gender.MALE)
        val calculator = HeartRateZoneCalculator(maleUser)
        val result = calculator.getAerobicLimit()

        assertEquals(189, result)
    }

    @Test
    fun shouldCalculateAerobicLimitForFemaleUser() {
        val femaleUser = User(birthDate = birthDate, gender = Gender.FEMALE)
        val calculator = HeartRateZoneCalculator(femaleUser)
        val result = calculator.getAerobicLimit()

        assertEquals(189, result)
    }

    @Test
    fun shouldCalculateMaxHeartRateForMaleUser() {
        val maleUser = User(birthDate = birthDate, gender = Gender.MALE)
        val calculator = HeartRateZoneCalculator(maleUser)
        val result = calculator.getMaxHeartRate()

        assertEquals(189, result)
    }

    @Test
    fun shouldCalculateMaxHeartRateForFemaleUser() {
        val femaleUser = User(birthDate = birthDate, gender = Gender.FEMALE)
        val calculator = HeartRateZoneCalculator(femaleUser)
        val result = calculator.getMaxHeartRate()

        assertEquals(195, result)
    }

    @Test
    fun shouldCalculateHeartRateZone1ForMaleUser() {
        val maleUser = User(birthDate = birthDate, gender = Gender.MALE)
        val calculator = HeartRateZoneCalculator(maleUser)
        val result = calculator.getHeartRateZone1()
        val expected = HeartRateZone(name = "Zone 1", minimum = 113, maximum = 123)

        assertEquals(expected, result)
    }

    @Test
    fun shouldCalculateHeartRateZone2ForMaleUser() {
        val maleUser = User(birthDate = birthDate, gender = Gender.MALE)
        val calculator = HeartRateZoneCalculator(maleUser)
        val result = calculator.getHeartRateZone2()
        val expected = HeartRateZone(name = "Zone 2", minimum = 123, maximum = 142)

        assertEquals(expected, result)
    }

    @Test
    fun shouldCalculateHeartRateZone3ForMaleUser() {
        val maleUser = User(birthDate = birthDate, gender = Gender.MALE)
        val calculator = HeartRateZoneCalculator(maleUser)
        val result = calculator.getHeartRateZone3()
        val expected = HeartRateZone(name = "Zone 3", minimum = 142, maximum = 155)

        assertEquals(expected, result)
    }

    @Test
    fun shouldCalculateHeartRateZone4ForMaleUser() {
        val maleUser = User(birthDate = birthDate, gender = Gender.MALE)
        val calculator = HeartRateZoneCalculator(maleUser)
        val result = calculator.getHeartRateZone4()
        val expected = HeartRateZone(name = "Zone 4", minimum = 155, maximum = 168)

        assertEquals(expected, result)
    }

    @Test
    fun shouldCalculateHeartRateZone5ForMaleUser() {
        val maleUser = User(birthDate = birthDate, gender = Gender.MALE)
        val calculator = HeartRateZoneCalculator(maleUser)
        val result = calculator.getHeartRateZone5()
        val expected = HeartRateZone(name = "Zone 5", minimum = 168, maximum = 178)

        assertEquals(expected, result)
    }

    @Test
    fun shouldCalculateHeartRateZone6ForMaleUser() {
        val maleUser = User(birthDate = birthDate, gender = Gender.MALE)
        val calculator = HeartRateZoneCalculator(maleUser)
        val result = calculator.getHeartRateZone6()
        val expected = HeartRateZone(name = "Zone 6", minimum = 178, maximum = 189)

        assertEquals(expected, result)
    }

    @Test
    fun shouldCalculateHeartRateZone1ForFemaleUser() {
        val maleUser = User(birthDate = birthDate, gender = Gender.FEMALE)
        val calculator = HeartRateZoneCalculator(maleUser)
        val result = calculator.getHeartRateZone1()
        val expected = HeartRateZone(name = "Zone 1", minimum = 113, maximum = 123)

        assertEquals(expected, result)
    }

    @Test
    fun shouldCalculateHeartRateZone2ForFemaleUser() {
        val maleUser = User(birthDate = birthDate, gender = Gender.FEMALE)
        val calculator = HeartRateZoneCalculator(maleUser)
        val result = calculator.getHeartRateZone2()
        val expected = HeartRateZone(name = "Zone 2", minimum = 123, maximum = 142)

        assertEquals(expected, result)
    }

    @Test
    fun shouldCalculateHeartRateZone3ForFemaleUser() {
        val maleUser = User(birthDate = birthDate, gender = Gender.FEMALE)
        val calculator = HeartRateZoneCalculator(maleUser)
        val result = calculator.getHeartRateZone3()
        val expected = HeartRateZone(name = "Zone 3", minimum = 142, maximum = 155)

        assertEquals(expected, result)
    }

    @Test
    fun shouldCalculateHeartRateZone4ForFemaleUser() {
        val maleUser = User(birthDate = birthDate, gender = Gender.FEMALE)
        val calculator = HeartRateZoneCalculator(maleUser)
        val result = calculator.getHeartRateZone4()
        val expected = HeartRateZone(name = "Zone 4", minimum = 155, maximum = 168)

        assertEquals(expected, result)
    }

    @Test
    fun shouldCalculateHeartRateZone5ForFemaleUser() {
        val maleUser = User(birthDate = birthDate, gender = Gender.FEMALE)
        val calculator = HeartRateZoneCalculator(maleUser)
        val result = calculator.getHeartRateZone5()
        val expected = HeartRateZone(name = "Zone 5", minimum = 168, maximum = 178)

        assertEquals(expected, result)
    }

    @Test
    fun shouldCalculateHeartRateZone6ForFemaleUser() {
        val maleUser = User(birthDate = birthDate, gender = Gender.FEMALE)
        val calculator = HeartRateZoneCalculator(maleUser)
        val result = calculator.getHeartRateZone6()
        val expected = HeartRateZone(name = "Zone 6", minimum = 178, maximum = 189)

        assertEquals(expected, result)
    }
}