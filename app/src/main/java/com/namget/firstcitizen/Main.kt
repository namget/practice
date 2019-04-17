package com.namget.firstcitizen

object Main {
    val test1: () -> Unit = { println("firstCitizen") }
    // firstCitizen
    val test2: (Int) -> Unit = { println("firstCitizen : ${it}") }
    val test: (String, String) -> Unit = { a, b -> println("a : ${a} , b: ${b}") }

    fun calculator (result : (Int,Int) -> Int) : Int{
      return result(1,2)
    }
    fun sum(a : Int , b : Int) = a + b



    fun mytest(f: () -> Unit) {
        f.invoke()
    }

    fun mtest(): () -> Unit {
        return { println("firstCitizen") }
    }


}