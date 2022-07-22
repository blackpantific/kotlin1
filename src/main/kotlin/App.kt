
fun main(args: Array<String>) {

    //вызов с именованными параметрами
    funWithOneExpression(arg2 = 5, arg1 = 7)

    //функ крешает при вызове
    //exampleFunWithNothingType()

    //объявление анонимной функции без параметров
    val greetingFunction: () -> String = {
        val currentYear = 2018
        //анонимная функция позволяет не использовать оператор return
        "Welcome to SimVillage, Mayor! (copyright $currentYear)"
    }
    //можно инвокнуть функцию так
    var str = greetingFunction.invoke()
    //или так
    var stri = greetingFunction()

    //анонимная функция с использованием ключевого слова it, которое может употребляться вместо первого параметра
    val greetingFunction1: (String) -> String = {
        val currentYear = 2018
        "Welcome to SimVillage, $it! (copyright $currentYear)"
    }
    println(greetingFunction1("Guyal"))


    //анон функция с несколькими параметрами
    val anonymousFuncWithParameters: (String, Double) -> String = { someParam, doubleParam ->
        val c = 5
        val e = 3
        someParam + c.toString() + e.toString() + doubleParam.toString()
    }

    println({
        val year = 2018
        "Welcome to SimVillage, Mayor! (copyright $year)"
    })

    var anonFunc = { param1: Int, param2: Int ->
        var someVar = param1 + 1
        var someNewVar = param2 + 1
    }
}

//по-умолчанию у всех фунций доступ public при объявлении
private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean):
        String {
    val healthStatus = when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) {
            "has some minor wounds, but is healing quite quickly!"
        } else {
            "has some minor wounds."
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }
    return healthStatus
}

//аргумент по-умолчанию
private fun castFireball(numFireballs: Int = 2) {
    println("A glass of Fireball springs into existence. (x$numFireballs)")
}

//функция с одним выражением
fun funWithOneExpression(arg1: Int, arg2: Int) : Unit = println("Hello world!")

//использование типа Nothing
fun exampleFunWithNothingType() : Nothing {
    var m = 4
    var res = "res"
    println("Hello, this function will crash...")
    //TODO()
    throw NotImplementedError()
}