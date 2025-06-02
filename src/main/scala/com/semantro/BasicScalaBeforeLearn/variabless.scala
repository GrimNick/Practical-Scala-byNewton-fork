//Understanding variables and functions
//object or class should be same name as class
object variabless {
  //similar to java main function public static void main(string[] args)
  // return type is after :
  // = is return value (can omit return)
// Unit return type is basically void return type
  def main(args: Array[String]): Unit= {

    //Ex1 :
    // Variables
    val language = "Scala"
    var year = 2025
    print(language + " was awesome in " + year + " and still awesome in ")
    year = 2026
    println(year + "!")

    //Ex2 :
    //Greeting function
    println(greet("Newton"))

    //Ex3:
    // max min
    val a=3
    val b=5
    var numMax = max(a,b)
    var numMin = min(a,b)

    println("The numbers are : ["+a+","+b+"]"+"\n Max :"+numMax+" | Min:"+numMin)

  }
// no need to write return . IT is not idiomatic
  // Scala 2 automaticaly returns last evaluated value
  // so instead of using return x, we can do x
  def greet(name: String): String = "\"Hello, ["+name+"]!\""


  def min(a: Int, b: Int): Int = if(a>b) b else a


  def max(a: Int, b: Int): Int = if(a>b) a else b


  //if is a expression in scala, it returns value

}

//we must need object or class. need to have main function to run in ide
// cant have var as top-level definitions like in python
//val is immutable (like final in java) it cannot change
// var is mutable meaning it can vary and change
