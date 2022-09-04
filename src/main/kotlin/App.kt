import java.util.Base64
import javax.naming.Context
import javax.swing.text.AttributeSet
import javax.swing.text.View

//КЛАССЫ


fun main(args: Array<String>) {

    println("Построение класса Derived(\"hello\", \"world\")")
    Derived("hello", "world")

}

//Если у конструктора есть аннотации или
//модификаторы видимости, ключевое слово constructor
//обязательно, и модификаторы используются перед ним.
class Customer @Inject constructor(name: String) {
    /*...*/
}

annotation class Inject

//пример с наследованием и вызовом функции с одинаковым именем из родительского класса

open class Base {
    var someString = "Hello world"
    var myIntVal: Int

    open fun getInfo() {
        println("Hello world")
    }

    constructor(someInt: Int) {
        myIntVal = someInt
    }
}

class Inherited : Base {

    //может быть первичным конструктором, но в данном примере явно использую слово super для
    //вызова родительского конструктора
    constructor(someInt: Int) : super(someInt) {

    }

    fun doSmth() {
        super.getInfo()
    }

    override fun getInfo() {
        println("Hello world 111")
    }
}

interface Shape {
    val vertexCount: Int
}

//keyword override может использоваться в главном конструкторе
class Rectangle(override val vertexCount: Int = 4) : Shape // Всегда имеет 4 вершины

//мы можем сменить val на var, но не наоборот
class Polygon : Shape {
    override var vertexCount: Int = 0  // Может быть установлено любое количество
}

//хороший пример для отображения порядка инициализации свойств и всего остального у родителя
//и дочернего классов. Запускать из main-функции!

open class Base1(val name: String) {

    init {
        //вызывается 2м
        println("Инициализация класса Base")
    }

    //вызывается 3м
    open val size: Int =
        name.length.also { println("Инициализация свойства size в класса Base: $it") }
}

class Derived(
    name: String,
    val lastName: String,
) : Base1(name.replaceFirstChar { it.uppercase() }
        //вызывается в первую очередь
    .also { println("Аргументы, переданные в конструктор класса Base: $it") }) {

    init {
        //вызывается 4м
        println("Инициализация класса Derived")
    }

    //вызывается 5м
    override val size: Int =
        (super.size + lastName.length).also { println("Инициализация свойства size в классе Derived: $it") }
}

//ОСОБЕННОСТЬ С GET

class Rectangle1(val width: Int, val height: Int) {
    val area: Int
        get() = this.width * this.height

    // если в сеттере мы не используем ключ слово field, то инициализировать свойство
    //каким-то значением не обязательно
    //КСТАТИ field является тем самым полем в языке котлин, т.е. в данном случае
    //backing field
    var stringRepresentation: String
        get() = this.toString()
        set(value) {
            //setDataFromString(value) // парсит строку и устанавливает
            // значения для других свойств
        }
}
