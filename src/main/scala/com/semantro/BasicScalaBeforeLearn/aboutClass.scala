object aboutClass {
  /** we will learn about class in scala
   * Constructor parameters are defined right in the class definition */

  class Book(val title: String,val author: String,var earned: Int) {
    def describe(): Unit = {
      println(s"The book named \"$title\" published by $author has earned about Rs. $earned")
    }
  }
  /** Case classes is another amazing feature which makes scala shine in its preference over java
   * Case classes automatically create its own
   * 1. Constructor
   * 2. toString
   * 3. supports matching
   * 4. equals,hashcode,etc.
   * Case classes are immutable
   * */

    //Defining a case class is easy. We have no need to write any constructors
    case class User(name: String, email: String)


  /** Lets learn about traits. Traits is similar to java's interface but simply more powerful
   * It is more powerful as it can hold both concrete and abstract methods unlike interface.
   * We can also mixin mutliple traits making these more flexible than interface
   * */

    trait logger {
    def log(msg:String) : Unit
  }
    trait logGood extends logger{
      def log(msg:String) : Unit = {
        println("Good! "+msg)
      }

      def DoGood(msg1: String): Unit = {
        log(msg1: String)
      }
    }

  trait logBad extends logger{
    def log1(msg:String) : Unit = {
      println("Bad! "+msg)
    }
    def DoBad(msg1: String): Unit = {
      log1(msg1: String)
    }
  }

  case class LogModule(msg: String) extends logGood with logBad{
    def showAll(): Unit = {
      DoGood(msg)
      DoBad(msg)
    }
  }


  /**To override the function of parent or derived function simply use override
   * eg: override def log(msg:String): Unit = {...}
   */

    /** Sealed classes is another additional feature you can use to do magic
     * This is implemented to know traits subclasses for exhaustive pattern matching
     * What is it?
     * without sealed trait, we cannot know who inherited it to know how to match
     * with sealed trait, we can know the inherited classes then match easily*/


      sealed trait shape
  case class circle(radius : Double) extends shape
  case class rectangle(width: Double, height: Double) extends shape

  def calcArea(shapeIn : shape): Double = shapeIn match{
    case circle(r) => Math.PI * r * r
    case rectangle(w,h) => w * h
  }

  //Lets make another example of sealed trait
  sealed trait Expr
  case class Number(value:Int) extends Expr
  case class Sum(left:Expr,right:Expr) extends Expr
  case class Product(left:Expr, right:Expr) extends Expr

  def eval(expr: Expr):Int = expr match {
    case Number(n) => n
    case Sum(left,right) => eval(left) +eval(right)
    case Product(left1,right1) => eval(left1) *eval(right1)
  }
  def main(args: Array[String]) : Unit = {
    //Creating object is same as in java
    val b1 = new Book("Story of a man", "Nuuuton", 1000)
    b1.describe()
    //We can increase mutable values
    b1.earned += 1000
    b1.describe()

    //We can use case classes without creating its constructor
    val u1 = new User("NewWong","newwong@test.com")
    val u2 = new User("NewSingh","newsingh@test.com")
    val u3 = u1.copy(email="newwong2@test.com")
    println(u1)
    println(u2)
    println(u3)

    //Creating our object for extended class with mixin traits
    val c1 = new LogModule("I am coding")
    c1.showAll()

    //To use sealed trait example of shape
    val shape1 = new circle(10.0) //r = 10
    val shape2= new rectangle(5.0,4.0) //w=5,h=4
    println("Area of circle is: "+ calcArea(shape1))

    println("Area of rectangle is: "+ calcArea(shape2))

    //now evaluating the expression with sealed trait
    val e = Sum(Number(3), Product(Number(2),Number(4)))
    println("3+ (2*4) = "+ eval(e))

  }

}