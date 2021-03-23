//A lambda expression, or lambda, is a type of object that holds a block of code. You can assign a lambda to a variable,
//just as you can any other sort of object, or pass a lambda to a function which can then execute the code it holds.
//This means that you can use lambdas to pass specific behavior to a more generalized function.

fun convert(x: Double,
            converter: (Double) -> Double) : Double {
    val result = converter(x)
    println("$x is converted to $result")
    return result
}

typealias DoubleConversion = (Double) -> Double

fun combine(lambda1: DoubleConversion,
            lambda2: DoubleConversion) : (Double) -> Double {
    return { x: Double -> lambda2(lambda1(x)) }
}

fun main() {
    val addInts: (Int, Int) -> Int = {x, y -> x + y}
    println(addInts.invoke(1, 2) === addInts(1, 2))

//    f the final parameter of a function you want to call is a lambda, as is the case with our convert function,
//    you can move the lambda argument outside the function call’s parentheses.
    convert(20.0) { c: Double -> c * 1.8 + 32}

    // Define two conversion lambdas
    val kgsToPounds = { x: Double -> x * 2.204623 }
    val poundsToUSTons = { x: Double -> x / 2000.0 }

    // Combine the two lambdas to create a new one
    val kgsToUSTons = combine(kgsToPounds, poundsToUSTons)

    // Invoke the kgsToUSTons lambda
    println(kgsToUSTons(1000.0))
}