fun main(args: Array<String>) {

    var cl: Outer.Nested = Outer.Nested()
    cl.foo()
}

//просто вложенный класс, аналог статически вложенных классов в джаве
class Outer {
    private val bar: Int = 1
    public class Nested {
        fun foo() = 2
    }
}

class Outer1 {
    private val bar: Int = 1
    inner class Inner {
        //обращение к полю из внешнего класса
        fun foo() = this@Outer1.bar
    }
}