import java.io.File

//listOf создает список только для чтения
//val patronList = listOf("Eli", "Mordoc", "Sophie")
//mutableListOf создает изменяемый список
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")

fun main(args: Array<String>) {

    var value = patronList[0]
    var res = patronList.getOrElse(4) { "some string" }

    if (patronList.contains("Eli")) {
        println("The tavern master says: Eli's in the back playing cards.")
    } else {
        println("The tavern master says: Eli isn't here.")
    }

    patronList.remove("Eli")
    patronList.add("Alex")
    println(patronList)

    patronList.forEachIndexed { index, patron ->
        println("Good evening, $patron - you're #${index + 1} in line.")
    }

    //или же как альтернатива
    for ((index, i) in patronList.withIndex()) {

    }

    val patronGold = mutableMapOf("Eli" to 10.5, "Mordoc" to 8.0, "Sophie" to 5.5)

    patronGold.keys.toList().forEach {
        println(it)
    }
    patronGold["Tom"] = 10.6


}