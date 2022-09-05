//указываем что файл App.kt находится внутри пакета myNew, чтобы
// иметь возможность обращаться к классам объявленным внутри этого файла

package myNew
import javax.sql.rowset.Predicate

fun main(args: Array<String>) {

    var vase = Base()
}

//расширение для nullable-типов
fun Any?.toString(): String {
    if (this == null) return "null"
    // после проверки на null, `this` автоматически приводится к не-null типу,
    // поэтому toString() обращается (ориг.: resolves) к функции-члену класса Any
    return this.toString()
}

//расширение для объекта-компаньона
class MyClass {
    companion object { } // называется "Companion"
}

fun MyClass.Companion.printCompanion() { println("companion") }

open class Base{
    open fun outputSomeText(){
        println("Hello world")
    }
}

class Inherited() : Base(){

    //расширение, объявленное внутри класса можно вызывать только внутри класса
    fun Base.extensionFunc(){
        this.outputSomeText()
        //this с квалификатором
        this@Inherited.outputSomeText()
        println("Invocation from inherited class")
    }

    override fun outputSomeText(){
        println("ITMO is the best")
    }

    constructor(val1: Int) : this() {
        //
        var b = Base().extensionFunc()
    }

}