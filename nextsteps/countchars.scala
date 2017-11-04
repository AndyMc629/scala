// Read lines from file and print num characters in each line.
/* import scala.io.Source
if (args.length > 0) {
  for (line <- Source.fromFile(args(0)).getLines())
  println(line.length +" "+ line)
}
  else
    Console.err.println("Please enter filename")
*/
// let's make this neater

// toList required as getLines() returns an iterator
//val lines = Source.fromFile(args(0)).getLines().toList
// func to could passed strings length
//def widthOfLength(s: String) = s.length.toString.length
// calculate max width using above in Imperative style
/*var maxWidth = 0
for (line <- lines)
  maxWidth = maxWidth.max(widthOfLength(line))
*/
// in functional style
/* "The reduceLeft method applies the passed function to the first two elements
in lines , then applies it to the result of the first application and the next
element in lines , and so on, all the way through the list. On each such
application, the result will be the longest line encountered so far, because the
passed function, (a, b) => if (a.length > b.length) a else b , returns
the longest of the two passed strings. “ reduceLeft ” will return the result
of the last application of the function, which in this case will be the longest
string element contained in lines ."
*/
//val longestLine = lines.reduceLeft(
//  (a, b) => if (a.length > b.length) a else b
//)
//val maxWidth = widthOfLength(longestLine)
// print prettily using above found information
//for (line <- lines) {
//  val numSpaces = maxWidth - widthOfLength(line)
//  val padding = " " * numSpaces
//  println(padding + line.length +" | "+ line)
//}

import scala.io.Source
def widthOfLength(s: String) = s.length.toString.length
  if (args.length > 0) {
    val lines = Source.fromFile(args(0)).getLines().toList
    val longestLine = lines.reduceLeft(
      (a, b) => if (a.length > b.length) a else b
    )
    val maxWidth = widthOfLength(longestLine)
    for (line <- lines) {
      val numSpaces = maxWidth - widthOfLength(line)
      val padding = " " * numSpaces
      println(padding + line.length +" | "+ line)
    }
  }
  else
  Console.err.println("Please enter filename")
