import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce

suspend fun main() = coroutineScope{

    val channel = Channel<Int>()
    launch {
        for (n in 1..5) {
            // отправляем данные через канал
            channel.send(n)
        }
        channel.close()
    }

    // получаем данные из канала
    for(user in channel) {  // Получаем данные из канала
        println(user)
    }
    println("End")
}

fun CoroutineScope.getUsers(): ReceiveChannel<String> = produce{
    val users = listOf("Tom", "Bob", "Sam")
    for (user in users) {
        send(user)
    }
}