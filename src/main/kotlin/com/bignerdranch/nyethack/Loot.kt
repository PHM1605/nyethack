package com.bignerdranch.nyethack

class LootBox<out T: Loot>(val contents: T) {
    var isOpen = false
        private set
    fun takeLoot(): T? {
        return contents.takeIf { !isOpen }.also{ isOpen = true }
    }
}

abstract class Loot {
    abstract val name: String
}

interface Sellable {
    val value: Int
}

class Fedora(
    override val name: String,
    override val value: Int
): Loot(), Sellable

class Gemstones(
    override val value : Int
): Loot(), Sellable {
    override val name = "sack of gemstones worth $value gold"
}

class Key(
    override val name: String
): Loot()

class DropOffBox<T> where T:Loot, T:Sellable {
    fun sellLoot(sellableLoot:T):Int {
        return (sellableLoot.value * 0.7).toInt()
    }
}