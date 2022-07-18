fun main(args: Array<String>) {
    val options = arrayOf("Rock", "Paper", "Scissors")
    var size = args.size

    var array: Array<Int> = emptyArray()

    //for (i in 1..100) print(i)

    //for (i in 1 until 100) print(i)

    //for (i in 100 downTo  1) print(i)

    //for (x in 1..100 step 2) println(x)

//    for ((index, item) in options.withIndex()){
//        println(index)
//    }

//    var myDog = Dog("Fido", 70, "Mixed")

    val songOne = Song("The Mesopotamians", "They Might Be Giants")
    val songTwo = Song("Going Underground", "The Jam")
    val songThree = Song("Make Me Smile", "Steve Harley")

//    var anotherDog = myDog;

    songTwo.play()
    songTwo.stop()
    songThree.play()

    var myDog = Dog("Fido", 70, "dutch")
}

//fun foo(firstParam: Int, secParam: Int): Int{
//    return if(firstParam > secParam){
//        firstParam
//    }else{
//        secParam
//    }
//}

//или так
//fun foo(firstParam: Int, secParam: Int): Int = if (firstParam > secParam) firstParam else secParam

//fun foo1(firstParam: Int, secParam: Int): Unit{// возвращает void
//
//}

//class MyClass(var age: Int, var height: Double, var name: String){
//    fun outName(){
//        println("Name of employer is $name")
//    }
//}

//class Dog(val name: String, var weight: Int, val breed: String) {
//    fun bark() {
//        println(if (weight < 20) "Yip!" else "Woof!") }
//}

class Dog(val name: String, var weight: Int, breed_prop: String) {
    var activities = arrayOf("Walks")
    lateinit var someProp: String

    var weightInKg: Int
    get() {

    }

    init {
        println("Dog $name has been created ")
        var breed =  breed_prop.toUpperCase()
    }

    fun bark() {
        println(if (weight < 20) "Yip!" else "Woof!")
    }
}

