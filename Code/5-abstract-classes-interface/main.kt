/*
Declare a class as abstract to stop it from being instantiated
 */

//If a superclass is marked as abstract, you don’t need to declare that it’s open.
//Abstract properties and functions define a common protocol so that you can use polymorphism.
//Abstract functions are useful because even though they don’t contain any actual function code,
// they define the protocol for a group of subclasses which you can use for polymorphism.
// As you learned in the previous chapter, polymorphism means that when you define a supertype for a group of classes,
// you can use any subclass in place of the superclass it inherits from.
// It gives you the ability to use a superclass type as a variable type, function argument, return type or array type
// e.g.,
// val animals = arrayOf(Hippo(), Lion(), Cheetah(), Lynx(), Fox())
// for (item in animals) {
//     item.roam()
//     item.eat()
// }
abstract class Animal {
    // In an abstract class, you can choose to mark properties and functions as abstract.
    // This is useful if the class has behaviors that don’t make sense
    // unless they’re implemented by a more specific subclass,
    // and you can’t think of a generic implementation that might be useful for subclasses to inherit.

    // Abstract properties and functions don’t need to be marked as open.
    abstract val image: String
    abstract val food: String
    abstract  val habitat: String
    var hunger = 10

    abstract fun makeNoise()
    abstract fun eat()

    open fun roam() {
        println("The Animal is roaming")
    }

    fun sleep() {
        println("The Animal is sleeping")
    }
}

abstract class Canine : Animal() {
    override fun roam() {
        println("The Canine is roaming")
    }
}

//You MUST implement all abstract properties and functions
class Wolf : Canine() {
    override val image = "wolf"
    override val food = "meat"
    override val habitat = "forests"

    override fun makeNoise() {
        println("Hooooowl")
    }

    override fun eat() {
        println("The wolf is eating $food")
    }
}

fun main() {
    val animal: Animal = Wolf()

//    You can access behavior that’s not defined by a variable’s type by first
//    using the is operator to check the type of the underlying object
//    "is" operator smart cast animal to Wolf. use "as" for an explicit cast
    if (animal is Wolf) {
        animal.roam()
        animal.makeNoise()
        animal.eat()
    }
//    Use when to compare a variable against a bunch of options
    when (animal) {
        is Wolf -> println("Animal is a Wolf")
        else -> {
            println("Animal is unknown")
        }
    }
}

// =====================================================
// Interface
//When you have independent classes that exhibit common behavior, you can model this behavior using an interface.
//Interfaces are used to define a protocol for common behavior
//so that you can benefit from polymorphism without having to rely on a strict inheritance structure.

//a class can implement multiple interfaces, but can only inherit from a single direct superclass.
//So using interfaces can provide the same benefits as using abstract classes, but with more flexibility.

interface Roamable {
//    You add a property to an interface by including it in the interface body.
//    This is the only way in which you can define an interface property, as unlike abstract classes,
//    interfaces can’t have constructors.
    val velocity: Int
    fun roam()
}

//Unlike when you declare that a class inherits from a superclass,
//you don’t put parentheses after the interface name.
class Vehcle : Roamable {
    override fun roam() {
        println("The vehicle is roaming")
    }

    override val velocity: Int
        get() = 10
}

//Make an abstract class when you want to define a template for a group of subclasses.
// Make the class abstract when you want to guarantee that nobody can make objects of that type.

//Make an interface when you want to define common behavior, or a role that other classes can play,
// regardless of where these classes are in the inheritance tree.

