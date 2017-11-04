// instantiate object with new,
// parameterize it by passing objects to constructor.
val big = new java.math.BigInteger("12345")

// parameterize an instance with types, length 3 here.
// Note: this is not the recommended way to create and
// initialize an array in scala.
val greetStrings = new Array[String](3)

greetStrings(0) = "Hello"
greetStrings(1) = ","
greetStrings(2) = "world!\n"

/* If a method only takes one parameterm you can call it without
a dot or parenthesis. The "to" here is a method that takes on Int arg,
so "0 to 2" is transformed into the method call (0).to(2) .*/
for (i <- 0 to 2)
  print(greetStrings(i))

// more verbose
// val greetStrings: Array[String] = new Array[String](0)

////////////////////////////////////////////////////////////////////
/* Important Note:

val => variable cannot be reassigned, but the object to which
it refers could potentially still be changed. So, for example,
here you couldn't reassign greetStrings to a different Array,
greetStrings will always point to the same Array[String] instance
with which it was initialized. But you can change the elements of
that Array[String] over time, so the array itself is mutable.
*/
////////////////////////////////////////////////////////////////////
/* Due to stuff being carried on under hood concering transformations
  like "0 to 2" to (0).to(2), the following is semantically equiv to above.

  val greetStrings = new Array[String](3)

  greetStrings.update(0, "Hello")
  greetStrings.update(1, ",")
  greetStrings.update(2, "world!\n")

  for (i <- 0.to(2))
    print(greetStrings.apply(i))
*/

// better way to create array - Array[String] type is inferred
val numNames = Array("zero", "one", "two")
// really calling factory method "apply here"
val numNames2 = Array.apply("zero", "one", "two")

////////////////////////////////////////////////////////////////////
// Lists - immutable sequences of objects (whereas Array's are mutable)
val oneTwoThree = List(1,2,3)
// due to immutability, when you call a method on a list that implies
// mutation, instead a new list is created nd returned. For example
// the ::: list concatenation method
val oneTwo = List(1,2)
val threeFour = List(3,4)
val oneTwoThreeFour = oneTwo ::: threeFour
println(oneTwo + " and "+ threeFour + " were not mutated.")
println("Thus, "+ oneTwoThreeFour+ " is a new list.")

// :: - the 'cons' operator. Prepends to a list
val twoThree = List(2,3)
val newOneTwoThree = 1 :: twoThree
println(oneTwoThree)

// List() or Nil = empty list
