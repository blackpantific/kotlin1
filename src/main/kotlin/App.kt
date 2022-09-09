import kotlinx.coroutines.*

//suspend=функция, пока что корутины не используются
// suspend fun main(){
//    for(i in 0..5){
//        delay(400L)
//        println(i)
//    }
//
//    println("Hello Coroutines")
//}

//suspend fun main() = coroutineScope{
//    var res = launch{
//        for(i in 0..5){
//            delay(400L)
//            println(i)
//        }
//    }
//
//    println("Hello Coroutines")
//
//    var c = 5
//    var m = 7
//    delay(400)
//}

///В ряде языков программирования есть такие структуры, которые позволяют использовать потоки. Однако между корутинами и потоками нет прямого соответствия. Корутина не привязана к конкретному потоку. Она может быть приостановить выполнение в одном потоке, а возобновить выполнение в другом.
//
//Когда корутина приостанавливает свое выполнение,
// например, как в случае выше при вызове задержки с
// помощью функции delay(), эта корутина освобождает поток,
// в котором она выполнялась, и сохраняется в памяти. А освобожденный
// поток может быть зайдествован для других задач. А когда завершается
// запущенная задача (например, выполнение функции delay()), корутина
// возобновляет свою работу в одном из свободных потоков.

//suspend fun main() = coroutineScope<Unit> {
//    //без launch
//    launch { doWork() }
//    println("Hello world")
//
//}

//вынесение кода корутин в отдельную функцию
//suspend fun doWork() {
//    for (i in 0..5) {
//        println(i)
//        delay(400L)
//    }
//}


//функция main завершается только после завешения выполнения корутин

suspend fun main() {
//    var c = 5
//    someFun()//пока не отработают корутины main заблочена
//    var s = 10//присваивание выполняется только после того как someFun() отработает
//
//    for (i in 1..30) {//выполняется 3м
//        println(i)
//        delay(100)
//    }

    nestedCoroutines()
}

suspend fun someFun() {
    coroutineScope {//runBlocking является аналогом coroutineScope,
        //только в отличие от нее он блокирует вызывающий поток, а не приостанавливает

        launch {//выполняется 2м
            for (i in 0..5) {
                delay(400L)
                println(i)
            }
        }
        launch {//выполняется 2м
            for (i in 6..10) {
                delay(400L)
                println(i)
            }
        }
        //эта часть кода живет сама по себе и выполняется до выполнения корутин

        println("Hello Coroutines")//выполняется 1м
    }
}

suspend fun nestedCoroutines() {
    coroutineScope {
        launch {
            println("Outer coroutine")//выполняется 2м
            for (i in 1..5) {
                delay(400L)
                println("Outer coroutine" + i)
            }
            launch {//по результатам дебага вложенная корутина не запускается до завершения
                // родительской корутины
                println("Inner coroutine")//выполняется 3м

                for (i in 6..10) {
                    delay(400L)
                    println("Inner coroutine" + i)
                }
            }
        }
        println("End of Main")//выполняется 1м
    }
}


