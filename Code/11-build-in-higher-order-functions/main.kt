data class Grocery (val name: String, val category: String,
                    val unit: String, val unitPrice: Double,
                    val quantity: Int)

fun main() {
    val groceries = listOf(Grocery("Tomatoes", "Vegetable", "lb", 3.0, 3),
                           Grocery("Mushrooms", "Vegetable", "lb", 4.0, 1),
                           Grocery("Bagels", "Bakery", "Pack", 1.5, 2),
                           Grocery("Olive oil", "Pantry", "Bottle", 6.0, 1),
                           Grocery("Ice cream", "Frozen", "Pack", 3.0, 2))

    val highestUnitPrice = groceries.maxBy { it.unitPrice }
    val sumQuantity      = groceries.sumBy { it.quantity }
    val totalPrice       = groceries.sumByDouble { it.quantity * it.unitPrice }

    val unitPriceOver3   = groceries.filter { it.unitPrice > 3.0 }
    val notFrozen        = groceries.filterNot { it.category == "Frozen" }

    val groceryNames     = groceries.map { it.name }
    val newPrices        = groceries.filter { it.unitPrice > 3.0 }
                                    .map { it.unitPrice * 2 }

    groceries.forEach { println(it.name) }

//    As forEach is a function, you can use it in function call chains.
//    Imagine that you want to print the name of each item in groceries whose unitPrice is greater than 3.0.
//    To do this using a for loop, you could use the code:
    for (item in groceries) {
        if (item.unitPrice > 3.0) println(item.name)
    }
//    But you can do this more concisely using:
    groceries.filter { it.unitPrice > 3.0 }.forEach {println(it.name)}

//    The variables defined outside the lambda which the lambda can access are sometimes
//    referred to as the lambda’s closure.
//    In clever words, we say that the lambda can access its closure.
//    And as the lambda uses the itemNames variable in its body,
//    we say that the lambda’s closure has captured the variable.

//    Closure means that a lambda can access any local variables that it captures.
    var itemNames = ""
    groceries.forEach {itemNames += "${it.name} "}
    println("itenNames: $itemNames")

    groceries.groupBy { it.category }.forEach {
        println(it.key)
        it.value.forEach{ println("     ${it.name}")}
    }

//    With fold, you can specify an initial value, and perform some operation on it for each item in a collection.
//    You can use it to, say, multiply together each item in a List<Int> and return the result,
//    or concatenate together the name of each item in a List<Grocery>, all in a single line of code.
    val names = groceries.fold("") { string, item -> string + " ${item.name}"}
    println(names)

}