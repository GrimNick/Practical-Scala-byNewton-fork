/*A function describeYear that
takes an Int and returns "The year is X"
*/
import scala.io.StdIn.{readLine,readInt}
object inputOutput{
  def main(args: Array[String]): Unit ={
    println("Input a number")
    val number : Int = readInt();
    println(describeYear(number))
  }

  def describeYear(num: Int): String = "The year is "+num

}