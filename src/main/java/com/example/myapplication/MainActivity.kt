package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        fun main(){

            // Exercicio 1
            var name1:String = "Arthur";
            var age1: Int = 20;
            var height = 1.78;
            println("Name: $name1")
            println("Age: $age1")
            println("Height: $height")

            //Exercicio 2
            var name2:String? = "Josenildo"
            name2 = null
            var age2: Int = 100

            //Exercicio 3
            var name3:String = "David"
            var age3:Int = 22
            val text:String = """
            Java is amazing!
            Android is cool
            Kotlin is ok :(
        """.trimIndent()

            println("My name is $name3")
            println("In 5 years: ${5 + age3}")
            println(text)

            fun helloWorld(name:String):String{
                return "Hello World, my name is: $name "
            }

            //Exercicio4

            fun sum(a: Number, b: Number): Double {
               return a.toDouble() + b.toDouble()
            }
            fun minus(a: Number, b: Number): Double {
               return a.toDouble() - b.toDouble()
            }
            fun multiplication(a: Number, b: Number): Double {
                return a.toDouble() * b.toDouble()
            }
            fun division(a:Number, b: Number): Double{
                if (b.toDouble() == 0.0){
                    println("It's not possible to divide by zero")
                    return 0.0
                }
                return a.toDouble() / b.toDouble()
            }

            println(sum(20,20))
            println(minus(30,20))
            println(multiplication(10,20))
            println(division(20,10))

            //Exercicio 5


            var temperature = 40
            var temperatureClassfication = when (temperature){
                in -20..0 -> "Frio infernal"
                in 1..10 -> "Tá fri"
                in 11..20 -> "Moderado"
                in 21..30 -> "Calor"
                in 31..40 -> "Calor desgraçado"
                else -> "Temperatura fora do normal "
            }

            val p = createPerson()
            println(p)

            //Hands-On
            val students = mutableListOf(
                Student("Arthur", "12345", 10.0, 10.0),
                Student("Carla", "11345", 7.0, 8.0),
                Student("Leonardo", "12457", 4.0, 5.0)
            )
            students.forEach{it.showReport()}

            val best = students.maxByOrNull {it.calculateMedia()}
            println("\nBest student ${best?.name}")
        }
    }

    //Exercico 6

    data class Person(val name:String, val age:Int,val height:Double)

    fun createPerson():Person{
        print("Enter the person name: ")
        var name = readln()

        print("Enter the person age: ")
        var age = readln().toInt()

        print("Enter the person hight:")
        var height = readln().toDouble()

        return Person(name, age, height)

    }
    //Hands-on
    data class Student(val name:String, val registration:String, val score1:Double, val score2:Double){

        fun calculateMedia(): Double = (score1 + score2) / 2

        fun situation():String{
            val media = calculateMedia()
            return when{
                media >= 7.0 -> "Approved"
                media >= 5.0 -> "Retake"
                else -> "Flunked"
            }

        }

        fun showReport(){
            println("==== Report ====")
            println("Student: $name ($registration)")
            println("Score 1: $score1")
            println("Score 2: $score2")
            println("Media: ${calculateMedia()}")
            println("Situation: ${situation()}")
            println("==== Report ====")

        }
    }
}
