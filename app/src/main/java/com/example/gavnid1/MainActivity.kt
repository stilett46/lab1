package com.example.gavnid1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

interface MakeVoice{
    fun loudVoice()
    fun silentVoice()
}

abstract class Animal( _age: Int, _weight : Int, _number : Int) {
    var age: Int = _age
    var weight : Int = _weight
    private var numberOfAnimal : Int = _number

    open fun findFood(){
        println("The animal number $numberOfAnimal went in search of " + Food())
    }


     open fun Food(): String{
       return "food"
    }

    abstract fun averageLifeSpan()

}

 class Dog  (var _name : String,var _age: Int,var _weight: Int,var _number: Int) : Animal(_age, _weight, _number), MakeVoice  {

    private var countOfVoices : Int = 3
    fun ShowTrick(){
        println("$_name is jumping")
    }

     fun getNumberOfDog(){
         "$_name has number $_number"
     }


    override fun findFood(){
        println("$_name went in search of " + Food())
    }

     override fun Food() : String{
         return "meat"
     }

     override fun averageLifeSpan() {
         println("Average life expectancy for dogs is 15 years")
     }


     override fun loudVoice() {
         println("WOOOOF")
     }

     override fun silentVoice() {
         println("woof")
     }

     fun giveVoice(){
         var temp : Int = countOfVoices
         println("$_name give voice for $countOfVoices times: ")
         while(temp > 0){
             loudVoice()
             temp--;
         }
     }

 }

class Cat(var numberOfCaughtMouses : Int, var _age: Int,var _weight: Int,var _number: Int) : Animal(_age, _weight, _number), MakeVoice {

    override fun Food(): String {
        return "mouse"
    }

    override fun averageLifeSpan() {
        println("average life expectancy for cats is 16 years")
    }

    fun AverageСaughtMouses() {
        println( "The cat number $_number caught " + numberOfCaughtMouses/_age + " mouses per year" )
    }

    override fun loudVoice() {
        println("MEOOW")
    }

    override fun silentVoice() {
        println("meow")
    }


}

class Bird(var nameOfSpecies : String,var _age: Int,var _weight: Int,var _number: Int) : Animal(_age, _weight, _number) {

    override fun findFood() {
        println("$nameOfSpecies went in search of " + Food())
    }

    private fun findAHabitat(name : String) : String{
        if(name == "Parrot"){
            return "tropic forest"
        }else if(name == "Pigeon"){
            return "city"
        }else{
            return "park"
        }
    }

    fun Habitat() {
        println("$nameOfSpecies live in " + findAHabitat(nameOfSpecies))
    }

    override fun averageLifeSpan() {
        println("average life expectancy for birds is 9 years")
    }


}

fun main() {

    val dog : Dog = Dog("Losik",45,4,2);
    dog.getNumberOfDog()
    dog.averageLifeSpan()
    dog.findFood()
    dog.ShowTrick()
    dog.giveVoice()
    println()

    val cat : Cat = Cat(45,13,6,1);
    cat.AverageСaughtMouses()
    cat.averageLifeSpan()
    cat.findFood()
    println("Weight of the cat number " + cat._number + " is " + cat._weight)
    println()

    val parrot : Bird = Bird("Parrot",4,2,1);
    parrot.Habitat()
    parrot.averageLifeSpan()
    parrot.findFood()

}
