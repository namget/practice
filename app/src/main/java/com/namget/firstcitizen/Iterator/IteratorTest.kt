package com.namget.firstcitizen.Iterator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class IteratorTest : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}


class MenuItem(
    val name: String,
    val description: String,
    val vegetarian: Boolean,
    val price: Double
)

class pancakeHouseMenu(val menuItems: ArrayList<MenuItem> = arrayListOf()) {
    init {
        addItem("펜케이크1", "맛있음1", true, 2.99)
        addItem("펜케이크2", "맛있음2", false, 2.99)
        addItem("펜케이크3", "맛있음3", true, 3.49)
        addItem("펜케이크4", "맛있음4", true, 3.59)
    }

    fun createIterator(): Iterator<MenuItem> = PancakeHouseIterator(menuItems)


    fun addItem(
        name: String,
        description: String,
        vegetarian: Boolean,
        price: Double
    ) = menuItems.add(MenuItem(name, description, vegetarian, price))
}


class DinerMenu(var menuItems: Array<MenuItem?>) {
    val MAXSIZE = 6
    var numberofItems: Int = 6

    init {
        menuItems = arrayOfNulls<MenuItem>(MAXSIZE)
        addItem("베이컨 상추메뉴", "맛있음1", true, 2.99)
        addItem("통밀", "맛있음2", false, 2.99)
        addItem("스프", "맛있음3", false, 3.29)
        addItem("핫도그", "맛있음4", false, 3.05)
    }

    fun createIterator(): Iterator<MenuItem> = DinerMenuIterator(menuItems)

    fun addItem(
        name: String,
        description: String,
        vegetarian: Boolean,
        price: Double
    ) {
        val menu = MenuItem(name, description, vegetarian, price)
        if (numberofItems >= MAXSIZE) {
            println("메뉴 꽉 찼습니다.")
        } else {
            menuItems[numberofItems] = menu
            numberofItems++
        }
    }
}

class DinerMenuIterator(val items: Array<MenuItem?>) : Iterator<MenuItem> {
    var position: Int = 0

    override fun hasNext(): Boolean {
        return pos()
    }

    fun pos() = position >= items.size

    override fun next(): MenuItem {
        val menuItem = items[position]
        position++
        return menuItem!!
    }
}


class PancakeHouseIterator(val items: ArrayList<MenuItem>) : Iterator<MenuItem> {
    var position: Int = 0

    override fun hasNext(): Boolean {
        return pos()
    }

    fun pos() = position >= items.size

    override fun next(): MenuItem {
        val menuItem = items[position]
        position++
        return menuItem
    }
}

class Waitress(val pancakeHouseMenu: pancakeHouseMenu, val dinerMenu: DinerMenu) {
    fun printMenu() {
        val pancakeHouseIterator: Iterator<MenuItem> = pancakeHouseMenu.createIterator()
        val dinerIterator: Iterator<MenuItem> = dinerMenu.createIterator()
        println("메뉴 ---  아침메뉴")
        printMenu(pancakeHouseIterator)
        println("메뉴 ---  점심메뉴")
        printMenu(dinerIterator)
    }
    fun printMenu(iterator: Iterator<MenuItem>){
        while (iterator.hasNext()){
            val menuItem = iterator.next()
            println(menuItem.name)
            println(menuItem.price)
            println(menuItem.description)
        }
    }
}


//fun printMenu() // 메뉴에 있는 모든 항목을 추천
//fun printBreakfastMenu() // 아침 식사 항목만 출력
//fun printLaunchMenu() // 점심 식사 항목만 출력
//fun printVegetarianMenu() //채식주의자용 메뉴 항목만 출력
//fun isItemVegetarian() // 채식주의자면 true 아니면 false
