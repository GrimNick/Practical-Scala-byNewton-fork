//scala is functional language so functions are first-class citizens.
// Function returning another functions can easily make any type of function.

object functionGiveFunction{
  //these are higher order function as it returns function.
  //Possible because functions are treated as any other value (int,string,etc.) so first class citizen
  def multiplyByFactor(factor: Int) : Int => Int = (x : Int) => x * factor

  def greeter(prefix: String) : String => String = (name: String) => prefix +" "+name
  def main(args: Array[String]): Unit = {
    println("This displays use of function returning function :")
    val double = multiplyByFactor(2)
    val triple = multiplyByFactor(3)
    println("The double of 2 is "+double(2)+"\nand the triple of 5 is "+triple(5))

    val casual = greeter("Hi")
    val formal = greeter("Hello Mr.")

    println("Greeting Newton casually : "+ casual("Newton"))
    println("Greeting Newton formally : "+ formal("Newton"))

  }
}