package com.namget.firstcitizen.lsp


//직사각형
open class Rectangle() {
    open var width: Int = 0
    open var height: Int = 0


    fun getArea(): Int = (this.width * this.height)
}

class Calculator() {
    lateinit var rectangle: Rectangle
    fun calculateArea() {
        rectangle = Square()
        rectangle.width = 4
        rectangle.height = 5
    }

    fun printArea() = println(rectangle.getArea())
}

class Square() : Rectangle() {
    override var width: Int
        get() = this.width
        set(value) {
            width = value
            height = value
        }

    override var height: Int
        get() = this.height
        set(value) {
            width = value
            height = value
        }

}


class Main() {
    fun main() {
        val calculator: Calculator = Calculator()
        calculator.calculateArea()
        calculator.printArea()
    }
}