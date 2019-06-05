package com.namget.firstcitizen.templatemethod

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

class TemplateMethodTest : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }
}

fun main() {
    val tea = Tea()
    tea.prepareRecipe()
}


class Coffee : CaffineBeverage() {
    override fun brew() = println("필터를 통해서 커피를 우려내는 중")
    override fun addCondiment() = println("설탕과 우유를 추가하는중")
}

class Tea : CaffineBeverage() {
    override fun brew() = println("차를 우려내는중")
    override fun addCondiment() = println("레몬을 추가하는 중")
    override fun customerWantsCondiemnts(): Boolean {
        val answer = getUserName()
        if(answer.toLowerCase().startsWith("y")){
            return true
        }else{
            return false
        }

    }
    fun getUserName() = "y"
}

abstract class CaffineBeverage {
    fun prepareRecipe() {
        boilWater()
        brew()
        pourInCup()
        if (customerWantsCondiemnts())
            addCondiment()
    }

    abstract fun brew()
    abstract fun addCondiment()
    fun boilWater() = println("물 끓이는중")
    fun pourInCup() = println("컵에 따르는중")
    open fun customerWantsCondiemnts(): Boolean = true
}