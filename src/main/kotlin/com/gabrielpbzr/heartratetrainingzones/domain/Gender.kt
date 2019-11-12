package com.gabrielpbzr.heartratetrainingzones.domain

enum class Gender {
    MALE("M"),
    FEMALE("F");

    private val value: String

    constructor(value: String){
        this.value = value
    }
}