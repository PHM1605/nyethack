package com.bignerdranch.nyethack

class Weapon (
    val name:String
)

class Player(
    initialName:String,
    val hometown: String = "Neversummer",
    var healthPoints: Int,
    val isImmortal: Boolean,
    val playerClass: String = "archer"
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

    val inventory: List<String>

    init {
        require(healthPoints > 0) { "healthPoints must be greater than zero" }
        require(name.isNotBlank()) { "Player must have a name" }
        val baseInventory = listOf("waterskin", "torches")

        val classInventory = when(playerClass) {
            "archer" -> listOf("arrows")
            "wizard" -> listOf("arcane staff", "spellbook")
            "rogue" -> listOf("lockpicks", "crowbar")
            else -> emptyList()
        }
        inventory = baseInventory + classInventory
    }

    constructor(name:String) : this (
        initialName = name,
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