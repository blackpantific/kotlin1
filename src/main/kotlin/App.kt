fun main(args: Array<String>) {

}

fun <T> getBiggest(a: T, b: T): T where T: Comparable<T>,
                                        T: Number {
    return if(a > b) a
    else b
}