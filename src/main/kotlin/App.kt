fun main(args: Array<String>) {

    var coordinate = Coordinate(1, 0)
    //пример деструктуризации, которая под капотом выполняется автоматически
    var (x, y) = coordinate

}

//обычный класс тоже можно деструктурировать таким способом
class PlayerScore(val experience: Int, val level:Int ){
    operator fun component1() = experience
    operator fun component2() = level
}

//класс данных
//особенно полезен, если необходимо часто вызывать toString, copy, equals или hashCode и не хочется
//прописывать эти методы самому
data class Coordinate(val x: Int, val y: Int) {
    val isInBounds = x >= 0 && y >= 0
}



