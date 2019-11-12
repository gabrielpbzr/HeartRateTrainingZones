package com.gabrielpbzr.heartratetrainingzones.domain

import kotlin.IllegalArgumentException
import kotlin.test.Test
import kotlin.test.fail

class HeartRateZoneTest {
    @Test
    fun shouldCreateAnInstanceIfMinimumValueIsLessThanMaximum() {
        val zone = HeartRateZone("Zone Test", minimum = 120, maximum = 130)
        assert(true)
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldThrowAnExceptionIfMinimumValueIsGreaterThanMaximum() {
        val zone = HeartRateZone("Zone Test", minimum = 190, maximum = 100)
        fail("Should have thrown an exception")
    }
}
