import kotlin.reflect.KProperty

fun main() {

}

class Player {
    lateinit var alignment: String
    fun determineFate() {
        alignment = "Good"
    }

    fun proclaimFate() {
        //если обратиться к свойству alignment до того как оно будет
        //инициализированно, то возникнет исключение
        //в отличие от инициализации при помощи by lazy
        if (::alignment.isInitialized) println(alignment)
    }
}