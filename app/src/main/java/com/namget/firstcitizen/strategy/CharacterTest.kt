package com.namget.firstcitizen.strategy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity


class CharacterTest : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main()
    }

    private fun main() {
        val warrior = Warrior()
        warrior.weaponBehavior = SwordWeapon()
        warrior.move()
        warrior.attack()


    }
}

abstract class Character {
    open lateinit var weaponBehavior: WeaponBehavior
    fun move() = print("적을 향해 이동중")
    fun attack() = print(weaponBehavior.attackWeapon())
}

class Warrior : Character() {

}

class Anchor : Character() {

}

class Magician : Character() {

}

class Cleric : Character() {

}

interface WeaponBehavior {
    fun getWeaponName(): String
    fun attackWeapon()
}

//과연 특정 직업에 한정되게 무기를 끼게하려면 어떻게 하는것이 좋을까... 고민 ㄱㄱ
class Sword() {

}

class SwordWeapon : WeaponBehavior {
    override fun getWeaponName(): String = "검"
    override fun attackWeapon() = println("${getWeaponName()}을 꼈다.")
}

class LongSwordWeapon : WeaponBehavior {
    override fun getWeaponName(): String = "롱소드"
    override fun attackWeapon() = println("${getWeaponName()}을 꼈다.")
}

class CaneWeapon : WeaponBehavior {
    override fun getWeaponName(): String = "지팡이"
    override fun attackWeapon() = println("${getWeaponName()}를 꼈다.")
}

class BowWeapon : WeaponBehavior {
    override fun getWeaponName(): String = "활"
    override fun attackWeapon() = println("${getWeaponName()}을 꼈다.")
}

class CrossWeapon : WeaponBehavior {
    override fun getWeaponName(): String = "십자가"
    override fun attackWeapon() = println("${getWeaponName()}를 꼈다.")
}
