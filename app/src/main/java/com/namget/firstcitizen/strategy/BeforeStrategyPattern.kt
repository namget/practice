package com.namget.firstcitizen.strategy

abstract class BeforeDuck(){
    open fun quack() = println("꿱꿱")
    fun swim() = println("수영가능합니다.")
    open fun fly() = println("나는 날 수 있어!")
    abstract fun display()
}

class NotFlyDuck() : BeforeDuck(){
    override fun fly() = println("나는 날지 못해!!!!!")
    override fun display() {
        //러버덕
    }
}



interface Flyable{
    fun fly()
}

interface Quackable{
    fun quack()
}

class MyDuck() : BeforeDuck() , Flyable , Quackable{
    override fun display() {
        //
    }

    override fun fly() {
        //하늘을 난다.
    }

    override fun quack() {
        //꿱꿱
    }
}


class RubberDuck() : BeforeDuck(){
    override fun quack() {
        println("삑삑")
    }
    override fun display() {
      //러버덕
    }
}