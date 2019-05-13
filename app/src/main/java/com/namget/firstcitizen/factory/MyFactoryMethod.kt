package com.namget.firstcitizen.factory

//factory 과제

//class MyFactoryMethod : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        main1()
//    }
//}
//
//
//fun main1() {
//    val KRRamenStore = KRRamenStore()
//    KRRamenStore.orderRamen(RamenType.SINRAMEN)
//
//    val JPRmenStore = JPRamneStore()
//    JPRmenStore.orderRamen(RamenType.SINRAMEN)
//}
//
//abstract class Ramen(
//    var noodle: String = "",
//    var sauce: String = "",
//    var water: String = ""
//) {
//    fun prepare() {
//        println("prepare")
//    }
//
//    fun putNoodle() {
//        println("put Noodle $noodle")
//    }
//
//    fun putWater() {
//        println("put water $water")
//    }
//
//    open fun boil() {
//        println("boil 3 minute")
//    }
//
//    fun putSauce() {
//        println("put Sauce $sauce")
//    }
//}
//
//class KRSinRamen : Ramen() {
//    init {
//        noodle = "KR style Normal Noodle"
//        sauce = "KR style SinRamen Sauce"
//        water = "450ml"
//    }
//}
//
//class JPSinRamen : Ramen() {
//    init {
//        noodle = "KR style Normal Noodle"
//        sauce = "KR style SinRamen Sauce"
//        water = "500ml"
//    }
//}
//
//class KRNuguri : Ramen() {
//    init {
//        noodle = "KR style Thick Noodle"
//        sauce = "KR style Nuguri Sauce"
//        water = "550ml"
//    }
//
//    override fun boil() {
//        println("must have boil 4 minute because of Thick Noodle")
//    }
//}
//
//class JPNuguri : Ramen() {
//    init {
//        noodle = "JP style Thick Noodle"
//        sauce = "JP style Nuguri Sauce"
//        water = "530ml"
//    }
//
//    override fun boil() {
//        println("must have boil 4 minute because of Thick Noodle")
//    }
//}
//
//enum class RamenType {
//    NUGURI, SINRAMEN
//}
//
//
//abstract class RamenStore {
//    lateinit var ramen: Ramen
//    fun orderRamen(ramenType: RamenType) {
//        println("order Ramen")
//        ramen = createRamen(ramenType)
//        ramen.prepare()
//        ramen.boil()
//        ramen.putSauce()
//        ramen.putNoodle()
//    }
//
//    abstract fun createRamen(ramenType: RamenType): Ramen
//}
//
//class KRRamenStore : RamenStore() {
//    override fun createRamen(ramenType: RamenType): Ramen {
//        when (ramenType) {
//            RamenType.NUGURI -> {
//                return KRNuguri()
//            }
//            RamenType.SINRAMEN -> {
//                return KRSinRamen()
//            }
//        }
//    }
//}
//
//class JPRamneStore : RamenStore() {
//    override fun createRamen(ramenType: RamenType): Ramen {
//        when (ramenType) {
//            RamenType.NUGURI -> {
//                return JPNuguri()
//            }
//            RamenType.SINRAMEN -> {
//                return JPSinRamen()
//            }
//        }
//    }
//}