import com.bignerdranch.nyethack.Player
import com.bignerdranch.nyethack.Room

fun printIsSourceOfBlessings(any:Any) {
    val isSourceOfBlessings:Boolean = if (any is Player) {
        any.title == "The Blessed"
    } else if (any is Room) {
        any.name == "The Fount of Blessings"
    } else {
        false
    }
    println("$any is a source of blessings: $isSourceOfBlessings")
}

fun main() {

}

