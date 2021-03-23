/*
Inheritance helps you avoid duplicate code, and improve your flexibility with polymorphism.
When you design with inheritance, you put common code in one class,
and then allow other more specific classes to inherit this code. When you need to modify the code,
you only have to update it in one place, and the changes are reflected in all the classes that inherit that behavior.

The class that contains the common code is called the superclass,
and the classes that inherit from it are called subclasses.

When you define a set of properties and functions in a superclass,
you’re guaranteeing that all its subclasses also have these properties and functions.
In other words, you define a common protocol, or contract,
for a set of classes that are related by inheritance.
*/

// To use a class as a superclass, it must be declared as open.
// Everything you want to override must also be open.
open class Animal (val name: String) {

    open val image = ""
    open val food = ""
    open val habitat = ""
    var hunger = 10

    open fun makeNoise() {
        println("The Animal is making a noise")
    }

    open fun eat() {
        println("The Animal is eating")
    }

    open fun roam() {
        println("The Animal is roaming")
    }

    fun sleep() {
        println("The Animal is sleeping")
    }
}

class Hippo (name: String): Animal(name) {
//    if you define a property in the superclass using val,
//    you must override it in the subclass if you want to assign a different value to it.
    override val image = "Hippo"
    override val food = "seeweed"
//    If a superclass property has been defined using var,
//    you don’t need to override it in order to assign a new value to it,
//    as var variables can be reused for other values.
    init {
        hunger = 20
    }
// An overridden function or property stays open...
    override fun makeNoise() {
        println("Grunt! Grunt!")
    }
// ...until it’s declared final
    final override fun eat() {
        println("The Hippo is eating $food")
    }
}

open class Canine (name: String) : Animal(name) {
    override fun roam() {
        println("The Canine is roaming")
    }
}
class Wolf (name: String) : Canine(name) {
    override val image = "wolf"
    override val food = "meat"
    override val habitat: String
        get() = super.habitat + "forest"

    final override fun makeNoise() {
        println("Hoooowl!")
    }

    final override fun eat() {
        println("The wolf is eating $food")
    }

}

class Vet {
//    Being able to use one type of object in a place that explicitly expects a different type is called polymorphism.
//    It’s the ability to provide different implementations for functions that have been inherited from somewhere else.
//    Polymorphism means “many forms”.
//    It allows different subclasses to have different implementations of the same function.
    fun giveShot(animal: Animal) {
        animal.makeNoise()
    }
}

fun main() {
    val animals = arrayOf(Hippo("Funny"), Wolf("Wild"))
    val vet = Vet()
    for (animal in animals) {
        animal.roam()
        animal.eat()
        vet.giveShot(animal)
    }
}