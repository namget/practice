package com.namget.firstcitizen.strategy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class StrategySimulator : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mallardDuck = MallardDuck()
        mallardDuck.performQuack()
        mallardDuck.performFly()

    }
}