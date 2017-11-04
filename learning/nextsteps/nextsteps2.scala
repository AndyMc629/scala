/*=====================
Playing with lists
======================*/
val test = List("1", "2", "3", "4", "until", "cheese", "glarg")
// how many strings in the list have length 5
test.count(s=>s.length==5)
// list without first two elements
test.drop(2)
// without last two elements
test.dropRight(2)
// does "until" exist in list
test.exists(s=>s=="until")
// do all elements end with "l"
test.forall(s=>s.endsWith("l"))
// print the elements
test.foreach(s=>print(s))
test.foreach(print)
// print the elements with spaces
test.foreach(s=>print(s+" "))
// first lement
test.head
// all but last elements
test.init
// is test empty
test.isEmpty
// last
test.last
// length
test.length
// print length of each element
test.foreach(s=>print(s.length+" "))
// add "AGH" to end of each element
test.map(s=>s+"AGH")
// reverse
test.reverse
// convert list to string with comma separator
test.mkString(" ,")
// remove length 5 elements: NOT WORKING! Use filterNot
//test.remove(s=>s.length==5)
test.filterNot(s=>s.length==5)
// list in alphabetical order in terms of first char lower cased.
// NOT WORKING! Use sortWith
//thrill.sort((s, t) => s.charAt(0).toLower < t.charAt(0).toLower)
t.sortWith((s,t)=>s.charAt(0).toLower<t.charAt(0).toLower)
// return list minus first element
test.tail

/*=====================
Playing with tuples - can hold multiple types, unlike list
======================*/
// Note: tuple indexing begins from 1, not zero.
val pair = (99, "Luftballons")
println(pair._1)
println(pair._2)

/*=====================
Playing with Sets and Maps
======================*/
// Sets can be mutable or immutable, this is immutable here. An immutable
// set returns a new set when a method such as += is applied to it.
var jetSet = Set("Boeing", "Adef formatArgs(args: Array[String]) = args.mkString("\n")irbus")
jetSet += "Lear"
println(jetSet.contains("Cessna"))
// mutable
import scala.collection.mutable.Set
val movieSet = Set("Hitch", "Poltergeist")
movieSet += "Shrek"
println(movieSet)
// immutable hashset
import scala.collection.immutable.HashSet
val hashSet = HashSet("Tomatoes", "Chilies")
println(hashSet + "Coriander")
// Maps can also be mutable or immutable.
import scala.collection.mutable.Map
val treasureMap = Map[Int, String]()
treasureMap += (1 -> "Go to island.")
treasureMap += (2 -> "Find big X on ground.")
treasureMap += (3 -> "Dig.")
println(treasureMap(2))
/* NOTE: This -> method, which
you can invoke on any object in a Scala program, returns a two-element tuple
containing the key and value*/
// for an immutable map, no import is needed
val romanNumeral = Map(
1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V"
)
println(romanNumeral(4))
