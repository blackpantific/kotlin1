
fun main(args: Array<String>) {

}

interface A {
    fun foo() { print("A") }
}
interface B {
    fun foo() { print("B") }
}

class C : A, B {

    //интересный пример с реализацией интерфейсов с одинаковыми по имени методами
    //в шарпе мы бы не могли создать один метод, переопределяющий 2 метода интерфейсов
    //там были бы 2 метода для каждого интерфейса отдельные
    override fun foo() {
        //super<A>.foo()
        //super<B>.foo()
        print("foo")
    }
}