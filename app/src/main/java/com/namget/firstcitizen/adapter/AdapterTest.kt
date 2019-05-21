package com.namget.firstcitizen.adapter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class AdapterTest : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}

fun main(){
    var mallardDuck = MallardDuck()
    var wildTurkey = WildTurkey()
    var turkeyAdapter : Duck = TurkeyAdapter(wildTurkey)
    // turkey우는거는
    wildTurkey.gobble()
    wildTurkey.fly()
    //duck 우는거는
    testDuck(mallardDuck)
    // turkeyAdapter의 우는거는
    testDuck(turkeyAdapter)
}
fun testDuck(duck : Duck){
    duck.quack()
    duck.fly()
}


interface Duck {
    fun quack() // 꽥꽥
    fun fly() // 멀리날아감
}

class MallardDuck : Duck {
    override fun quack() {
        println("quack")
    }

    override fun fly() {
        println("I'm fiying")
    }
}

interface Turkey {
    fun gobble() // 골골
    fun fly() // 조금 날아감
}

class WildTurkey : Turkey {
    override fun gobble() {
        println("Gobble gobble")
    }

    override fun fly() {
        println("I'm flying a short distance")
    }
}

class TurkeyAdapter(val turkey: Turkey) : Duck {
    override fun quack() {
        turkey.gobble()
    }

    override fun fly() {
        for (i in 0..4)
            turkey.fly()
    }
}


