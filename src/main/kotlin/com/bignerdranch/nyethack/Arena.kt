package com.bignerdranch.nyethack

class Arena {
    var isArenaOpen = false
    lateinit var opponentName: String

    fun prepareArena() {
        isArenaOpen = true
        opponentName = getWillingCombatants().random()
    }

    private fun getWillingCombatants() =
        listOf("Cornelius", "Cheryl", "Ralph", "Deborah")
}