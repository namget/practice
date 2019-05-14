package com.namget.firstcitizen.factory

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.namget.firstcitizen.R

class MyAbstractFactory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main2()
    }
}

fun main2() {
    val KRRamenStore = KRRamenStore()
    KRRamenStore.orderRamen(RamenType.SINRAMEN)

    val JPRmenStore = JPRamenStore()
    JPRmenStore.orderRamen(RamenType.NUGURI)
}

interface RamenIngedientFactory {
    fun putWater(): Water
    fun putSauce(): Sauce
    fun putNoodle(): Noodle
}

interface Water
interface Sauce
interface Noodle

class Water500 : Water
class Water450 : Water
class SinSauce : Sauce
class NuguriSauce : Sauce
class ThickNoodle : Noodle
class NormalNoodle : Noodle
class ThinNoodle : Noodle


class KRSinRamenIngedientFactory : RamenIngedientFactory {
    override fun putWater(): Water = Water450()
    override fun putSauce(): Sauce = SinSauce()
    override fun putNoodle(): Noodle = NormalNoodle()
}

class JPSinRamenIngedientFactory : RamenIngedientFactory {
    override fun putWater(): Water = Water450()
    override fun putSauce(): Sauce = SinSauce()
    override fun putNoodle(): Noodle = ThinNoodle()
}


class KRNugoriIngedientFactory : RamenIngedientFactory {
    override fun putWater(): Water = Water500()
    override fun putSauce(): Sauce = NuguriSauce()
    override fun putNoodle(): Noodle = ThickNoodle()
}

class JPNugoriIngedientFactory : RamenIngedientFactory {
    override fun putWater(): Water = Water500()
    override fun putSauce(): Sauce = NuguriSauce()
    override fun putNoodle(): Noodle = ThickNoodle()
}

abstract class Ramen() {
    var name: String? = null
    var water: Water? = null
    var sauce: Sauce? = null
    var noodle: Noodle? = null
    abstract fun prepare()

    fun putNoodle() {
        println("put Noodle ")
    }

    fun putWater() {
        println("put water ")
    }

    open fun boil() {
        println("boil 3 minute")
    }

    fun putSauce() {
        println("put Sauce ")
    }
}

class SinRamen(val ramenIngedientFactory: RamenIngedientFactory) : Ramen() {
    override fun prepare() {
        println("Preparing $name")
        water = ramenIngedientFactory.putWater()
        sauce = ramenIngedientFactory.putSauce()
        noodle = ramenIngedientFactory.putNoodle()
    }
}

class Nuguri(val ramenIngedientFactory: RamenIngedientFactory) : Ramen() {
    override fun prepare() {
        println("Preparing $name")
        water = ramenIngedientFactory.putWater()
        sauce = ramenIngedientFactory.putSauce()
        noodle = ramenIngedientFactory.putNoodle()
    }
}


abstract class RamenStore {
    lateinit var ramen: Ramen
    fun orderRamen(ramenType: RamenType) {
        println("order Ramen")
        ramen = createRamen(ramenType)
        ramen.prepare()
        ramen.putWater()
        ramen.boil()
        ramen.putSauce()
        ramen.putNoodle()
    }

    abstract fun createRamen(ramenType: RamenType): Ramen
}

class KRRamenStore : RamenStore() {
    override fun createRamen(ramenType: RamenType): Ramen {
        var ramen: Ramen
        var ramenIngedientFactory: RamenIngedientFactory
        when (ramenType) {
            RamenType.SINRAMEN -> {
                ramenIngedientFactory = KRSinRamenIngedientFactory()
                ramen = SinRamen(ramenIngedientFactory)
                ramen.name = "Kr SinRamen"
            }
            RamenType.NUGURI -> {
                ramenIngedientFactory = KRNugoriIngedientFactory()
                ramen = Nuguri(ramenIngedientFactory)
                ramen.name = "Kr Nuguri"
            }
            else -> {
                throw Exception()
            }
        }
        return ramen
    }
}

class JPRamenStore : RamenStore() {
    override fun createRamen(ramenType: RamenType): Ramen {
        var ramen: Ramen
        var ramenIngedientFactory: RamenIngedientFactory
        when (ramenType) {
            RamenType.SINRAMEN -> {
                ramenIngedientFactory = JPSinRamenIngedientFactory()
                ramen = SinRamen(ramenIngedientFactory)
                ramen.name = "JP SinRamen"
            }
            RamenType.NUGURI -> {
                ramenIngedientFactory = JPNugoriIngedientFactory()
                ramen = Nuguri(ramenIngedientFactory)
                ramen.name = "JP Nuguri"
            }
            else -> {
                throw Exception()
            }
        }
        return ramen
    }
}


enum class RamenType {
    NUGURI, SINRAMEN
}