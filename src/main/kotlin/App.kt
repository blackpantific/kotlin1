fun main(args: Array<String>) {

    Game.play()

    //объявление анонимного класса
    var anonymousClass = object : SomeHuman("Elon Musk"){
        override fun displayName() {
            super.displayName()
            print(" is a great person!")
        }

        fun outputSomeText(){
            println("Additional text to display")
        }
    }

    anonymousClass.displayName()
    anonymousClass.outputSomeText()

    //вызов по сути статического метода класса
    SomeHuman.getInfo()
}

object Game {
    private val player = Player("Madrigal")
    private var currentRoom: Room = TownSquare()
    init {
        println("Welcome, adventurer.")
        player.castFireball()
    }
    fun play() {
        while (true) {
            // Play NyetHack
        }
    }
    private fun printPlayerStatus(player: Player) {
        println("(Aura: ${player.auraColor()}) " +
                "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
        println("${player.name} ${player.formatHealthStatus()}")
    }
}

public open class SomeHuman(_name: String){
    open var name = _name

    public open fun displayName(){
        println("Name of person is $name")
    }

    //аналог статичных полей или методов в обычном классе в c#
    companion object{
//        consts are compile time constants. Meaning that their
//        value has to be assigned during compile time, unlike vals,
//        where it can be done at runtime.

        public const val value = "Hello world!"

        public fun getInfo(){
            println("Display some info.")
        }
    }

}


