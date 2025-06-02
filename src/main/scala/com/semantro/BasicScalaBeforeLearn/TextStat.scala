import scala.io.StdIn.readLine
//Lets keep track of the input text.
//Frequencies of word
//How many words, how many unique words, words longer than 4 characters

//need practice again
object TextStat{

  def main(args: Array[String]): Unit ={
    println("Write any text")
    val textIn = readLine()
    val wordSplit = textIn.split(" ")
    val wordList = wordSplit.toList
    val wordMap = wordSplit.toSet



    println("Total number of words :"+wordList.size)
    println("Total number of unique words :"+wordMap.size)

    val mapFrequency = textIn.split("\\s+").groupBy(identity).view. map{case(word,freq) => (word,freq.length)}.toMap
    println(mapFrequency)
    val longWords = wordList.filter(_.length >4)
    println("Total number of long words :"+longWords.size)
    println("Long words : "+ longWords)
  }

}