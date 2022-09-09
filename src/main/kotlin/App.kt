import kotlinx.coroutines.*

//ПОСЛЕДОВАТЕЛЬНОСТЬ ИСПОЛНЕНИЯ ЕЩЕ РАЗ
//suspend fun main() {
//    var c= 5
//    coroutineScope {
//
//        async{ printHello()}
//        println("Program has finished")//выполняется 2м
//    }
//
//    println("some output")//выполняется 1м
//}
//
//suspend fun printHello(){
//    delay(500L)  // имитация продолжительной работы
//    println("Hello work!")//выполняется 3м
//}

//suspend fun main() = coroutineScope{
//
//    launch {
//        println("Корутина выполняется на потоке: ${Thread.currentThread().name}")
//    }
//    println("Функция main выполняется на потоке: ${Thread.currentThread().name}")
//}

//Конфигурация Dispatchers.Default
//suspend fun main() = coroutineScope{
//
//    launch(Dispatchers.Default) {   // явным образом определяем диспетчер Dispatcher.Default
//        println("Корутина выполняется на потоке: ${Thread.currentThread().name}")
//    }
//    println("Функция main выполняется на потоке: ${Thread.currentThread().name}")
//}

//Dispatchers.Unconfined
//suspend fun main() = coroutineScope{
//
//    launch(Dispatchers.Unconfined) {
//        println("Поток корутины (до остановки): ${Thread.currentThread().name}")//выполняется в main
//        //до первой остановки, напоминает async/await в c# с продолжением выполнения в другом потоке
//        //после выполнения await, а до этого метод вызывается и выполняется в том же потоке до оператора await
//        delay(500L)
//        println("Поток корутины (после остановки): ${Thread.currentThread().name}")
//    }
//
//    println("Поток функции main: ${Thread.currentThread().name}")
//}

//newSingleThreadContext("Custom Thread") ручное создание потока с заданным именем
suspend fun main() = coroutineScope{

    launch(newSingleThreadContext("Custom Thread")) {
        println("Поток корутины: ${Thread.currentThread().name}")
    }

    println("Поток функции main: ${Thread.currentThread().name}")
}