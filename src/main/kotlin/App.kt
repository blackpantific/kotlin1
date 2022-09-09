import kotlinx.coroutines.*

import kotlin.coroutines.suspendCoroutine

suspend fun main() = coroutineScope{

    //async можно использовать как launch, но он возвращает результат
    //запускается немедленно, для отложенного запуска также как и с launch-функцией
    //необходимо передать параметр CoroutineStart.LAZY
//    var c = async {
//        printHello1()
//    }

//    launch {
//        //все, что находится в launch выполняется в отдельном "потоке
//        //будь-то suspend-функция или простая
//        sum(1,2)
//    }

    var deferred = async(start = CoroutineStart.LAZY) {
        sum(1,2)
    }

    //deferred.start()//можно опустить
    var res = deferred.await()//можно сразу написать .await() и дождаться результата

    //var res = c.await()//как и в шарпе, функция ждет await и дальше не идет

    var m = res
    println("Hello world")
}

suspend fun printHello(){
    delay(500L)  // имитация продолжительной работы
    println("Hello work!")
}

suspend fun printHello1(): String{
    delay(500L)  // имитация продолжительной работы
    return "Hello world"
}

fun sum(a: Int, b: Int) : Int{
    println("Coroutine has started")
    return a + b
}
