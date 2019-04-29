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
    fun move() = println("적을 향해 이동중")
    fun attack() = println(weaponBehavior.attackWeapon())
    abstract fun display()
}

class Warrior : Character() {
    override fun display() {
    }
}

class Anchor : Character() {
    override fun display() {
    }
}

class Magician : Character() {
    override fun display() {
    }
}

class Cleric : Character() {
    override fun display() {
    }
}

interface WeaponBehavior {
    fun getWeaponName(): String
    fun attackWeapon()
}

class SwordWeapon : WeaponBehavior {
    override fun getWeaponName(): String = "검"
    override fun attackWeapon() = println("${getWeaponName()}으로 공격.")
}

class LongSwordWeapon : WeaponBehavior {
    override fun getWeaponName(): String = "롱소드"
    override fun attackWeapon() = println("${getWeaponName()}로 공격.")
}

class CaneWeapon : WeaponBehavior {
    override fun getWeaponName(): String = "지팡이"
    override fun attackWeapon() = println("${getWeaponName()}로 공격.")
}

class BowWeapon : WeaponBehavior {
    override fun getWeaponName(): String = "활"
    override fun attackWeapon() = println("${getWeaponName()}로 공격.")
}

class CrossWeapon : WeaponBehavior {
    override fun getWeaponName(): String = "십자가"
    override fun attackWeapon() = println("${getWeaponName()}로 공격.")
}
