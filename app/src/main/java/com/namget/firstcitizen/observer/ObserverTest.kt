package com.namget.firstcitizen.observer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import java.util.*

fun measurementsChanged() {
    // 기상값이 바뀌었을때 불러짐

}


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

        weatherData.setMeasurements(80f, 65f, 30.4f) // 데이터가 바뀌는걸 주입하기 위한 함수
        weatherData.setMeasurements(82f, 70f, 38.2f) // 데이터가 바뀌는걸 주입하기 위한 함수
        weatherData.setMeasurements(88f, 90f, 29.2f) // 데이터가 바뀌는걸 주입하기 위한 함수
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

    //구독
    override fun registerObserver(o: Observer) {
        observers.add(o)
    }

    //구독 제거
    override fun removeObserver(o: Observer) {
        observers.remove(o)
    }

    //옵저버에게 데이터 변화를 알려주는부분
    override fun notifyObservers() {
        observers.forEach {
            it.update(temperature, humidity, pressure)
        }
    }

    //가상 스테이션으로부터 받은 데이터를 옵저버에게 알림
    fun measurementsChanged() {
        notifyObservers()
    }

    //강제적인 데이터변경을 테스트하기 위한 메솓,
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


class WeatherDataWithObservable() : Observable() {
    var temperature: Float = 0.0f
    var humidity: Float = 0.0f
    var pressure: Float = 0.0f

    //가상 스테이션으로부터 받은 데이터를 옵저버에게 알림
    fun measurementsChanged() {
        setChanged()
        notifyObservers()
    }

    //강제적인 데이터변경을 테스트하기 위한 메솓,
    fun setMeasurements(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        measurementsChanged()
    }
    //코틀린에서는 자동으로 getMethod 생성
}

class DisplayWithObservable : java.util.Observer, DisplayElement {
    lateinit var observable: Observable
    var temperature: Float = 0.0f
    var humidity: Float = 0.0f

    override fun update(obs: Observable?, p1: Any?) {
        (obs as WeatherData).apply {
            this@DisplayWithObservable.temperature = this.temperature
            this@DisplayWithObservable.humidity = this.humidity
            display()
        }
    }
    override fun display() {
        //println
    }
}
