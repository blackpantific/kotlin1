fun main(args: Array<String>) {

    var b: A.B = A().B()
    5.foo()
}

class A { // неявная метка @A
    var c = 5
    inner class B { // неявная метка @B
        fun Int.foo() { // неявная метка @foo
            val a = this@A // this из A
            val b = this@B // this из B

            val c = this // объект-приёмник функции foo(), типа Int
            val c1 = this@foo // объект-приёмник функции foo(), типа Int

            val funLit = lambda@ fun String.() {
                val d = this // объект-приёмник литерала funLit
            }

            val funLit2 = { s: String ->
                // объект-приёмник функции foo(), т.к. замыкание лямбды не имеет объекта-приёмника
                val d1 = this
            }
        }
    }
}