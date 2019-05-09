package com.namget.firstcitizen.factory


/*
fun main() {
    val nyPizzaStore = NewYorkPizzaStore()
    nyPizzaStore.orderPizza(PizzaType.CHEESE)
    //order 안속 create가 불리고 피자를 생성

}

abstract class Pizza(
    var name: String = "",
    var dough: String = "",
    var saure: String = "",
    var toppings: ArrayList<String> = arrayListOf()
) {

    fun prepare() {
        println("prepare $name")
        println("tossing dough $dough")
        println("adding saure $saure")
        println("adding toppings ")
        for (i in toppings)
            println("adding toppings $i")

    }

    open fun bake() {
        println("Bake for 25 minute at 350 ")
    }

    open fun cut() {
        println("cut cut pizza into diagonal slices")
    }

    open fun box() {
        println("place pizza in pizzaStore")
    }
}

class NYStyleCheesePizza() : Pizza() {
    init {
        name = "NY Style Sauce and Cheese Pizza"
        dough = "Thin Crust Dough"
        saure = "Marinara Sauce"
        toppings.add("Grated Reggiano Cheese")
    }
}

class ChicagoStyleCheesePizza() : Pizza() {
    init {
        name = "Chichago Style Deep Dish Cheese Pizza"
        dough = "Extra Thick Crust Dough"
        saure = "Plum Tomato Sauce"
        toppings.add("Shredded Mozzarella Cheese")
    }

    override fun cut() {
        println("cut cut pizza into square slices")
    }
}


//open class Pizza() {
//    fun prepare() {}
//    fun bake() {}
//    fun cut() {}
//    fun box() {}
//}

class CheessPizza : Pizza()
class GreekPizza : Pizza()
class PepperoniPizza() : Pizza()


class NYStyleGreekPizza() : Pizza()
class ChicagoStyleGreekPizza() : Pizza()

class NYStylePepperoniPizza() : Pizza()
class ChicagoStylePepperoniPizza() : Pizza()

enum class PizzaType {
    CHEESE, GREEK, PEPPRONI
}
enum class PizzaStyle {
    NY, CHICAGO, CALI
}

abstract class PizzaStore() {
    fun orderPizza(type: PizzaType): Pizza {
        val pizza: Pizza = createPizza(type)

        pizza.apply {
            prepare()
            bake()
            cut()
            box()
        }
        return pizza
    }

    abstract fun createPizza(type: PizzaType): Pizza
}

class NewYorkPizzaStore() : PizzaStore() {
    override fun createPizza(type: PizzaType): Pizza {
        var pizza: Pizza
        when (type) {
            PizzaType.CHEESE -> pizza = NYStyleCheesePizza()
            PizzaType.GREEK -> pizza = NYStyleGreekPizza()
            PizzaType.PEPPRONI -> pizza = NYStylePepperoniPizza()
        }
        return pizza
    }
}

class ChicagoPizzaStore() : PizzaStore() {
    override fun createPizza(type: PizzaType): Pizza {
        var pizza: Pizza
        when (type) {
            PizzaType.CHEESE -> pizza = ChicagoStyleCheesePizza()
            PizzaType.GREEK -> pizza = ChicagoStyleGreekPizza()
            PizzaType.PEPPRONI -> pizza = ChicagoStylePepperoniPizza()
        }
        return pizza
    }
}

class SimplePizzaFactory {
    fun createPizza(type: PizzaType): Pizza {
        var pizza: Pizza
        when (type) {
            PizzaType.CHEESE -> pizza = CheessPizza()
            PizzaType.GREEK -> pizza = GreekPizza()
            PizzaType.PEPPRONI -> pizza = PepperoniPizza()
        }
        return pizza
    }
}*/
