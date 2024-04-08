package com.bignerdranch.nyethack

lateinit var player:Player

fun main() {
    narrate("Welcome to Nyethack!")
    val playerName = promptHeroName()
    player = Player(playerName)
    //changeNarratorMood()

    val lootBoxOne: LootBox<Fedora> = LootBox(Fedora("a generic-looking fedora", 15))
    val lootBoxTwo: LootBox<Gemstones> = LootBox(Gemstones(150))
    repeat(2) {
        narrate(
            lootBoxOne.takeLoot()?.let {
                "The hero retrieves ${it.name} from the box"
            } ?: "The box is empty"
        )
    }
    Game.play()
}

private fun makeYellow(message:String) = "\u001b[33;1m$message\u001b[0m"

private fun promptHeroName(): String {
    narrate("A hero enters the town of Kronstadt. What is their name?", ::makeYellow)
    /*
    val input = readLine()
    require(input != null && input.isNotEmpty()) {
        "The hero must have a name."
    }
    return input
    */
    println("Madrigal")
    return "Madrigal"
}