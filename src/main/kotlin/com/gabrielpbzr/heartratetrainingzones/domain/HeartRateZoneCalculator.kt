package com.gabrielpbzr.heartratetrainingzones.domain

import kotlin.math.roundToInt

/**
 * Calculates heart rate zones according to the
 * Association of British Cycling Coaches
 *
 * @author Gabriel P. Bezerra
 */
class HeartRateZoneCalculator (private val user: User) {
    fun getAerobicLimit() : Int {
        return 220 - user.getAge()
    }

    fun getMaxHeartRate(): Int {
        return when (user.gender) {
            Gender.FEMALE -> 226 - user.getAge()
            Gender.MALE -> 220 - user.getAge()
        }
    }

    fun getHeartRateZone1(): HeartRateZone {
        val maximumHR = getAerobicLimit()
        val min = (maximumHR * 0.6).roundToInt()
        val max = (maximumHR * 0.65).roundToInt()

        return HeartRateZone("Zone 1", min, max)
    }

    fun getHeartRateZone2(): HeartRateZone {
        val maximumHR = getAerobicLimit()
        val min = (maximumHR * 0.65).roundToInt()
        val max = (maximumHR * 0.75).roundToInt()

        return HeartRateZone("Zone 2", min, max)
    }

    fun getHeartRateZone3(): HeartRateZone {
        val maximumHR = getAerobicLimit()
        val min = (maximumHR * 0.75).roundToInt()
        val max = (maximumHR * 0.82).roundToInt()

        return HeartRateZone("Zone 3", min, max)
    }

    fun getHeartRateZone4(): HeartRateZone {
        val maximumHR = getAerobicLimit()
        val min = (maximumHR * 0.82).roundToInt()
        val max = (maximumHR * 0.89).roundToInt()

        return HeartRateZone("Zone 4", min, max)
    }

    fun getHeartRateZone5(): HeartRateZone {
        val maximumHR = getAerobicLimit()
        val min = (maximumHR * 0.89).roundToInt()
        val max = (maximumHR * 0.94).roundToInt()

        return HeartRateZone("Zone 5", min, max)
    }

    fun getHeartRateZone6(): HeartRateZone {
        val maximumHR = getAerobicLimit()
        val min = (maximumHR * 0.94).roundToInt()
        val max = (maximumHR * 1)

        return HeartRateZone("Zone 6", min, max)
    }

    fun getHeartRateZones() : Array<HeartRateZone> {
        return arrayOf(
            this.getHeartRateZone1(),
            this.getHeartRateZone2(),
            this.getHeartRateZone3(),
            this.getHeartRateZone4(),
            this.getHeartRateZone5(),
            this.getHeartRateZone6()
        )
    }
}