fun main(args: Array<String>) {

    var a: Generic<A> = Generic<A>(A("1"))
    a.item = A("2")
    var aRes = a.get()
    a.set(A("3"))
    var s = a.item

    var a1: Generic<in A> = Generic<A>(A("1"))
    a1.item = A("2")
    a1.set(A("1"))
    var sm = a1.get()//вернет Any вместо стринги
    var s1 = a1.item//снова Any
    //полный пиздец

    myFun(a)

//    val ints: Array<A> = arrayOf(A("1"))
//    val any: Array<Base> = arrayOf(Base())
//    copy(ints, any)


    //короче на данном этапе я могу сделать следующие выводы
    //out позволяет записать данные в дженерик класс, но поле, в котором будут храниться
    //данные не доступно для изменения, из него можно только получить информацию
    //in позволяет записать данные в класс, но получить их мы никак не можем, потому что поле
    //в котором они хранятся имеет модификатор private
    //то есть out T это тип T и все его наследники, а in T это тип T и все его родители

}

fun copy(from: Array<Base>, to: Array<Base>) {
    assert(from.size == to.size)
    for (i in from.indices) {
        to[i] = from[i]
    }
}

fun myFun(someVal: Generic<out Base>){
    var s = someVal.item
    someVal.item = A("1")
}

fun fill(dest: Generic<in String>, value: String){

    dest.item = value

    //вернет значение, но не стринг, как ожидалось, а тип Any() ахуеть просто
    var v = dest.item
}

public class Generic<T>(_item: T) {

    var item: T = _item

    fun get() : T{
        return item
    }

    fun set(value: T){
        item = value
    }
}

public open class Base {
    var baseProperty = "Base property string"
}

public class A(_name: String) : Base() {

    public var name: String = _name
}

public class B(_int: Int) : Base() {

    public var number: Int = _int
}
