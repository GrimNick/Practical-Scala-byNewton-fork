import scala.io.StdIn.{readChar, readInt}

object matchCalculator extends App {
  println("Give two integer")
  val a = readInt()
  val b = readInt()
  println("Give an operator")
  val op = readChar()

  val result = op match{
    case '+' => a+b
    case '-' => a-b
    case '*' => a*b
    case '/' => a/b
    case _ => "nothing"
  }
  println("ans is : "+ result)
}