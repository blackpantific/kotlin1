fun main(args: Array<String>) {

}

//обязателен 1 параметр в ф-ции, который является аргументом справа от функции, а
//объект у которого вызывается функция, находится слева, то есть
// 5 multipleVal 7 это 5.multipleVal(7)
public infix fun Int.multipleVal(x: Int): Int{
    return this * x
}

class MyStringCollection {
    infix fun add(s: String) { /*...*/ }

    fun build() {
        this add "abc" // Верно
        add("abc")     // Верно
        //add "abc"    // Не верно: получатель должен быть указан
    }
}