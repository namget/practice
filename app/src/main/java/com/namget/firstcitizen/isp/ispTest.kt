package com.namget.firstcitizen.isp


interface Action{
    fun print()
    fun copy()
    fun eat()
    fun drive()
}



interface PrinerAction{
    fun print()
    fun copy()
}


class Printer : PrinerAction{
    override fun print() {
        //print
    }
    override fun copy() {
        //copy
    }
}

interface PersonAction{
    fun eat()
    fun drive()
}
class Person : PersonAction {
    override fun eat() {
        //eat
    }

    override fun drive() {
        //drivwe
    }
}


