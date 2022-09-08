fun main(args: Array<String>) {

    var c = 5

    var lambda: () -> Int = {
        var r = c
        c = 15
        r
    }

    lambda.invoke()

    var r = c
}