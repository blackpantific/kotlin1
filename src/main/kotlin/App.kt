fun main(args: Array<String>) {

    var func = ::additionFunction
    var func1: (Int, Int) -> Int = ::additionFunction
    //workWithNums(10, 10, ::additionFunction)
    //workWithNums(10, 10, func)

    //var beverage = readLine()
    //var res = beverage?.capitalize()

    var string = generationFunc()
    var op = string?.let {
        "$it Hello world!"
    }

    //выбросить умышленно исключение
    //var nonNull = op!!.capitalize()

    var str = op ?: "Hello world!"
    
}

fun generationFunc(): String? {

    var num = Math.random()
    var res = if (num > 0.5) {
        null
    } else {
        "Number is $num"
    }
    return res
}

fun additionFunction(a: Int, b: Int): Int {
    return a + b
}

fun workWithNums(firstOperand: Int, secondOperand: Int, mathFunc: (Int, Int) -> Int) {
    val result = mathFunc(firstOperand, secondOperand)
    println("The result of operation is $result")
}