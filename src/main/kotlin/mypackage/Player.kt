package mypackage

class Weapon(val name: String)

public class Player {

    //поля должны быть инициализированы до создания объекта
    var name = "madrigal"
        get() = field.capitalize()
        private set(value) {
            field = value.trim()
        }

    val name1: String
        get() = "Madrigal"

    //вычисляемое свойство не инициализируется при создании
    val computableField
        get() = (1..6).shuffled().first()

    var healthPoints = 89
    val isBlessed = true
    private val isImmortal = false

    public fun castFireball(numFireballs: Int = 2) =
        println("A glass of Fireball springs into existence. (x$numFireballs)")

    public fun auraColor(isBlessed: Boolean): String {
        val auraVisible = isBlessed && healthPoints > 50 || isImmortal
        val auraColor = if (auraVisible) "GREEN" else "NONE"
        return auraColor
    }

    public fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
        when (healthPoints) {
            100 -> "is in excellent condition!"
            in 90..99 -> "has a few scratches."
            in 75..89 -> if (isBlessed) {
                "has some minor wounds, but is healing quite quickly!"
            } else {
                "has some minor wounds."
            }
            in 15..74 -> "looks pretty hurt."
            else -> "is in awful condition!"
        }
}