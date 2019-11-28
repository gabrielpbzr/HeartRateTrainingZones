package com.gabrielpbzr.heartratetrainingzones.domain;

import java.lang.IllegalArgumentException

data class HeartRateZone(val name: String, val minimum: Int, val maximum: Int) {
    init {
        when {
            minimum > maximum -> throw IllegalArgumentException("Maximum value should be greater than minimum value")
        }
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is HeartRateZone) return false

        if (name != other.name) return false
        if (minimum != other.minimum) return false
        if (maximum != other.maximum) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + minimum
        result = 31 * result + maximum
        return result
    }
}
