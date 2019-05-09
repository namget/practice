package com.namget.firstcitizen.factory


//open class Pizza() {
//    fun prepare() {}
//    fun bake() {}
//    fun cut() {}
//    fun box() {}
//}
//
//class CheessPizza : Pizza()
//class GreekPizza : Pizza()
//class PepperoniPizza() : Pizza()
//
////fun orderPizza(): Pizza {
////    val pizza = Pizza().apply {
////        prepare()
////        bake()
////        cut()
////        bake()
////    }
////    return pizza
////}
////
//
//enum class PizzaType {
//    CHEESE, GREEK, PEPPRONI
//}
//
//class PizzaStore(val factory: SimplePizzaFactory) {
//
//    fun orderPizza(type: PizzaType): Pizza {
//        val pizza: Pizza = factory.createPizza(type)
//        pizza.apply {
//            prepare()
//            bake()
//            cut()
//            bake()
//        }
//        return pizza
//    }
//}
//
//class SimplePizzaFactory {
//    fun createPizza(type: PizzaType): Pizza {
//        var pizza: Pizza
//        when (type) {
//            PizzaType.CHEESE -> pizza = CheessPizza()
//            PizzaType.GREEK -> pizza = GreekPizza()
//            PizzaType.PEPPRONI -> pizza = PepperoniPizza()
//        }
//        return pizza
//    }
//}

//class DependentPizzaStore() {
//    fun createPizza(style: PizzaStyle, type: PizzaType): Pizza {
//        var pizza: Pizza
//        when (style) {
//            PizzaStyle.NY -> {
//                when (type) {
//                    PizzaType.CHEESE -> pizza = NYStyleCheesePizza()
//                    PizzaType.GREEK -> pizza = NYStyleGreekPizza()
//                    PizzaType.PEPPRONI -> pizza = NYStylePepperoniPizza()
//                }
//            }
//
//            PizzaStyle.CHICAGO -> {
//                when (type) {
//                    PizzaType.CHEESE -> pizza = ChicagoStyleCheesePizza()
//                    PizzaType.GREEK -> pizza = ChicagoStyleGreekPizza()
//                    PizzaType.PEPPRONI -> pizza = ChicagoStylePepperoniPizza()
//                }
//            }
//            else -> {
//                throw Exception()
//            }
//        }
//        pizza.apply {
//            prepare()
//            bake()
//            cut()
//            box()
//        }
//        return pizza
//    }
//}