package com.namget.firstcitizen.factory

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.namget.firstcitizen.R

class MyAbstractFactory : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main2()
    }
}

fun main2(){

}

interface RamenIngedientFactory{
    fun putWater()
    fun putSauce()
    fun putNoodle()
}

interface Water
interface Sauce
interface Noodle



//class KRNugoriFactory : RamenIngedientFactory{
//
//}
//
//class JPNugoriFactory : RamenIngedientFactory{
//
//}