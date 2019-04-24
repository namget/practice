package com.namget.firstcitizen.strategy

abstract class BeforeDuck(){
    fun quack() = println("꿱꿱")
    fun swim() = println("수영가능합니다.")
    abstract fun display()
}