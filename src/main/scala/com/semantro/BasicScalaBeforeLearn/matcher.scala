import scala.io.StdIn.readInt

object matcher extends App{
  def respond(code: Int): String = code match{
    case 200 => "ok"
    case 404 => "Not found"
    case 500 => "Server Error"
    case _ => "Unknown"
  }
  printf("Enter the status of your server\n=>")
  val codeIn = readInt()
  printf("Response: "+respond(codeIn))
}