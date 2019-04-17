package com.namget.firstcitizen

class CoffeeTest {

    interface Heater {
        fun on()
        fun off()
        fun isHot(): Boolean
    }

    class ElectricHeater(var heating: Boolean = false) : Heater {

        override fun on() {
            println("~~~ heating ~~~")
            heating = true
        }

        override fun off() {
            heating = false
        }

        override fun isHot(): Boolean {
            return heating
        }
    }

    interface Pump {
        fun pump()
    }

    class Thermosiphon(heater: Heater) : Pump, Heater by heater {
        override fun pump() {
            if (isHot()) {
                println("~~~ pummping ~~~")
            }
        }
    }

    interface CoffeeModule {
        fun getThermosiphon(): Thermosiphon
    }

    class MyDripCoffeeModule : CoffeeModule {
        val electricHeater: ElectricHeater by lazy {
            ElectricHeater()
        }
        private val _therMosiphon: Thermosiphon by lazy {
            Thermosiphon(electricHeater)
        }

        override fun getThermosiphon(): Thermosiphon = _therMosiphon
    }

    class CoffeeMaker(val coffeeModule: CoffeeModule) {
        fun brew() {
            coffeeModule.getThermosiphon().run {
                on()
                pump()
                println("coffee")
                off()
            }
        }

    }


    interface SwichManger {
        fun switchOn()
        fun switchOff()
        fun isSwitchOn(): Boolean
    }

    class Operator(var isSwichOn: Boolean = false) : SwichManger {
        override fun switchOn() {
            isSwichOn = true
        }

        override fun switchOff() {
            isSwichOn = false
        }

        override fun isSwitchOn(): Boolean {
            return isSwichOn
        }
    }

    interface ElectricManager {
        fun electricOn()
    }

    class Machine(swichManger: SwichManger) : ElectricManager, SwichManger by swichManger {

        override fun electricOn() {
            if (isSwitchOn()) {
                //TODO
                //Operate
            } else {
                //Nothing
            }
        }
    }


}