package com.bignerdranch.nyethack

object Game {
    private var currentRoom: Room = TownSquare()
    private var currentPosition = Coordinate(0, 0)

    init {
        println(currentPosition)
        narrate("Welcome, adventurer")
        val mortality = if (player.isImmortal) "an immortal" else "a mortal"
        narrate("${player.name}, $mortality, has ${player.healthPoints} health points")
    }

    private class GameInput(arg: String?) {
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1) { "" }
        fun processCommand() = when (command.lowercase()) {
            else -> narrate("I'm not sure what you're trying to do")
        }
    }

    fun play() {
        while(true) {
            narrate("${player.name} of ${player.hometown}, ${player.title}, is in ${currentRoom.description()}")
            currentRoom.enterRoom()
            print("> Enter your command: ")
            GameInput(readLine()).processCommand()
        }
    }
}