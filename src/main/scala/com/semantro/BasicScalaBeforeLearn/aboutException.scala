import scala.util.{Try,Success,Failure}

/** no need to write try catch and throw here.
 * Simply use try which returns success(value) or failure(exception)
 * This helps in safe exception handling*/
object aboutException extends App{
  def parseAndDouble(s: String): Try[Int] = Try(s.toInt *2)

  println("Lets try parse and double : 2")
  println("=> "+parseAndDouble("2"))

  println("Lets try parse and double : hello")
  println("=> "+parseAndDouble("hello"))

  val db = Map(1->"Alice",2->"Walice")
  //Composing Option,Try and Match
  def lookUpMyData(id: Int) : Option[String] = db.get(id)

  val result = lookUpMyData(1) match{
    case Some(name) => "Hello "+name.toUpperCase()
    case None => "No such id found"
  }
  println("For id: 1 | Result :"+result)

  //lets chain map,flatmap (we use flatmap to avoid nested option)
  val a: Option[Int] = Some(2)
  println(a)
  //We can see 2 is nested inside some
  val b = a.map(x=>Some(x*2))
  println(b)
  //Now lets try using flatmap
  val c = a.flatMap(x=>Some(x*2))
  println(c)
  //To access inside some we can simply pattern match
  c match{
    case Some(value)=> println(value)
  }
  //we can use getOrElse for safe access
  println(c.getOrElse("none"))
}