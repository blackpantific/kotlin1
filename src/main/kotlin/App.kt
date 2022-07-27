
fun main(args: Array<String>) {

    var res = funcWithFuncInParam(
        value = 5,
        someString = "String",
        function = { param1: Int, param2: Double ->
            param1.toString() + param2.toString()
        },
    )

    //Сокращенный синтаксис можно использовать, только когда лямбда передается в функцию как последний аргумент.
    "Mississippi".count({ it == 's' })

    "Mississippi".count { it == 's' }

    funcWithFuncInParam(5, { someInt, someDouble ->
        someInt.toString() + someDouble.toString()
    }, "5")

    runSimulation("Guyal") { playerName, numBuildings ->
        val currentYear = 2018
        println("Adding $numBuildings houses")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }

}

inline fun funcWithFuncInParam(value: Int, function: (Int, Double) -> String, someString: String) : String{
    return value.toString() + function.invoke(5, 7.0)
}

inline fun runSimulation(playerName: String,
                         greetingFunction: (String, Int) -> String) {
    val numBuildings = (1..3).shuffled().last() // Случайно выберет 1, 2 или 3
    println(greetingFunction(playerName, numBuildings))
}