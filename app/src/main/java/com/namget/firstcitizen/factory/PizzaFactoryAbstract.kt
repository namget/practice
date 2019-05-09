package com.namget.firstcitizen.factory

interface PizzaIngredientFactory {
    fun createDough(): Dough
    fun createSauce(): Sauce
    fun createCheese(): Cheese
    fun createVeggies(): Array<Viggies>
    fun createPepperoni(): Pepperoni
    fun createClam(): Clams
}

interface Dough
interface Sauce
interface Cheese
interface Viggies
interface Pepperoni
interface Clams

class NYPizzaIngredientFactory : PizzaIngredientFactory {
    override fun createDough(): Dough = ThinCrustDough()
    override fun createSauce(): Sauce = MarinaraSauce()
    override fun createCheese(): Cheese = ReggianoCheese()
    override fun createVeggies(): Array<Viggies> = arrayOf(Garlic(), Onion(), Mushroom(), RedPapper())
    override fun createPepperoni(): Pepperoni = SlicedPepperoni()
    override fun createClam(): Clams = FreshClams()
}

class ThinCrustDough : Dough
class MarinaraSauce : Sauce
class ReggianoCheese : Cheese
class Garlic : Viggies
class Onion : Viggies
class Mushroom : Viggies
class RedPapper : Viggies
class SlicedPepperoni : Pepperoni
class FreshClams : Clams

abstract class Pizza {

    var name: String? = null
    var dough: Dough? = null
    var sauce: Sauce? = null
    var viggies: Array<Viggies>? = null
    var cheese: Cheese? = null
    var pepperoni: Pepperoni? = null
    var clams: Clams? = null

    abstract fun prepare()

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

class CheesePizza(val pizzaIngredientFactory: PizzaIngredientFactory) : Pizza() {
    override fun prepare() {
        println("Preparing $name")
        dough = pizzaIngredientFactory.createDough()
        sauce = pizzaIngredientFactory.createSauce()
        cheese = pizzaIngredientFactory.createCheese()
    }
}


class ClamPizza(val pizzaIngredientFactory: PizzaIngredientFactory) : Pizza() {
    override fun prepare() {
        println("Preparing $name")
        dough = pizzaIngredientFactory.createDough()
        sauce = pizzaIngredientFactory.createSauce()
        cheese = pizzaIngredientFactory.createCheese()
        clams = pizzaIngredientFactory.createClam()
    }
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

class NYPizzaStore : PizzaStore() {
    override fun createPizza(type: PizzaType): Pizza {
        var pizza: Pizza
        val pizzaIngredientFactory = NYPizzaIngredientFactory()
        if (type == PizzaType.CHEESE) {
            pizza = CheesePizza(pizzaIngredientFactory)
            pizza.name = "NewYork Style Cheese Pizza"
        } else if (type == PizzaType.CLAM) {
            pizza = ClamPizza(pizzaIngredientFactory)
            pizza.name = "NewYork Style Cheese Pizza"
        }else{
            throw Exception()
        }
        return pizza
    }
}

enum class PizzaType {
    CHEESE, GREEK, PEPPRONI, CLAM
}

enum class PizzaStyle {
    NY, CHICAGO, CALI
}