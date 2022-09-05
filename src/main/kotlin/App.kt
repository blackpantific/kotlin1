fun main(args: Array<String>) {

    val ints: Array<Int> = arrayOf(1, 2, 3)
    val any = Array<Any>(3) { "" }
    //невозможно сделать из-за инвариантности
    copy(ints, any)
}

//ВАРИАТИВНОСТЬ НА МЕСТЕ ОБЪЯВЛЕНИЯ
interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}

fun demo(x: Comparable<Number>) {
    x.compareTo(1.0) // 1.0 имеет тип Double, расширяющий Number
    // Таким образом, мы можем присвоить значение x переменной типа Comparable<Double>
    val y: Comparable<Double> = x // OK!
}

fun copy(from: Array<Any>, to: Array<Any>) {
    assert(from.size == to.size)
    for (i in from.indices)
        to[i] = from[i]
}

//ВАРИАТИВНОСТЬ НА МЕСТЕ ИСПОЛЬЗОВАНИЯ

//Произошедшее здесь называется проекция типов:
//мы сказали, что from — не просто массив, а ограниченный
//(спроецированный): мы можем вызывать только те методы,
//которые возвращают параметризованный тип T, что в этом случае
//означает, что мы можем вызывать только get(). Таков наш подход к вариативности
//на месте использования, и он соответствует Array<? extends Object> из Java, но в более простом виде.
fun copy1(from: Array<out Any>, to: Array<Any>) { }