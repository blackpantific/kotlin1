import java.io.File

class Player(
    _name: String,
    var healthPoints: Int = 100,
    val isBlessed: Boolean,
    val isImmortal: Boolean) {
    var name = _name
        get() = "${field.capitalize()} of $hometown"
        private set(value) {
            field = value.trim()
        }

    //отложенная инициализация
    val hometown by lazy { selectHometown() }

    private fun selectHometown() = File("towns.txt")

        .readText()
        .split("\n")
        .shuffled()
        .first()
}

class Sword(_name: String) {
    var name = _name
        get() = "The Legendary $field"
        set(value) {
            field = value.toLowerCase().reversed().capitalize()
        }
    init {
        name = _name
    }
}