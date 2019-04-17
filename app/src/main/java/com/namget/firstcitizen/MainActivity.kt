package com.namget.firstcitizen

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    val dp = CompositeDisposable()

    override fun onDestroy() {
        super.onDestroy()
        dp.clear()
    }

    open class Parent {
        fun hi() {
            TODO()
        }
    }

    class Child : Parent()

    class Children<out T : Parent> {
        val name = ""
        fun get(): T {
            TODO()
        }
    }

    fun getChild(children: Children<Parent>) {
        children.get()
    }


    open class Animal {
        fun feed() {
            TODO()
        }
    }

    class Cat : Animal()

    class Herd<T : Animal> {
        val size: Int get() = TODO()
        operator fun get(i: Int): T {
            TODO()
        }
    }

    fun feedAll(animals: Herd<Animal>) {
        for (i in 0 until animals.size) {
            animals[i].feed()
        }
    }


    open class A() {
        val x = 0
        val y = 1
    }

    class B : A() {
        val z = 2
    }


    var myString: String? = null


//    fun kotlinFunction(num: Int, name: String, height: Double): Unit {
//        TODO
//    }

    fun kotlinFunction(num: Int, name: String, height: Double, test: Int) {
//        TODO
    }

    fun kotlinFunction(num: Int = 100, name: String = "") {
//        TODO
    }

    inline fun foo(inlined: () -> Unit) {
        Log.e("first", "inlined foo")
    }

    fun foo2(inlined: () -> Unit) {
        Log.e("first", "noinlined foo2")
    }

    fun foo3() {
        foo {
            Log.e("first", "aa")
//            return
        }
    }

    inline fun doSomeThing(body: () -> Unit) {
        body()
    }

    fun callFunction() {
        doSomeThing { print("test") }
    }

    interface Vehicle {
        fun drive(): String
    }

    class CarImpl(val where: String) : Vehicle {
        override fun drive() = "is going to $where"
    }

    class AirplaneImpl(val where: String) : Vehicle {
        override fun drive() = "is flying to $where"
    }

    class CarOrAirplace(val model: String, impl: Vehicle) : Vehicle by impl {
        fun tellMeYourTrip() {
            println("$model ${drive()}")
        }
    }

    fun main(args: Array<String>) {
        val myAirbus330 = CarOrAirplace("Lamborghini", CarImpl("Seoul"))
        val myBoeing337 = CarOrAirplace("boeing 33u7", AirplaneImpl("Seoul"))
        myAirbus330.tellMeYourTrip()
        myBoeing337.tellMeYourTrip()
    }


    suspend fun doSomeThingUsefulOne(): Int {
        delay(1000)
        return 13
    }

    suspend fun doSomeThingUsefulTwo(): Int {
        delay(1000)
        return 29
    }

    class LogUtil {
        companion object {
            fun e(a: String, b: String) {
            }
        }
    }

    val test = mapOf("k1" to 1)
    open class O {
    }
    class P : O(){
    }
    open class S() {
        val a = 10
    }
    class S2() : S() {
        val b = 1
    }



    fun q1() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val empty = emptyList<Int>()
//        val emptyReduce = empty.reduce { sum, num -> sum + num }
        val emptyFold = empty.fold(1) { sum, num -> sum + num }
        Log.e("output :", "emptyFold : ${emptyFold}")


        val sum = numbers.filter { num -> num % 2 == 0 }.sum()
        val fold = numbers.fold(1) { sum, num -> sum + num }
        val reduced = numbers.reduce { sum, num -> sum + num }
        val grouped = numbers.groupBy { num -> num % 2 == 1 }
            .map { group -> group.value }
            .minBy { nums -> nums.sum() }
            ?.map { num -> num * 2 }
            ?.sum()

//        val grouped2 = numbers.groupBy { num -> num % 2 == 1 }
        val grouped2 = numbers.groupBy({ num -> num % 2 == 1 }, { num -> num * 2 })

        val grouped3 = numbers.groupBy({ num -> num % 2 == 1 }, { num -> num })
            .map { group -> group.value }

        val grouped4 = numbers.groupBy { num -> num % 2 == 1 }
            .map { it.value }
            .minBy { nums -> nums.sum() }


        Log.e("output :", "sum : ${sum}")
        Log.e("output :", "fold : ${fold}")
        Log.e("output :", "reduced : ${reduced}")
        Log.e("output :", "grouped : ${grouped}")
        Log.e("output :", "grouped2 : ${grouped2}")
        Log.e("output :", "grouped3 : ${grouped3}")
        Log.e("output :", "grouped4 : ${grouped4}")
    }

    interface mList<out T> {
        fun get()
    }
    interface mMutableList<T> : mList<T>{
        fun add()
    }

    fun test(){
        val a : mList<String>
        val b : mMutableList<String>

        a = object : mList<String>{
            override fun get() {

            }
        }

        b = object : mMutableList<String>{
            override fun get() {

            }

            override fun add() {

            }
        }
        println("t1 : " + (a is mList<*>))
        println("t2 : " + (a is mMutableList<*>))
        println("t3 : " + (b is mList<*>))
        println("t4 : " + (b is mMutableList<*>))

    }


    fun q2() {
        val x : List<Int> = listOf(1, 2, 3)
        val z : MutableList<Int> = MutableList(3,{0})
        val y = arrayListOf(1, 2, 3)

        test()



        println(x is List<*>)
        println(x is MutableList<*>)
        println(x is java.util.List<*>)

        println(y is List<*>)
        println(y is MutableList<*>)
        println(y is java.util.List<*>)
        var s = S()
        var s2 = S2()
        s = s2
        println("sa = ${s.a}")
        println("sa = ${s.a}")
        println("sb = ${s.b}")

    }

    fun q3(){
        val i = 3

        when(i){
            in  4..1 -> println("in")
            !in 4..1 -> println("!in")
            else -> println("else")
        }
    }

    fun q4(){
        println(deciamlDigitValue())
        println('0'.toInt())
        println("0".toInt())
        println(('0'.toInt() - "0".toInt()))
        println(('0'.toInt() - "0".toInt() < 0))
        println(('0'.toInt() - "0".toInt() == 0))

    }

    fun deciamlDigitValue(): String = when{
        '0'.toInt() - "0".toInt() < 0 -> "negative"
        '0'.toInt() - "0".toInt() == 0 -> "zero"
        '0'.toInt() - "0".toInt() > 0 -> "aaa"
        else -> "positive"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        q4()

        val job = CoroutineScope(Dispatchers.Default).launch {

        }




//        kotlinFunction(100, "이재우", 180.0)
//
//
//
//        kotlinFunction(100, "이재우", test = 100, height = 100.0)

//        var a = A()
//        var b = B()
//        b = a

//        var myInt: Int? = null


//        myInt?.let { it.toString() }
//
//        Log.e("myInt ", "myInt is = ${myInt?.toString()}")
//        Log.e("myInt ", "myInt is = ${myInt?.toString() ?: "널 에 대한 default값 표시"}")
//
//        val a: KotlinModel = KotlinModel("1", 180.0, 80.0)
//        a.weight = 10.0
//        a.height = 10.0
//
//
//        var name2 = "이재우"
//        var name: String = "이재우"
//        print("$name 입니다")
//
//        val MAX = 1


//        fun copy(from: Array<out Any>, to: Array<Any>) {  }
//        fun fill(dest: Array<in String>, value: String) { }
//
//        class Array<T>(val size: Int) {
//            fun get(index: Int): T {  }
//            fun set(index: Int, value: T) {  }
//        }
//
//        val child = Children<Child>()
//        getChild(child)

//        val cats = Herd<Cat>()
//        feedAll(cats)


//        val test1 = Observable.just("1", "2", "3").delay(2, TimeUnit.SECONDS)
//        val test2 = Observable.just("apple", "banana", "car")
//        val test3 = Observable.interval(2, TimeUnit.SECONDS)
//
//
//        val a: Subject<String> = BehaviorSubject.create()
//        a.onNext("a")
//        a.observeOn(AndroidSchedulers.mainThread())
//            .subscribe { v -> Log.e("aa1", v) }
//        a.onNext("b")
//        a.onNext("c")
//        a.observeOn(AndroidSchedulers.mainThread()).subscribe { v -> Log.e("aa2", v) }
//        a.observeOn(AndroidSchedulers.mainThread()).subscribe { v -> Log.e("aa3", v) }
//        a.subscribe({t->Log.e("aa4", t)},{e-> Log.e("aa5", "${e}")},{Log.e("aa6", "complete")})
//        a.onComplete()

//        Observable.zip(test3, test2, BiFunction { t1: Long, t2: String -> t1.toString() + t2 })
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                Log.e("zip observable ${System.currentTimeMillis()}", it)
//            }, {
//
//            }, {
//                Log.e("zip observable ", "complete")
//            })

//        dp.add(Observable.merge(test1, test2).subscribe({
//            Log.e("merge observable", it)
//        }, {
//            Log.e("merge observable", "error")
//        }, {
//            Log.e("merge observable", "complete")
//        }))

//        dp.add(Observable.concat(test1, test2).subscribe({
//            Log.e("concat observable", it)
//        }, {
//            Log.e("concat observable", "error")
//        }, {
//            Log.e("concat observable", "complete")
//        }))


//        dp.add(Observable.merge(test1, test2).subscribe({
//            Log.e("merge observable", it)
//        }, {
//            Log.e("merge observable", "error")
//        }, {
//            Log.e("merge observable", "complete")
//        }))


//        Observable.zip(test3, test2, object : BiFunction<Long, String, String> {
//            override fun apply(t1: Long, t2: String): String {
//                return t1.toString() + t2
//            }
//        }).observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                Log.e("zip observable ${System.currentTimeMillis()}", it)
//            }, {
//
//            }, {
//                Log.e("zip observable ", "complete")
//            })

//        Observable.zip(test3, test2, BiFunction { t1: Long, t2: String -> t1.toString() + t2 })
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                Log.e("zip observable ${System.currentTimeMillis()}", it)
//            }, {
//
//            }, {
//                Log.e("zip observable ", "complete")
//            })


//        mytest { Main.test("a111", "b222") }
//        mytest { Main.test1() }
//        mytest { Main.test2(1000) }
//        mytest(::println)
//
//        calculator(::sum)
//        val s: (Int, Int) -> Int = { a, b -> a + b }
//        calculator(s)
//
//        calculator({ a, b -> a + b })
//
//        val sumTotal = listOf(1, 2, 3, 4, 5).fold(0, { total, next -> total + next })
//        println("sumTotal : ${sumTotal}")
//        // sumTotal : 15
//
//        val mulTotal = listOf(1, 2, 3, 4, 5).fold(1, { total, next -> total * next })
//        println("mulTotal : ${mulTotal}")
//        // mulTotal : 120
//
//        val appleList = listOf(
//            Apple("a++", 500),
//            Apple("a+", 400),
//            Apple("a", 300),
//            Apple("b", 200),
//            Apple("c", 100)
//        )
//
//        val applePrice = appleList.map { it.price }.fold(0, { total, next -> total + next })
//        println("applePrice : ${applePrice}")
//        // mulTotal : 1500


    }


}
