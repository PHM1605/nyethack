import java.io.File

fun main() {
    val fileContents = File("myfile.txt").takeIf{ it.exists() }?.readText()
    println(fileContents)
}

