
fun main(args: Array<String>) {

    var func = ::additionFunction
    var func1: (Int, Int) -> Int = ::additionFunction
    //workWithNums(10, 10, ::additionFunction)
    //workWithNums(10, 10, func)
}

fun additionFunction(a: Int, b: Int): Int{
    return a + b
}

fun workWithNums(firstOperand: Int, secondOperand: Int, mathFunc: (Int, Int) -> Int) {
    val result = mathFunc(firstOperand, secondOperand)
    println("The result of operation is $result")
}