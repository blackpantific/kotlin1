fun main(args: Array<String>) {

//    val b: Base = BaseImpl(10)
//    b.print()

    var d = Derived(BaseImpl(5)).base.print()

}

interface Base {
    fun print()
}

class BaseImpl(val x: Int) : Base {
    override fun print() { print(x) }
}

class Derived(private val b: Base) : Base by b  {
    var base = b

    constructor(val1: Int, b: Base) : this(b)  {
        base.print()
    }
}

interface Human{
    fun getUserInfo()
}

open class A(var name: String, var age: Int) : Human{
    override fun getUserInfo(){
        println("User name is $name and age is $age")
    }
}

open class B(name: String, age: Int) : A(name, age){

    var position: String = ""
    var car: String? = null
}

class C(private val human: Human, name: String, age: Int) : B(name, age), Human by human{
    override fun getUserInfo() {
        human.getUserInfo()
    }

}