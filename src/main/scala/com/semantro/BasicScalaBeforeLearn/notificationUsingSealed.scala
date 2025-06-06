/** Using extends App is a way to minimize code.
 * It simply writes main function for you behind the scenes.
  using "extends App" we can run without writing main function.
*/
object notificationUsingSealed extends App{
    sealed trait Notification
  case class Email(sender: String, subject: String) extends Notification
  case class SMS(caller: String, message: String) extends Notification
  //We use case object when we dont need any parameters and represents unique value that helps in exhaustive pattern matching
  case object Silent extends Notification

  def showNotification(n: Notification): String = n match{
    case Email(sd,sb) => s"Email from $sd:$sb"
    case SMS(caller,msg) => s"SMS From $caller:$msg "
    case Silent => "nothing."
  }

  //Remember i am not using main function and directly writing here due to app extended
  val e1 = Email("Oldton","Lets meet tomorrow")
  val s1 = SMS("+977 9898989898","Lets meet at 24th aug")
  val msg = showNotification(e1)
  println(e1+"| has produced message : \n"+msg)
  val msg2 = showNotification(s1)
  println(s1+"| has produced message : \n"+msg2)
  val msg3 = showNotification(Silent)
  println(Silent+"| has produced message : \n"+msg3)
}