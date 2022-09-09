import kotlinx.coroutines.*

suspend fun main() = coroutineScope{

//    val job = launch{
//        for(i in 1..5){
//            println(i)
//            delay(400L)
//        }
//    }
//
//    println("Start")
//    job.join()//ожидаем завершения корутины
//    //что-то типа использования объекта таск в c# и вызоваметода ожидания не помню какого
//    println("End")

    var job = launch(start = CoroutineStart.LAZY) {
        delay(200L)
        println("Coroutine has started")
    }

    println("Other actions in main method")
    job.start()//запуск корутины вручную, а не сразу,
    // как в случае с вызовом launch без параметров
}