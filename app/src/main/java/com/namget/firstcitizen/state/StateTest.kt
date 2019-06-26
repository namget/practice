package com.namget.firstcitizen.state

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlin.random.Random

class StateTest : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}

class GumballMachine(val count: Int) {
    val soldOutState: State
    val noQuarterState: State
    val hasQuarterState: State
    val soldState: State
    val winnerState: State
    lateinit var state: State

    init {
        soldOutState = SoldOutState(this)
        noQuarterState = NoQuarterState(this)
        hasQuarterState = HasQuarterState(this)
        soldState = SoldState(this)
        winnerState = WinnerState(this)
        state = soldOutState
        if (count > 0) {
            state = noQuarterState
        }
    }

    fun insertQuarter() {
        state.insertQuarter()
    }

    fun ejectQuarter() {
        state.ejectQuarter()
    }

    //손잡이 돌리기
    fun turnCrank() {
        state.turnCrank()
    }

    //알맹이 꺼내기
    fun dispense() {
        state.dipense()
    }
}

interface State {
    fun insertQuarter()
    fun ejectQuarter()
    fun turnCrank()
    fun dipense()
}

class SoldState(val gumballMachine: GumballMachine) : State {
    override fun insertQuarter() {}
    override fun ejectQuarter() {}
    override fun turnCrank() {}
    override fun dipense() {}
}

class SoldOutState(val gumballMachine: GumballMachine) : State {
    override fun insertQuarter() {}
    override fun ejectQuarter() {}
    override fun turnCrank() {}
    override fun dipense() {}
}

class NoQuarterState(val gumballMachine: GumballMachine) : State {
    override fun insertQuarter() {
        println("동전을 넣으셨습니다.")
        gumballMachine.state = gumballMachine.hasQuarterState
    }

    override fun ejectQuarter() = println("동전을 넣어주세요")
    override fun turnCrank() = println("동전을 넣어주세요")
    override fun dipense() = println("동전을 넣어주세요")
}

class HasQuarterState(val gumballMachine: GumballMachine) : State {
    val random = Random(System.currentTimeMillis())

    override fun insertQuarter() = println("동전은 한개만 넣어주세요")
    override fun ejectQuarter() {
        println("동전이 반환됩니다.")
        gumballMachine.state = gumballMachine.noQuarterState
    }

    override fun turnCrank() {
        println("손잡이를 돌리셨습니다..")
        val result =  random.nextInt(10)
        if(result == 0){
            gumballMachine.state = gumballMachine.winnerState
        }else {
            gumballMachine.state = gumballMachine.soldState
        }
    }

    override fun dipense() = println("알맹이가 나갈 수 없습니다.")
}

class WinnerState(val gumballMachine: GumballMachine) : State {
    override fun insertQuarter() = println("오류")
    override fun ejectQuarter() = println("오류")
    override fun turnCrank() = println("오류")
    override fun dipense() = println("축하합니다 알맹이를 하나 더 받으실 수 있습니다.")
}








