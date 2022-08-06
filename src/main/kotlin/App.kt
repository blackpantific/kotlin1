
fun main(args: Array<String>) {

//    println("fdfdf".addEnthusiasm(5))

    "Madrigal has left the building".easyPrint().addEnthusiasm().easyPrint()
    42.easyPrint()
    "Hello world".numVowels

    val nullableString: String? = null
    nullableString printWithDefault "Default string"

    var res = "Hello world some string".doSmthWithString {
        //работать не будет потому что эти ф-ции возвращают новую стрингу
        toUpperCase()
        reversed()
    }
}

//если создать расширение для какого-то класса, то оно будет работать и на наследниках
//fun Any.easyPrint() = println(this)

fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)

//обобщенная функция-расширение
fun <T> T.easyPrint(): T {
    println(this)
    return this
}

//свойства расширения
val String.numVowels
    get() = count { "aeiouy".contains(it) }

//или же так
fun String.numVowels(): Int = count { contains(it) }

//Ключевое слово infix доступно для расширений и функций
//класса с одним аргументом и позволяет использовать более
//ясный синтаксис вызова функции. Если функция объявлена с infix,
//вы можете отбросить точку между объектом- приемником и вызовом
//функции, а также скобки вокруг аргумента.

infix fun String?.printWithDefault(default: String) = print(this ?: default)

public fun String.doSmthWithString(func: String.() -> String): String{
    var res = this + func.invoke(this)
    return res
}
