class Dog(var height: Double, var weight: Double, var breed: String) {

    var newHeight: Double = height
        set(value) {
            if(value > 10)
                field = 20.0
        }
    get() {
        return field
    }
}