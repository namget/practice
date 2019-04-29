package com.namget.firstcitizen.observer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity


class ObserverTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main()
    }


    fun main() {
        val weatherData: WeatherData = WeatherData()
        val currentDisplay: CurrentConditionDisplay = CurrentConditionDisplay(weatherData)
        val statisticsDisplay: StatisticsDisplay = StatisticsDisplay(weatherData)
        val forecastDisplay: ForecastDisplay = ForecastDisplay(weatherData)

        weatherData.setMeasurements(80f, 65f, 30.4f)
        weatherData.setMeasurements(82f, 70f, 38.2f)
        weatherData.setMeasurements(88f, 90f, 29.2f)

    }

}

interface Subject {
    fun registerObserver(o: Observer)
    fun removeObserver(o: Observer)
    fun notifyObservers()
}

class WeatherData(
    var observers: ArrayList<Observer> = arrayListOf(),
    var temperature: Float = 0.0f,
    var humidity: Float = 0.0f,
    var pressure: Float = 0.0f
) : Subject {


    override fun registerObserver(o: Observer) {
        observers.add(o)
    }

    override fun removeObserver(o: Observer) {
        observers.remove(o)
    }

    override fun notifyObservers() {
        observers.forEach {
            it.update(temperature, humidity, pressure)
        }
    }

    fun measurementsChanged() {
        notifyObservers()
    }

    fun setMeasurements(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        measurementsChanged()
    }
}

interface Observer {
    fun update(temp: Float, humidity: Float, pressure: Float)
}

interface DisplayElement {
    fun display()
}

class CurrentConditionDisplay(weatherData: Subject) : Observer, DisplayElement {
    private var temperature: Float = 0.0f
    private var humidity: Float = 0.0f
    private var weatherData: Subject

    init {
        this.weatherData = weatherData
        weatherData.registerObserver(this)
    }

    override fun update(temp: Float, humidity: Float, pressure: Float) {
        this.humidity = humidity
        this.temperature = temp
        display()
    }

    override fun display() {
        println("CurrentConditionDisplay ${temperature} F degress and humidity ${humidity} %")
    }
}

class StatisticsDisplay(weatherData: Subject) : Observer, DisplayElement {
    private var temperature: Float = 0.0f
    private var humidity: Float = 0.0f
    private var weatherData: Subject

    init {
        this.weatherData = weatherData
        weatherData.registerObserver(this)
    }

    override fun update(temp: Float, humidity: Float, pressure: Float) {
        this.humidity = humidity
        this.temperature = temp
        display()
    }
    override fun display() {
        println("StatisticsDisplay ${temperature} F degress and humidity ${humidity} %")
    }
}

class ForecastDisplay(weatherData: Subject) : Observer, DisplayElement {
    private var temperature: Float = 0.0f
    private var humidity: Float = 0.0f
    private var weatherData: Subject

    init {
        this.weatherData = weatherData
        weatherData.registerObserver(this)
    }

    override fun update(temp: Float, humidity: Float, pressure: Float) {
        this.humidity = humidity
        this.temperature = temp
        display()
    }

    override fun display() {
        println("ForecastDisplay ${temperature} F degress and humidity ${humidity} %")
    }
}


class ThirdPartyDisplay(weatherData: Subject) : Observer, DisplayElement {
    private var temperature: Float = 0.0f
    private var humidity: Float = 0.0f
    private var weatherData: Subject

    init {
        this.weatherData = weatherData
        weatherData.registerObserver(this)
    }

    override fun update(temp: Float, humidity: Float, pressure: Float) {
        this.humidity = humidity
        this.temperature = temperature
        display()
    }

    override fun display() {
    }
}


class ConcreteObserver() : Observer {
    override fun update(temp: Float, humidity: Float, pressure: Float) {

    }
}

