
object funcionalCalculator extends App{
  def makeOp(op:String): (Int,Int) => Int = (x,y) => op match{
    case "add" => x+y
    case "sub" =>x-y
    case "mul" => x*y
    case "div" => x/y
  }

  val add = makeOp("add")
  println("Adding 10 and 5 = "+add(10,5))

  val addDouble = makeOp("add").tupled andThen (_ * 2)
  //for tupled we need to use (())
  println("Adding then doubling for 3,4 = "+addDouble((3,4)))


}