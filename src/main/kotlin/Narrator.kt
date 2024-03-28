val narrationModifier =  {
    message:String ->
        val numExclamationPoints = 3
        message.uppercase() + "!".repeat(numExclamationPoints)
}

val loudNarration: (String, String) -> String = {
    message, tone ->
        when(tone) {
            "excited" -> {
                val numExclamationPoints = 3
                message.uppercase() + "!".repeat(numExclamationPoints)
            }
            "sneaky" -> {
                "$message. The narrator has just blown Madrigal's cover.".uppercase()
            }
            else -> message.uppercase()
        }
}

fun narrate(message: String) {
    println(narrationModifier(message))
//    println(loudNarration(message, "sneaky"))
}