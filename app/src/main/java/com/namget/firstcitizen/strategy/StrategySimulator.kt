package com.namget.firstcitizen.strategy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class StrategySimulator : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mallardDuck = MallardDuck()
        mallardDuck.performQuack() //  print 꿱꿱
        mallardDuck.performFly() // 오리날다.
        mallardDuck.flyBehavior = FlyNoWay()
        mallardDuck.quackBehavior = Squeak()

    }
}