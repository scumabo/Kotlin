//Generics lets you write code that’s type-safe.
// It’s what makes the compiler stop you from putting a Volkswagen into a list of Ducks.
// The compiler knows that you can only put Duck objects into a MutableList<Duck>,
// which means that more problems are caught at compile-time.

abstract class Pet(var name: String)

class Cat(name: String) : Pet(name)

class Dog(name: String) : Pet(name)

class Fish(name: String) : Pet(name)

// You can restrict T to a specific supertype
class Contest<T: Pet>(var vet: Vet<T>) {
    private val scores: MutableMap<T, Int> = mutableMapOf()

    fun addScore(t: T, score: Int = 0) {
        if (score > 0) scores[t] = score
    }

    fun getWinners() : MutableSet<T> {
        val highScore = scores.values.max()

        val winners: MutableSet<T> = mutableSetOf()

        for ((t, score) in scores) {
            if (score == highScore) winners.add(t)
        }

        return winners
    }
}

class Vet<T: Pet> {
    fun treat(t: T) {
        println("Treat Pet ${t.name}")
    }
}
//Use out to make a generic type covariant
//If a generic type is covariant, it means that you can use a subtype in place of a supertype.
//Collections are defined using covariant types
//The out prefix isn’t just used by generic classes and interfaces that you define yourself. They’re also heavily used by Kotlin’s built-in code, such as collections.
//
//The List collection, for example, is defined using code like this:
//
//public interface List<out E> ... { ... }
//This means that you can, say, assign a List of Cats to a List of Pets, and the code will compile:
//
//Now that you’ve seen how to make generic types covariant using out, let’s add the code we’ve written to our project.
//
//val catList: List<Cat> = listOf(Cat(""), Cat(""))
//
//val petList: List<Pet> = catList
interface Retailer<out T> {
    fun sell(): T
}

class CatRetailer : Retailer<Cat> {
    override fun sell(): Cat {
        println("Sell Cat")
        return Cat("cat")
    }
}

class DogRetailer : Retailer<Dog> {
    override fun sell() : Dog {
        println("Sell Dog")
        return Dog("dog")
    }
}

fun main() {
    val catVet = Vet<Cat>()
    val petVet = Vet<Pet>()
    val dogVet = Vet<Dog>()


    val petContext = Contest<Pet>(petVet)
    petContext.addScore(Cat("Fuzz Lightyear"), 50)
    petContext.addScore(Fish("Finny McGraw"), 60)

    println(petContext.getWinners().first())

    val petRetailer: Retailer<Pet> = CatRetailer()
    petRetailer.sell()
}