package com.namget.firstcitizen.compound

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlin.collections.ArrayList

class CompoundTest : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun main(duckFactory: AbstractDuckFactory) {
        val mallardDuck: Quackable = duckFactory.createMallardDuck()
        val redheadDuck: Quackable = duckFactory.createRedheadDuck()
        val duckCall: Quackable = duckFactory.createDuckCall()
        val rubberDuck: Quackable = duckFactory.createRubberDuck()
        val gooseDuck: Quackable = GooseAdapter(Goose())

        val flockOfDucks: Flock = Flock()

        flockOfDucks.add(mallardDuck)
        flockOfDucks.add(redheadDuck)
        flockOfDucks.add(duckCall)
        flockOfDucks.add(rubberDuck)
        simulate(flockOfDucks)

        simulate(mallardDuck)
        simulate(redheadDuck)
        simulate(duckCall)
        simulate(rubberDuck)
        simulate(gooseDuck)
    }

    fun simulate(duck: Quackable) {
        duck.quack()
    }

}

interface Quackable : QuackObservable {
    fun quack()
}

class MallardDuck : Quackable {
    val observable: Observable
    init {
        observable = Observable(this)
    }
    override fun registerObserver(observer: Observer) {
        observable.registerObserver(observer)
    }
    override fun notifyObserver() {
        observable.notifyObserver()
    }
    override fun quack() {
        println("Quack")
        notifyObserver()
    }
}

class RedheadDuck : Quackable {
    override fun quack() = println("Quack")
}

class DuckCall : Quackable {
    override fun quack() = println("Kwak")
}

class RubberDuck : Quackable {
    override fun quack() = println("Squeak")
}

class Goose {
    fun honk() = println("Honk")
}

class GooseAdapter(val goose: Goose) : Quackable {
    override fun quack() = goose.honk()
}

class QuackCounterDecorator(val duck: Quackable) : Quackable {
    val observable : Observable
    init {
        observable = Observable(this)
    }
    companion object {
        var numberOfQuacks = 0
    }

    override fun registerObserver(observer: Observer) {
        observable.registerObserver(observer)
    }

    override fun notifyObserver() {
        observable.notifyObserver()
    }

    override fun quack() {
        duck.quack()
        notifyObserver()
        numberOfQuacks++
    }
}

abstract class AbstractDuckFactory {
    abstract fun createMallardDuck(): Quackable
    abstract fun createRedheadDuck(): Quackable
    abstract fun createDuckCall(): Quackable
    abstract fun createRubberDuck(): Quackable
    abstract fun createGooseDuck(): Quackable
}

class DuckFactory : AbstractDuckFactory() {
    override fun createMallardDuck(): Quackable = MallardDuck()
    override fun createRedheadDuck(): Quackable = RedheadDuck()
    override fun createDuckCall(): Quackable = DuckCall()
    override fun createRubberDuck(): Quackable = RubberDuck()
    override fun createGooseDuck(): Quackable = GooseAdapter(Goose())
}

class CountingDuckFactory : AbstractDuckFactory() {
    override fun createMallardDuck(): Quackable = QuackCounterDecorator(MallardDuck())
    override fun createRedheadDuck(): Quackable = QuackCounterDecorator(RedheadDuck())
    override fun createDuckCall(): Quackable = QuackCounterDecorator(DuckCall())
    override fun createRubberDuck(): Quackable = QuackCounterDecorator(RubberDuck())
    override fun createGooseDuck(): Quackable = QuackCounterDecorator(RubberDuck())
}

class Flock : Quackable {

    val observers = ArrayList<Observable>()
    val quackers = ArrayList<Quackable>()

    fun add(quacker: Quackable) {
        quackers.add(quacker)
        val observer =  Observable(quacker)
        observers.add()
    }


    override fun registerObserver(observer: Observer) {

    }

    override fun notifyObserver() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun quack() {
        val iterator: Iterator<Quackable> = quackers.iterator()
        while (iterator.hasNext()) {
            val quacker: Quackable = iterator.next()
            quacker.quack()
        }
    }
}

interface Observer{
    fun update(duck : QuackObservable)
}
class Quacklogist : Observer{
    override fun update(duck: QuackObservable) = println("Quackologist : " + duck + "just quacked")
}


interface QuackObservable {
    fun registerObserver(observer: Observer)
    fun notifyObserver()
}

class Observable(val duck: QuackObservable) : QuackObservable {
    val observers = ArrayList<Observer>()

    override fun registerObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun notifyObserver() {
        val iterator: Iterator<Observer> = observers.iterator()
        while (iterator.hasNext()) {
            val observer = iterator.next()
            observer.update(duck)
        }
    }
}
