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
    override var healthPoints: Int,
    val isImmortal: Boolean,
    val playerClass: String = "archer"
): Fightable {
    override var name = initialName
        get() = field.replaceFirstChar { it.uppercase() }
        private set(value) {
            field = value.trim()
        }
    override val diceCount = 3
    override val diceSides = 4

    override fun takeDamage(damage: Int) {
        if (!isImmortal) {
            healthPoints -= damage
        }
    }

    val title:String
        get() = when {
            name.all { it.isDigit() } -> "The Identifiable"
            name.none { it.isLetter() } -> "The Witness Protection Member"
            name.numVowels > 4 -> "The Master of Vowels"
            else -> "The Renowned Hero"
        }

    val prophecy by lazy {
        narrate("$name embarks on an arduous quest to locate a fortune teller")
        Thread.sleep(3000)
        narrate("The fortune teller bestows a prophecy upon $name")
        "An intrepid hero from $hometown shall some day " + listOf(
            "form an unlikely bond between two warring factions",
            "take possession of an otherworldly blade",
            "bring the gift of creation back to the world",
            "best the world-eater").random()
    }

    val inventory = mutableListOf<Loot>()
    var gold = 0

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