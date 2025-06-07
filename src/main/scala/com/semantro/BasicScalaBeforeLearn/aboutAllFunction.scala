object aboutAllFunction extends App{
  //Make lambda function (function literal)
  val twice = (x: Int) => x*2
  println("Using twice function for 3: "+ twice(3))
  //Higher order function (Take another function as argument)
  //Function that takes a function to apply it twice
  def applyAddTwiceFunc(f: (Int,Int)=> Int,x: Int,y:Int ): Int = f(f(x,y),y)

  val adder = (x:Int,y: Int) => x+y
  println("Lets use x as 2 and y as 3 and make (2+3) + 3 using higher order : "
  + applyAddTwiceFunc(adder,2,3))



  //Lets make a higher order function to apply a function n times over a value
  def applyNTimes(f: (Int) => Int,n:Int,x:Int) : Int ={
    def loop(f:(Int) => Int, count:Int, res:Int): Int = {
      if(count==1) res else loop(f,count-1,f(res))
    }
    val result: Int= loop(f,n,x)
    result
  }

  println("Using twice 3 times for 5 is "+applyNTimes(twice,3,5))

  //Lets make (Int, Int) => Int lambda function from (Int, Int) to Int
  val subtractor:(Int,Int) => Int = (a,b) => a-b
  println("The subtracted value of 3-2 is "+subtractor(3,2))


  //currying concept: transform a function of two arguments into a function of one argument

  def curriedAdd(x: Int)(y: Int) : Int = x+y

  val addWith5 = curriedAdd(5) _
  println("adding with 5, the value of 6 is :" + addWith5(6))


  //partially applied function is created using currying concept

  def greet(greeting: String, name: String): String = greeting+name

  val nepaliGreet = greet("Namaste sabai jana lai, swagat xa ",_)
  val englishGreet = greet("Good morning to all, welcome ",_)

  println("Nepali style greet to Ram: \n"+nepaliGreet("Ram"))
  println("English style greet to Shyam: \n"+englishGreet("Shyam"))

  //closure is simply using variable outside the scope of the function

  var increment =1
  val inc = (x:Int) => x+increment
  println("When increment is 1 and x is 10 = "+inc(10))
  increment =10
  println("When increment is 10 and x is 10 = "+inc(10))

  //function composition ( we can use andThen or compose for this)
  //This is a very fun tool
  val triple = (x:Int) => x*3
  val addTwo = (x:Int) => x+2

  println("triple andThen Double for 4 = "+ (triple andThen addTwo)(4))  //(double(triple(
  println("triple compose Double for 4 = "+ (triple compose addTwo)(4))  //triple(double)




}