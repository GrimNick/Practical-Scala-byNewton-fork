//Simply another implementation of higher order function

object calculator{
  private def add(a: Int, b: Int): Int = a+b
  private def sub(a: Int, b: Int): Int = a-b
  private def mul(a: Int, b: Int): Int = a*b
  private def div(a: Int, b: Int): Double = a.toDouble/b

  // (Int,Int) defines its arguments
  // Any defines its return type which can be any datatypes

  private def operator(op: String): (Int,Int) => Any = {
    op match{
      case "+" => add
      case "-" => sub
      case "*" => mul
      case "/" => div
      case _ => (_,_) => "Eror with input"
    }
  }

  def main(args : Array[String]): Unit = {
    val adder = operator("+")
    val subber = operator("-")
    val muller = operator("*")
    val divider = operator("/")
    println("Sum of 2 and 3 is " + adder(2,3) +"\nSub of 3 and 2 is "+subber(3,2)+
      "\nMultiplication of 2 and 3 is "+muller(2,3) +"\nDivision of 4 and 3 is "+divider(4,3))

  }
}

//Another way to solution. Simply practice

//object calculator{
//  def add1(x: Int, y: Int): Int = x+y
//  def subtract1(x:Int, y:Int): Int = x-y
//  def multiply1(x: Int,y: Int): Int = x*y
//  def divide(x:Int, y:Int): Double = x.toDouble/y
//  def operate(op: String): (Int, Int) => Any = {
//    op match {
//      case "add"  => add1
//      case "subtract" =>subtract1
//      case "multiply" => multiply1
//      case "divide"   => divide
//      case _  => (_,_)  => "Invalid operation"
//    }
//  }
//  def main(args: Array[String]): Unit ={
//    val divider = operate("divide")
//    println("The division is " + divider(4,2))
//  }
//}
