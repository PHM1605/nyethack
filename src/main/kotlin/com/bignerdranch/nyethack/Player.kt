package com.bignerdranch.nyethack

class Weapon (
    val name:String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Weapon

        return name == other.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}

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

<<<<<<< HEAD
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
=======
    val prophecy by lazy {
        narrate("$name embarks on an arduous quest to locate a fortune teller")
        Thread.sleep(3000)
        narrate("The fortune teller bestows a prophecy upon $name")
        "An intrepid hero from $hometown shall some day " + listOf(
            "form an unlikely bond between two warring factions",
            "take possession of an otherworldly blade",
            "bring the gift of creation back to the world",
            "best the world-eater").random()
>>>>>>> 7b5787cbb076c460aedede2b42d4ff9fc0d4ed98
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

    fun prophesize() {
        narrate("$name thinks about their future")
        narrate("A fortune teller told Madrigal, \"$prophecy\"")
    }

}