open class Hippo(open var prop: String ) : Animal() {
    //как я понимаю это аналог new в c#
    override val image = "hippo.jpg"
    override val food = "grass"
    override val habitat = "water"
    override var someProp1: String
        get() = super.someProp1
        set(value) {}

    init {
        someProp = "wre"
    }

    override fun roam() {
        println("Grunt! Grunt!")
    }

    final override fun eat() {
        println("The Hippo is eating $food")
    }
}