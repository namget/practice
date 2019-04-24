package com.namget.firstcitizen.strategy

/*fly 에 대한 정의*/
interface flyBehavior {
    fun fly()
}

class FlyWithWings() : flyBehavior {
    override fun fly() = println("난 날수 있어")
}

class FlyNoWay() : flyBehavior {
    override fun fly() = println("난 날수 없어")
}

/*quack에 대한 정의*/
interface QuackBehavior {
    fun Quack()
}

class Quack : QuackBehavior {
    override fun Quack() = println("꿱꿱!!")
}

class Squeak : QuackBehavior {
    override fun Quack() = println("삑삑!!")
}

class MuteQuack() : QuackBehavior {
    override fun Quack() = println("나는 소리를 못내!")
}


abstract class Duck {
    lateinit var quackBehavior: QuackBehavior
    lateinit var flyBehavior: flyBehavior
    fun performQuack() = quackBehavior.Quack()
    fun performFly() = flyBehavior.fly()
    fun swim() = println("모든 오리는 물에 뜹니다.")
    abstract fun display()
}

class MallardDuck : Duck() {
    init {
        quackBehavior = Quack() // 꿱꿱!
        flyBehavior = FlyWithWings() //오리 날다.
    }

    override fun display() = println("나는 MallardDuck 이다.")
}

class DuckModel : Duck() {

    override fun display() = println("나는 duck model 이다.")
}