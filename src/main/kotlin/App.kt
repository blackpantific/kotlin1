fun main(args: Array<String>) {

    var myClass = MyClassWithDelegate()
    myClass.someEvent = {int, double ->
            "dgfgf"
        }

}

//interface Fightable {
//    var healthPoints: Int
//    val diceCount: Int
//    val diceSides: Int
//    val damageRoll: Int
//    fun attack(opponent: Fightable): Int
//}

public class ClassThatInvokes{

    var someInt: Int
    var someDouble: Double

    constructor(int: Int, double: Double){
        someInt = int
        someDouble = double
//        MyClassWithDelegate.someEvent = {int, double ->
//            "dgfgf"
//        }
    }
}

public class MyClassWithDelegate{
    var someValue: Int? = null

    var someString: String? = null

//    companion object{
//        lateinit var someEvent: (val1: Int, val2: Int) -> String
//    }

    lateinit var someEvent: (val1: Int, val2: Int) -> String

    fun invokeDelegate(){
        println("Working with some process...")
        var res = someEvent.invoke(5,7)
    }
}