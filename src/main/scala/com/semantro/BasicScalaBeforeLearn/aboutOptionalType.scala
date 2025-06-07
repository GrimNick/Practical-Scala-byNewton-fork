import scala.io.StdIn.readInt

/** 'Option' is used to overcome null
 * This helps to provide fallback option using Some(value)
 */

object aboutOptionalType extends App{
  def safeDivide(x:Int, y:Int): Option[Int] = {
    if(y!=0) Some(x/y)
    else None
  }
  println("Enter two numbers : ")
  val x=readInt()
  val y =readInt()
  val res = safeDivide(x,y)
  println("Using map to print")
  //Using map to print
  res.map(x=> println(x))
  //This is idiomatic and efficient than using map
  println("Using foreach to print")
  res.foreach(println)
  println("Using getorelse to print :\n"+res.getOrElse("Y is zero"))
}