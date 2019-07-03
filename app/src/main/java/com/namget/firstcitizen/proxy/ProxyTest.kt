package com.namget.firstcitizen.proxy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class ProxyTest : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main()
    }

}

fun main() {
    val count = 10;
    val gumballMachine: GumballMachine = GumballMachine("서울", 10)
    val monitor = GumballMonitor(gumballMachine)
}


interface State {
    fun insertQuarter()
    fun ejectQuarter()
    fun turnCrank()
    fun dipense()
}

class GumballMachine(val location: String, val count: Int) {

}

class GumballMonitor(val machine: GumballMachine) {

    fun report() {
        println("뽑기 기계 위치: ${machine.location}")
        println("현재 재고: ${machine.count}")
    }

}