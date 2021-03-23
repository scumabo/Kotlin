/*
1. Array
2. Loop
3. Function
 */
fun main(args: Array<String>) {
    val options = arrayOf("Rock", "Paper", "Scissors")

    testLoops(options)
    getUserChoice(options)
}

fun testLoops(options: Array<String>): Unit {
    for (x in 1..10 step 2) {
        println("x = $x")
    }

    // exclude 10
    for (x in 1 until 10) {
        println("x = $x ")
    }

    for (x in 10 downTo 1) {
        println("x = $x. ")
    }

    for (item in options) {
        println("$item is an item in the array")
    }

    for ((index, item) in options.withIndex()) {
        println("Index $index has item $item")
    }
}

fun getGameChoice(optionParam: Array<String>): Any {
    return optionParam[(Math.random() * optionParam.size).toInt()]
}

fun getUserChoice(optionParam: Array<String>): Unit {
    println("Please input sth and you'll see what your input again!")
    val userInput = readLine()
    println(userInput)
}

//fun getGameChoice(optionParam: Array<String>) =
//    optionParam[(Math.random() * optionParam.size).toInt()]