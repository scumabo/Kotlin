// When we created our Dog class, we included a constructor;
// it’s the parentheses and the code in between in the class header:
class Dog (val name: String, var weight: Int, breed_param: String = "Mixed") {
    // We can only update the Dog’s weight property, and not the Dog’s name or breed.
    // An object is sometimes known as an instance of a particular class,
    // so its properties are sometimes called instance variables.

    // Initializer blocks are executed when the object is initialized,
    // immediately after the constructor is called
    init {
        println("Dog $name has been created.")
    }

    // Initialize property
    val breed: String = breed_param.toUpperCase()
    var weightInKgs: Double = 0.1
        get() = weight / 2.2
        set(value) {
            if (value > 0) {
                field = value
            } else {
                println("Invalid weight assigned")
            }
        }

    init {
        println("The breed is $breed")
    }

    fun bark() {
        println(if (weight < 20) "Yip!" else "Woof!")
    }
}

fun main() {
    var myDog = Dog("Fido", 70)
    myDog.bark()
    myDog.weight = 10
    myDog.bark()
    println("Dog weight in kgs = " + myDog.weightInKgs)
    myDog.weightInKgs = -1.1
}

