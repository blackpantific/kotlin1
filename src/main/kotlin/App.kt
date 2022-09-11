import kotlinx.coroutines.*

suspend fun main() = coroutineScope {

    val downloader = async {
        println("Начинаем загрузку файлов")
        for (i in 1..5) {
            println("Загружен файл $i")
            delay(500L)
        }
    }
    delay(800L)     // установим задержку, чтобы несколько файлов загрузились
    println("Надоело ждать, пока все файлы загрузятся. Прерву-ка я загрузку...")
    downloader.cancelAndJoin()    // отменяем корутину
    downloader.await()//если мы используем async/await, то при отмене асинка надо использовать блок try или
    //вылетит исключение
    // ожидаем завершения корутины
    println("Работа программы завершена")
}