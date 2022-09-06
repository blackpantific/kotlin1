import kotlin.properties.Delegates
import kotlin.reflect.KProperty

fun main(args: Array<String>) {

//    val b: Base = BaseImpl(10)
//    b.print()

    var ex = Example()
    var res = ex.p
    ex.p = "qwerty"

    var c = 4

    val user = User()
    user.name = "first"
    user.name = "second"
}

class Example {
    var p: String by Delegate()
}

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}

//мои попытки создать метод, возвращающий значение(метод ниже)
val lazyValue: String by getstr<String>()

private operator fun String.getValue(nothing: Nothing?, property: KProperty<*>): String {
    return "gfgf"
}

//в интерфейсе Lazy уже реализован метод getValue, который всегда требуется при делегировании свойств
fun <T> getstr(): String /*Lazy<String>*/{
    return "12345678"
}

//инвокаем метод при каждом присваивании новых значений

class User {
    var name: String by Delegates.observable("<no name>") {
            prop, old, new ->
        println("$old -> $new")
    }
}

class Resource

class Owner {
    var varResource: Resource by ResourceDelegate()
}

class ResourceDelegate(private var resource: Resource = Resource()) {
    operator fun getValue(thisRef: Owner, property: KProperty<*>): Resource {
        return resource
    }
    operator fun setValue(thisRef: Owner, property: KProperty<*>, value: Any?) {
        if (value is Resource) {
            resource = value
        }
    }
}