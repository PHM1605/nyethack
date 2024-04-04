package com.bignerdranch.nyethack

class Villager(val name:String, val hometown:String) {
    val personality:String
    val race = "Dwarf"
    var age = 50
        private set

    init {
        println("initializing villager")
        personality = "Outgoing"
    }

    constructor(name:String) :this(name, "Bavaria") {
        age = 99;
    }
}