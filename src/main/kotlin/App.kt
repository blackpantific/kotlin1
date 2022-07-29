import java.io.File

fun main(args: Array<String>) {

    var mc = MyClass()
    //функция apply позволяет не использовать имя переменной при вызове методов или
    //записи информаци в поля
    // как параметр в лямбду передается экземпляр класса, но лямбда ничего не возвращает
    mc.apply {
        name = "Igor"
        age = 22
    }

    //схоже с apply, но лямбда может возвращать значение
    val menuFile = File("menu-file.txt")
    val servesDragonsBreath = menuFile.run {
        readText().contains("Dragon's Breath")
    }

    "Madrigal".run(::nameIsLong) // Ложь
    "Polarcubis, Supreme Master of NyetHack".run(::nameIsLong) // Истина

    //скорее всего синтаксист типа Т.() подразумевает синтаксис, в котором лямбда
    //пишется без аргументов
    mc.run(::someCheck)

    val status = run {
        if (mc.age == 100) "perfect health" else "has injuries"
    }

    //похоже на let, но ничего не возвращает
    "some string"
        .also { println(it.length) }
        .also { println("$it hello") }

    //takeIf если условие выполняется возвращает объект, если нет, то null
    val fileContents = File("myfile.txt")
        .takeIf { it.canRead() && it.canWrite() }
        ?.readText()

    var num1 = 5
}

fun formatGreeting(vipGuest: String?): String {

    //let проверяет значение на null и в противном случае проводит действия в лямбде
    return vipGuest?.let {
        "Welcome, $it. Please, go straight back - your table is ready."
    } ?: "Welcome to the tavern. You'll be seated soon."
}

 class MyClass{
     var name: String? = null
     var age: Int? = null
 }

fun nameIsLong(name: String) : Boolean = name.length >= 20

fun someCheck(myClass: MyClass) : Int? {
    return myClass.age
}
