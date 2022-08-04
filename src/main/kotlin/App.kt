import java.util.*

fun main(args: Array<String>) {

    var player: Player = Player("Tom", isBlessed = true, isImmortal = false)
    player.attack(Player("Tom", isBlessed = true, isImmortal = false))
}

interface Fightable {
    var healthPoints: Int
    val diceCount: Int
    val diceSides: Int
    //можно реализовать свойство по-умолчанию
    val damageRoll: Int
        get() = (0 until diceCount).map {
            Random().nextInt(diceSides + 1)
        }.sum()

    //можно реализовать метод по-умолчанию
    fun attack(opponent: Fightable): Int{
        println("Attack started")
        return 10
    }
}

//class Player(
//    override var healthPoints: Int = 100,
//    override val diceCount: Int,
//    override val diceSides: Int,
//    override val damageRoll: Int
//) : Fightable {
//    override fun attack(opponent: Fightable): Int {
//        TODO("Not yet implemented")
//    }
//}

class Player(
    _name: String,
    override var healthPoints: Int = 100,
    var isBlessed: Boolean = false,
    private var isImmortal: Boolean
) : Fightable {

    override val diceCount: Int = 3

    override val diceSides: Int = 6

    override val damageRoll: Int = 10

//    override fun attack(opponent: Fightable): Int {
//        val damageDealt = if (isBlessed) {
//            damageRoll * 2
//        } else {
//            damageRoll
//        }
//        opponent.healthPoints -= damageDealt
//        return damageDealt
//    }
}

abstract class Monster(
    _name: String,
    _age: Int){

    abstract var name: String

    abstract fun info()
}