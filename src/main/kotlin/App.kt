import javax.sql.rowset.Predicate

fun main(args: Array<String>) {

    var myAction: Action<Int> = Action { val1, val2 ->
        println(val1 + val2)
    }

    myAction.function(5,7)

    var predicate = object : Predicate1<Int>{
        override fun compare(val1: Int, val2: Int): Boolean {
            return val1 > val2
        }
    }

    var compareRes = predicate.compare(10, 18)

    var func = Func<Int> { param1, param2 ->
         param1 + param2
    }

    func.invokeFun(5, 8)

}

//обычный интерфейс
interface MyInterface{
    fun Go()
}

fun interface Action<T>{
    fun function(val1: T, val2: T) : Unit
}

fun interface Predicate1<T>{
    fun compare(val1: T, val2: T) : Boolean
}

fun interface Func<T>{
    fun invokeFun(param1: T, param2: T) : T
}