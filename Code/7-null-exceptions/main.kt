import java.lang.Exception

//Remove an object reference using null
//If you want to remove a reference to an object from a variable, you can do so by assigning it a value of null:
// w = null
// However, If you want a variable to hold null values, you must explicitly declare that its type is nullable.
//A nullable type is one that allows null values. Unlike other programming languages,
// Kotlin tracks values that can be null to stop you from performing invalid actions on them.
// Performing invalid actions on null values is the most common cause of runtime problems in other languages such as Java,
// and can cause your application to crash in a heap when you least expect it.
// These problems, however, rarely happen in Kotlin because of its clever use of nullable types.

data class Wolf (val name: String = "Default Wolf", val gender: String = "Male") {

}

class MyException : Exception() {

}
fun main() {
    var w: Wolf? = Wolf()
//  "?." is the safe call operator. It lets you safely access a nullable type’s functions and properties.
    println(w?.name)
//  The let keyword used in conjunction with the safe call operator ?.
//  tells the compiler that you want to perform some action when the value it’s operating on is not null.
//    Once you’ve established that the value is not null, you can refer to it in the body of the let using it.
    w?.let { println("w is not null ${it.toString()}") } // w is not null Wolf(name=Default Wolf, gender=Male)
//    Elvis operator ?:
//    The Elvis operator first checks the value on its left
//    If this value is not null, the Elvis operator returns it. If the value on the left is null,
//    however, the Elvis operator returns the value on its right instead (in this case -1).
    w = null
    println(w?.name ?: -1) // -1
//    The not-null assertion operator, or !! deliberately throws
//    a NullPointerException when value is null
//    But if w or hunger is null, a NullPointerException will get thrown,
//    a message will be displayed in the IDE’s output window, and the application will stop running.
    try {
        var x = w!!.name
    } catch (e: NullPointerException) {
        e.printStackTrace()
        println("Assertion operator failed")
    } finally {
        println("We want to print out this line regardless of the succeed of assertion!")
    }
    var myArray: Array<String?> = arrayOf("Hi", "Hello", null)

}