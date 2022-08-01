import mypackage.Player
import mypackage.Weapon

//listOf создает список только для чтения
//val patronList = listOf("Eli", "Mordoc", "Sophie")
//mutableListOf создает изменяемый список
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")

fun main(args: Array<String>) {

    var player = Player()
    player.castFireball()

    var num1 = player.computableField
    num1 = player.computableField
    num1 = player.computableField

    var weapon: Weapon? = Weapon("Ebony Kris")
    fun printWeaponName() {
        if (weapon != null) {
            println(weapon.name)
        }
    }
}
