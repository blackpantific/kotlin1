import java.time.Year

open class Car(name: String, Country: String, year: Int) {

    open var name = ""
    open var country = ""
    open var year = 2019

    open fun ride(){
        println("Ride")
    }
}