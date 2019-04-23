package com.namget.firstcitizen.ocp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class OCPTest : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main()
    }

    interface Animal {
        fun moving()
        fun crying()
    }




    class Cat() : Animal {
        override fun moving() = println("cat is moving")
        override fun crying() = println("meow")
    }

    class Dog() : Animal {
        override fun moving() = println("dog is moving")
        override fun crying() = println("woof woof")
    }

    class Duck() : Animal {
        override fun moving() = println("duck is flying")
        override fun crying() = println("quack quack")
    }

    class Shark() : Animal{
        override fun moving() = println("shark is swimming")
        override fun crying() = println("Ddadan Ddadan")
    }

    data class ZooManage(var animal: Animal? = null) {
        fun moving() = animal?.moving()
        fun crying() = animal?.crying()
    }

    fun main() {
        val myAnimal: ZooManage = ZooManage()
        myAnimal.animal = Cat()
        myAnimal.crying()
        myAnimal.moving()
        myAnimal.animal = Dog()
        myAnimal.crying()
        myAnimal.moving()
        myAnimal.animal = Duck()
        myAnimal.crying()
        myAnimal.moving()
    }


}