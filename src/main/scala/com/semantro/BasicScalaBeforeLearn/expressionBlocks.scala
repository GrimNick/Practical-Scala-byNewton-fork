object expressionBlocks{
  val greeting = {
    val name = "Newton"
    val year = "2025"
    name + " is writing this in " + year
  }

  val description = {
    val name = "Scala"
    val popularity = 5
    name + " has a popularity of " + popularity + " among the youths"
  }
  def main(args: Array[String]) : Unit ={
    println(greeting)
    println(description)

    //Lambda function (Anonymous function)
    //because function is defined without a name
    //because we are using it only once

    val subtract = ( a: Int, b:Int) => a-b
    println("The subtracted value of 2 from 3 using lambda is = "+subtract(3,2))

    //making it for multiplication
    val multiply = ( a: Int, b :Int) =>a*b
    println("The multiplied value of 2 and 3 using lambda is = "+multiply(3,2))
  }
}