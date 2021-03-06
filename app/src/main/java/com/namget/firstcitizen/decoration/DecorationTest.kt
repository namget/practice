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
        beverage.beverageSize = BeverageSize.GRANDE
        beverage = Mocha(beverage)
        beverage = Whip(beverage)
        beverage = Soy(beverage)
        println("description : ${beverage.getDescription()} cost : ${beverage.cost()}")

    }

}

enum class BeverageSize() {
    VENTI, GRANDE, TALL
}


//음료의 상위클래스
abstract class Beverage() {
    open var beverageSize: BeverageSize = BeverageSize.GRANDE
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
    override fun cost(): Double {
        var price: Double = 0.0
        when (beverage.beverageSize) {
            BeverageSize.VENTI -> {
                price = 0.20
            }
            BeverageSize.GRANDE -> {
                price = 0.15
            }
            BeverageSize.TALL -> {
                price = 0.1
            }
        }
        return beverage.cost() + price
    }
}

class Soy(val beverage: Beverage) : CondimentDecorator() {
    override fun getDescription(): String = beverage.getDescription() + " 두유"
    override fun cost(): Double = beverage.cost() + 0.15
}

class Whip(val beverage: Beverage) : CondimentDecorator() {
    override fun getDescription(): String = beverage.getDescription() + " 휘핑"
    override fun cost(): Double = beverage.cost() + 0.10
}