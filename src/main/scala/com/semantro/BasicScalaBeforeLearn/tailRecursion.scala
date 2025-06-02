import scala.annotation.tailrec
import scala.io.StdIn.readInt
//scala support TCO(tail call optimization)
//we can use @tailrec to make compiler check if recursion isnt tail - recursive
//without tail recursion, deep recursion can crash with StackOverFlowError
//it is a loop under the hood, meaning compiler transform loop into a simple
//loop like structure instead of creating new stack frame for every recursive call
//Loop under the hood because it looks like recursion but is running as loop
//effectively running recursion as while or for loop
//we are avoiding stack from growing.

object tailRecursion{
  def main(args: Array[String]): Unit = {
    printf("Enter the value you want to find factorial of : ")
    val n = readInt()
    println("The factorial of given number "+n+" = "+factorial(n))
  }
  //for tail recursion, we use nested function to
  //keep outer function signature clean (commonly used)
  def factorial(num : Int): Int = {
    @tailrec
    def loop(x: Int,acc: Int): Int = {
      if (x== 0) acc
      else loop(x-1,acc*x)
    }
    loop(num,1)
  }
}

//Same goal but another approach

//object tailRecursion{
//  def main(args: Array[String]) : Unit = {
//    val n = readInt()
//    println(factorial(n))
//  }
//  def factorial(n: Int): Int = {
//    def loop(x: Int, acc: Int): Int = if (x==0) acc else loop(x-1,acc*x)
//    loop(n,1)
//  }
//}

























