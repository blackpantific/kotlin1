import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

suspend fun main() {
    //getUsers().collect { user -> println(user) }//collect-это функция, определенная в интерфейсе Flow
    //Стоит отметить, что асинхронный поток не запускается,
    // пока не будет применена терминальная операция над получаемыми даными, например, функция collect()
    val numberFlow = getNumbers()       // поток создан, но не запущен
    println("numberFlow has created")
    println("launch collect function")
    numberFlow.collect { number -> println(number) }   // запуск потока
    delay(5000)//до этого места поток main заморожен пока не получит все данные
}

fun getUsers(): Flow<String> = flow {
    val database = listOf("Tom", "Bob", "Sam")  // условная база данных
    var i = 1;
    for (item in database) {
        delay(400L) // имитация продолжительной работы
        println("Emit $i item")
        emit(item) // емитируем значение
        i++
    }
}

fun getNumbers() = flow{
    println("numberFlow has started")
    for(item in 1..5){
        delay(400L)
        emit(item * item)
    }
}