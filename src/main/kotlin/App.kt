import kotlin.properties.Delegates
import kotlin.reflect.KProperty

//ПСЕВДОНИМЫ ТИПОВ

typealias IntSet = Set<Int>

typealias FileTable<K> = MutableMap<K, MutableList<String>>

typealias MyHandler = (Int, String, Any) -> Unit

typealias Predicate<T> = (T) -> Boolean

class A {
    inner class Inner
}
class B {
    inner class Inner
}

typealias AInner = A.Inner
typealias BInner = B.Inner

fun main(args: Array<String>) {


}