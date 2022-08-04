fun main(args: Array<String>) {

    var value = Direction.NORTH
    if (value == Direction.NORTH) {
        var res = Direction.NORTH.updateCoordinate(Coordinate(10, 20))
    }
}

enum class Direction(private val coordinate: Coordinate) {
    NORTH(Coordinate(0, -1)),
    EAST(Coordinate(1, 0)),
    SOUTH(Coordinate(0, 1)),
    WEST(Coordinate(-1, 0));

    fun updateCoordinate(playerCoordinate: Coordinate) =
        Coordinate(
            playerCoordinate.x + coordinate.x,
            playerCoordinate.y + coordinate.y
        )

    //с перегрузкой оператора можно делать так
//    fun updateCoordinate(playerCoordinate: Coordinate) =
//        coordinate + playerCoordinate
}

data class Coordinate(val x: Int, val y: Int) {
    val isInBounds = x >= 0 && y >= 0

    //в Kotlin можно перегружать следующие операторы:
    //+ += == > [] .. in и другие
    operator fun plus(other: Coordinate) = Coordinate(x + other.x, y + other.y)
}
