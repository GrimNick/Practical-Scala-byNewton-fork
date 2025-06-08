
/** About implicit keyword
 * This enables use of implicit which is a very powerful tool in scala
 * This enables scala to implicitly do operations that is written by programmer
 * They can be implicit parameter (automatically find parameters)
 * Implicit conversions(automatically convert data)
 * They are used as follows:*/


object aboutImplicit extends App {
  //use implicit parameter
  //addTax(price:Double)(implicit tax:Double) -> Call with and without explicit tax

  def addTax(price:Double)(implicit tax:Double): Double = price + price*tax
  implicit val taxInNepal = 0.1
  println("Price of Rs.100 after 10% tax in Nepal becomes : Rs "+addTax(100))
  println("Price of Rs. 100 after 30% tax in Canada becomes : Rs "+addTax(100)(0.3))


  //use implicit conversion
  //Define an implicit conversion from Double to a class Money(currency: String, amount: Double) with default currency "USD".
  case class Money(currency: String ,amount : Double)
  implicit def convertDoubleToMoney(value: Double): Money = new Money("USD",value)

  val m1: Money = 200.50
  println("The money is : "+m1)


  //implicit classes (extension methods)
  implicit class MoneyBuilder(val amount: Double) extends AnyVal{
    def USD: Money = Money("USD", amount)
    def NPR: Money = Money("NPR", amount)
  }

  println("100 rupees in nepali is : "+100.0.NPR)

  println("100 rupees in USD is : "+100.0.USD)

  //Define an implicit class RichInt that adds a method times(f: => Unit) to Int to repeat a function.
  //3.times(println("Scala!"))


  implicit class RichInt(val n: Int) extends AnyVal{
    def times(f: => Unit): Unit ={
      for (_ <- 1 to n) f
    }
  }

  3.times(println("hiii"))



  //Type class : It is a pattern that lets you extend existing types with new behaviour without modifying them.
  //Define a type class Show[T] with a method show(value: T): String. Provide an implicit instance for Int and Boolean. Write a function printShow[T: Show](value: T) that prints it.
  trait Show[T] {
    def show(value: T) : String
  }
  case class test(intVal : Int, boolVal: Boolean)

  implicit val testWriter: Show[test] = new Show[test] {
    def show(t: test) : String = s"${t.intVal} + ${t.boolVal}"
  }

  def toShow[T](value: T)(implicit shower: Show[T]) : String = shower.show(value)

  val t = test(15, true)
  print("For "+t +" is " + toShow(t))



  //Context bounds and implicity
  //Context bound : Give me a generic type [T] if you have implicit for it
  //Implicit resolution : Scala will automatically find and inject based on type.
  //Use context bounds to write a function compare[T: Ordering](x: T, y: T): T that returns the larger of two values.
  def compare[T: Ordering](x: T,y:T) : T = {
    val comparing = implicitly[Ordering[T]]
    if(comparing.gt(x,y)) x else y
  }

  println("For Max: \nComparing 2 and 3 : "+ compare(2,3)+"\nComparing 2.7 and 2.3 : "+compare(2.7,2.3))

}
