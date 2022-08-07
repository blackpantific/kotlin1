fun main(args: Array<String>) {
    val telegram = InstantMessenger("Telegram")
    val photoCamera = PhotoCamera()
    val pixel = SmartPhone("Pixel 5", telegram, photoCamera)
    pixel.send("Hello Kotlin")
    pixel.takePhoto()
}

//делегирование свойств
interface Messenger1{
    val programName: String
}
class InstantMessenger1(override val programName: String) : Messenger1
class SmartPhone1(val name: String, m: Messenger1) : Messenger1 by  m

interface Messenger {
    fun send(message: String)
}

class InstantMessenger(val programName: String) : Messenger {
    override fun send(message: String) = println("Send message: `$message`")
}

interface PhotoDevice {
    fun takePhoto()
}

class PhotoCamera : PhotoDevice {
    override fun takePhoto() = println("Take a photo")
}

class SmartPhone(val name: String, m: Messenger, p: PhotoDevice) : Messenger by m, PhotoDevice by p