//Collections are:
//  1.List - > Use when mostly add to front and traverse from beginning to end
//  2.Vector - > When need fast indexing and updates (better than list when working with large collections)
//  3.Set - > Need membership checking and no duplicates. Good for "Is this inside here?"
//  4.Map -> Need for key-value pairs. safe access

object collections{
  def main(args: Array[String]): Unit ={
/** Create
 * List of 5 favourite numbers
 * Vector of 3 favourite words
 * Set with duplicate elements
 * Map of 3 languages and their creators
 * */
    val numList = List(7,12,2,3,1)
    val wordVec = Vector("newton","shahi","thakuri")
    val elements = Set("banana","banana","apple")
    val languageCreator = Map("Nepal"->"Nepalese","India"-> "Indians","China" -> "Chinese")
    println(numList)
    println(wordVec)
    println(elements)
    println(languageCreator)
    //You should have observed set only printing 1 banana and one apple.

    /** Using map, filter and foreach */

    val doubled = numList.map(x => x*x)
    println("Doubling the list")
    doubled.foreach(x => println(x))
    val filtered = doubled.filter(_ % 2 ==0)
    println("Filtering the list")
    filtered.foreach(x => println(x))

    //reduce and fold. fold has starting value while reduce doesnt
    println("For this list -> " + numList)
    val sum = numList.reduce((a,b) => a+b) //we can use .sum
    println("Sum of list using reduce : "+sum)
    val sum2 = numList.fold(10)(_+_) //this _ + _ can be done in reduce too. 10 is starting value
    /** it look like
     * 10 + 7 + 12 + 2 + 3 +1
     * */
    println("Sum of list using fold of starting value 10 : " +sum2)

    // Pipeline by composing operator. Similar to java but even better syntax

    val newList = List(2,4,6,8,10)
      .map(x => x/2)
      .filter(_>2)
      .sum
    println("Sum of newList is "+newList)

    /** zip -> combines elements, groupBy -> form groups by key, flatten -> collapse nested collection */
    val list1 = List(1,2,3)
    val list2 = List("a","b","c")
    val listZipped = list1.zip(list2)
    println("\n\nZipping List first: "+list1+"\nList second"+list2+"\nZipped List:"+listZipped)


    var fruits = List("Apple",
    "Apricot",
    "Avocado",
    "Banana",
    "Blackberry",
    "Blueberry",
    "Boysenberry",
    "Orange",
    "Olallieberry",
    "Mango",
    "Mulberry",
    "Mandarin",
    "Melon",
    "Pineapple",
    "Papaya",
    "Passion fruit",
    "Peach",
    "Pear",
    "Plum",
    "Pomegranate",
    "Grapes",
    "Guava",
    "Gooseberry",
    "Watermelon",
    "Wolfberry",
    "Strawberry",
    "Starfruit",
    "Salak",
    "Kiwi",
    "Kumquat",
    "Cherry",
    "Cantaloupe",
    "Cranberry",
    "Custard apple",
    "Lychee",
    "Lime",
    "Lemon",
    "Longan",
    "Coconut",
    "Clementine",
    "Dragon fruit",
    "Date",
    "Durian")

    println("\nUngrouped list of fruits: \n" + fruits)
    val groupedFruits = fruits.groupBy(_.charAt(0))
    println("\nGrouped list of fruits: \n"+ groupedFruits)
    val flattenedFruits = groupedFruits.values.flatten
    println("\nFlattened list of fruits:\n" +flattenedFruits)

  }
}