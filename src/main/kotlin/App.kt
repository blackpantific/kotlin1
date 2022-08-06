import java.util.Base64

fun main(args: Array<String>) {

//    var a: Generic<A> = Generic(A("1"))
//    var b: Generic<Base> = Generic(B(1))
//
//    var c: Generic<Base> = b
//
//    var res = c.item as A
//
//    var a1 = 5

    var a: Generic<A> = Generic(A("1"))
    var b: Generic<Base> = Generic(B(1))

    b = a

    var fedoraBarrel: Barrel<Fedora> =
        Barrel(Fedora("a generic-looking fedora", 15))
    var lootBarrel: Barrel<Loot> = Barrel(Loot(10))

    fedoraBarrel = lootBarrel

    //короче на данном этапе я могу сделать следующие выводы
    //out позволяет записать данные в дженерик класс, но поле, в котором будут храниться
    //данные не доступно для изменения, из него можно только получить информацию
    //in позволяет записать данные в класс, но получить их мы никак не можем, потому что поле
    //в котором они хранятся имеет модификатор private
    //то есть out T это тип T и все его наследники, а in T это тип T и все его родители

}



//к примеру Generic<B> можем присвоить Generic<Base>, но изменить
public class Generic<out T>(_item: T){//можем только инициализировать переменную единожды и потом читать из нее
    val item: T = _item
}

//public class Generic<T>(_item: T){
//    var item: T = _item
//}

public open class Base{
    var baseProperty = "Base property string"
}
public class A(_name: String) : Base() {

    public var name: String = _name
}

public class B(_int: Int) : Base(){

    public var number: Int = _int
}

class Barrel<in T>(private var item: T)

open class Loot(val value: Int)

class Fedora(val name: String, value: Int) : Loot(value)

class Coin(value: Int) : Loot(value)
