package com.bignerdranch.nyethack

open class Room(val name:String) {
    protected open val status = "Calm"
    open val lootBox: LootBox<Loot> = LootBox.random()
    open fun description() = "$name (Currently: $status)"
    open fun enterRoom() {
        narrate("There is nothing to do here")
    }
}

open class MonsterRoom(
    name: String,
    var monster: Monster? = Goblin()
): Room(name) {
    override fun description() = super.description() + " (Creature: ${monster?.description ?: "None"})"
    override fun enterRoom() {
        if (monster == null) {
            super.enterRoom()
        } else {
            narrate("Danger is lurking in this room")
        }
    }
}

inline fun MonsterRoom.configurePitGoblin(
    block: MonsterRoom.(Goblin) -> Goblin
): MonsterRoom {
    val goblin = block(Goblin("Pit Goblin", description="An Evil Pit Goblin"))
    monster = goblin
    return this
}