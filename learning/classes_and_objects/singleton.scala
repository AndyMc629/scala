package singleton

import scala.collection.mutable.Map

class ChecksumAccumulator {
  private var sum = 0
  def add(b: Byte) { sum += b }
  def checksum(): Int = ~ (sum & 0xFF) + 1
}

// ChecksumAccumulator class's companion object.
// class and companion object can access each other's private members.
// class and companion object must be defined in same source code file.
object ChecksumAccumulator {
    private val cache = Map[String, Int]()
    def calculate(s: String): Int =
      if (cache.contains(s))
      cache(s)
      else {
        val acc = new ChecksumAccumulator
        for (c <- s)
          acc.add(c.toByte)
        val cs = acc.checksum()
        cache += (s -> cs)
        cs
      }
    }
// A singleton object is more than a container for static methods, it is
// a first class object.

// Singleton objects extend a superclass and can mix in traits.

// Singleton objects cannot take parameters whereas classes can.

// A singleton object is initialized the first time some code accesses it.

/* IMPORTANT:
=============================================================================
"A singleton object that does not share the same name with a companion
class is called a standalone object. You can use standalone objects for many
purposes, including collecting related utility methods together, or defining an
entry point to a Scala application."
=============================================================================
*/

/*
"The ChecksumAccumulator singleton object has one method, named
calculate , which takes a String and calculates a checksum for the char-
acters in the String . It also has one private field, cache , a mutable map
in which previously calculated checksums are cached. 2 The first line of the
method, “ if (cache.contains(s)) ”, checks the cache to see if the passed
string is already contained as a key in the map.

If so, it just returns the mapped value, cache(s) .
Otherwise, it executes the else clause, which cal-
culates the checksum. The first line of the else clause defines a val named
acc and initializes it with a new ChecksumAccumulator instance. 3 The next
line is a for expression, which cycles through each character in the passed
string, converts the character to a Byte by invoking toByte on it, and passes
that to the add method of the ChecksumAccumulator instances to which
acc refers. After the for expression completes, the next line of the method
invokes checksum on acc , which gets the checksum for the passed String ,
and stores it into a val named cs . In the next line, cache += (s -> cs) ,
the passed string key is mapped to the integer checksum value, and this key-
value pair is added to the cache map. The last expression of the method, cs ,
ensures the checksum is the result of the method."
*/
