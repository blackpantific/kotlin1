import kotlin.reflect.KProperty

fun main() {

}

class MyClass{

    var p = lazy {
        "hello world"
    }

    var db by getDouble()

    fun getSomeData(): Unit{
        var c = 5
        var e = 7
        println(e + c)

    }
}

private operator fun Double.setValue(myClass: MyClass, property: KProperty<*>, any: Any) {
    myClass.db = 100.0
}

private operator fun Double.getValue(myClass: MyClass, property: KProperty<*>): Any {
    return 10.0
}


public fun getDouble(): Double{
    var c = Math.PI
    return c
}