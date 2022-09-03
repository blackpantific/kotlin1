import java.util.Base64

fun main(args: Array<String>) {


    var a: Generic<in A> = Generic(A("1"))
    var b: Generic<Base> = Generic(B(1))

    //b = a //нельзя присвоить b = a если 

    a = b
    var re = a.item//на этом этапе в a.item лежит экземпляр класса B
    a.item = Base()//а теперь здесь лежит Base класс, что вообще полный трындец, ломающий
        //всю ко- и контрвариантность и всю логику, которую я читал в учебнике


    if(b.item is A){
        var c = 5
        b.item = A("2")//выполняем присваивание несмотря на то, что типа переменой
        // указан с параметром типа out
        //b.item = B(1)// Type mismatch. Required: A Found: B
    }

    //короче на данном этапе я могу сделать следующие выводы
    //out позволяет записать данные в дженерик класс, но поле, в котором будут храниться
    //данные не доступно для изменения, из него можно только получить информацию
    //in позволяет записать данные в класс, но получить их мы никак не можем, потому что поле
    //в котором они хранятся имеет модификатор private
    //то есть out T это тип T и все его наследники, а in T это тип T и все его родители
}


//к примеру Generic<B> можем присвоить Generic<Base>, но изменить
public class Generic<T>(_item: T) {
    //можем только инициализировать переменную единожды и потом читать из нее
    var item: T = _item
}

//public class Generic<T>(_item: T){
//    var item: T = _item
//}

public open class Base {
    var baseProperty = "Base property string"
}

public class A(_name: String) : Base() {

    public var name: String = _name
}

public class B(_int: Int) : Base() {

    public var number: Int = _int
}
