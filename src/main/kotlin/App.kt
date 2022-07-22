
// константа времени компиляции, к моменту запуска main-функции она уже существует
const val SOME_VAL = 5//это значение никогда не изменяется

fun main(args: Array<String>) {
    println("Hello world!")
    var a = 1
    var s = 2
    var res = if(a == 1){
        var a = 1
        var b = 3
        s
    }else{
        s += 6
        s
    }

    //тут используется оператор интервала .. для проверки значения
    if ( res in 0..100){
        println("The value is ok")
    }

    //конструкция when, является аналогом switch case в других языках
    var someCar = "Bugatti"
    var car = when (someCar){
        "Pagani" -> println("Ronaldo buys Pagani")
        "Camaro" -> println("Maguire buys Camaro")
        else -> println("No news about byuings")
    }

    println("$SOME_VAL")

    castFireball()

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
