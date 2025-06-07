import scala.util.Try

object safeCalculator extends App{
    def calculate(op: String, a: Int,b: Int): Try[Int] = {
      Try( op match{
        case "add" => a+b
        case "subtract" => a-b
      })
    }
  val res = calculate("add",1,2)
  println(res)

  //Remember to just get value inside the success or failure we use
  println(res.getOrElse("Nothing"))
  }