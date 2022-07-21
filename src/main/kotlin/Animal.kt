open class Animal {
    open val image = ""
    open val food = ""
    open val habitat = ""
    var hunger = 10
    open var someProp = ""

    open var someProp1: String = ""
    set(value) {
        field = value
    }
    get() {
        return field
    }

    open fun makeNoise() {
        println("The Animal is making a noise")
    }

    open fun eat() {
        println("The Animal is eating")
    }

    open fun roam() {
        println("The Animal is roaming")
    }

    fun sleep() {
        println("The Animal is sleeping")
    }
}