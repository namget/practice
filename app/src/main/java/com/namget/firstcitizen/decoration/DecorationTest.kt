package com.namget.firstcitizen.decoration

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.namget.firstcitizen.R

class DecorationTest : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main()
    }

    fun main() {
        var beverage: Beverage = Espresso()
        beverage.size = Beverage.Size.GRANDE
        beverage = Soy(beverage)
        beverage = Mocha(beverage)
        beverage = Whip(beverage)
        println("description : ${beverage.getDescription()} cost : ${beverage.cost()}")

    }

}


//음료의 상위클래스
abstract class Beverage() {
    open var size: Size = Size.GRANDE

    enum class Size() {
        VENTI, GRANDE, TALL
    }

    abstract fun getDescription(): String
    abstract fun cost(): Double
}

//하우스 블랜드 커피
class HouseBlend() : Beverage() {
    override fun getDescription(): String = "하우스 블렌드 커피"
    override fun cost(): Double = 0.89
}

// 에스프레소
class Espresso() : Beverage() {
    override fun getDescription(): String = "에스프레소"
    override fun cost(): Double = 1.99
}

// 첨가물 데코레이터
abstract class CondimentDecorator : Beverage() {
}

class Mocha(val beverage: Beverage) : CondimentDecorator() {
    override fun getDescription(): String = beverage.getDescription() + " 모카"
    override fun cost(): Double = beverage.cost() + 0.20
}

class Soy(val beverage: Beverage) : CondimentDecorator() {
    override fun getDescription(): String = beverage.getDescription() + " 두유"
    override fun cost(): Double = beverage.cost() + 0.15
}

class Whip(val beverage: Beverage) : CondimentDecorator() {
    override fun getDescription(): String = beverage.getDescription() + " 휘핑"
    override fun cost(): Double = beverage.cost() + 0.10
}