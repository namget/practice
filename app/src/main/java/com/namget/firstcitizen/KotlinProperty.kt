package com.namget.firstcitizen

open class FatherKotlinProperty(open var hairColor: String, open var eyeColor: String) {
    fun printFatherHair() {
        print(hairColor)
    }
}

class KotlinProperty : FatherKotlinProperty {

    override var hairColor: String
        get() = super.hairColor
        set(value) {}
    override var eyeColor: String
        get() = super.eyeColor
        set(value) {}

    constructor(hairColor: String, eyeColor: String) : super(hairColor,eyeColor){
        this.hairColor = hairColor
        this.eyeColor = eyeColor
    }

}