package com.bignerdranch.nyethack

class Weapon (
    val name:String
)

class Player(
    initialName:String,
    val hometown: String,
    var healthPoints: Int,
    val isImmortal: Boolean
) {
    var name = initialName
        get() = field.replaceFirstChar { it.uppercase() }
        private set(value) {
            field = value.trim()
        }

    val title:String
        get() = when {
            name.all { it.isDigit() } -> "The Identifiable"
            name.none { it.isLetter() } -> "The Witness Protection Member"
            name.count { it.lowercase() in "aeiou" } > 4 -> "The Master of Vowels"
            else -> "The Renowned Hero"
        }

    constructor(name:String, hometown:String) : this (
        initialName = name,
        hometown = hometown,
        healthPoints = 100,
        isImmortal = false
    ) {
        if (name.equals("Jason", ignoreCase = true)) {
            healthPoints = 500
        }
    }

    var weapon: Weapon? = Weapon("Mjolnir")

    fun castFireball(numFireballs:Int = 2) {
        narrate("A glass of Fireball springs into existence (x$numFireballs)")
    }

    fun changeName(newName:String) {
        narrate("$name legally changes their name to $newName")
        name = newName
    }

    fun printWeaponName() {
        weapon?.let {
            println(it.name)
        }
    }
}