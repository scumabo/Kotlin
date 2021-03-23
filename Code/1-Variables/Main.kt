fun main (args: Array<String>) {
    // 1. Compiler creates a new Int object with a value of 5
    // 2. Compiler infer the variable's type is Int based on object's type
    // 3. When an object is assigned to a variable, the object itself doesn’t go into the variable.
    //    A reference to the object goes into the variable instead.
    var x = 5

    // If you declare the variable using val, the reference to the object stays in the variable forever and can’t be
    // replaced. But if you use the var keyword instead, you can assign another value to the variable.
    val y = 6


    var number  = 1     // Int (4 bytes)
    var hugeNumber = 6L // Long (8 bytes)

    var x_d = 123.5      // Double (8 bytes)
    var x_f = 123.5f     // Float (4 bytes)

    var z_s: Short = 6     // Declare type

//    Being an object means that it has two things: state and behavior.
//    An object’s state refers to the data that’s associated with the object:
//    its properties and values. A numeric object, for example, has a numeric value,
//    such as 5, 42 or 3.12 (depending on the object’s type). A Char object has a value that’s a single character.
//    A Boolean is either true or false.
//
//    An object’s behavior describes the things the object can do, or that can be done to it.
//    A String can be capitalized, for example. Numeric objects know how to perform basic math,
//    and convert their value into an object of a different numeric type. The object’s behavior
//    is exposed through its functions.
    var x1 = 5
    var z: Long = x1.toLong()

    var myArray: Array<Int> = arrayOf(1, 2, 3)
    println(myArray[0])
    print(myArray.size)

}