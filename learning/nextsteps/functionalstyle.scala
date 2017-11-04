/*
To program functionally, try programming without the mutable vars. BUT:

"Scala encourages you to lean towards vals, but ultimately
reach for the best tool given the job at hand. Even if you agree with this bal-
anced philosophy, however, you may still find it challenging at first to figure
out how to get rid of vars in your code."

*/

// Imperative
def printArgs(args: Array[String]): Unit = {
  var i = 0
  while (i < args.length) {
    println(args(i))
    i += 1
  }
}
// Functional
def printArgs(args: Array[String]): Unit = {
  args.foreach(println)
}
// or
def printArgs(args: Array[String]): Unit = {
  for (arg <- args)
    println(arg)
}
/*
"You can go even further, though. The refactored printArgs method is
not purely functional, because it has side effects—in this case, its side effect
is printing to the standard output stream. The telltale sign of a function with
side effects is that its result type is Unit . If a function isn’t returning any
interesting value, which is what a result type of Unit means, the only way
that function can make a difference in the world is through some kind of side
effect. A more functional approach would be to define a method that formats
the passed args for printing, but just returns the formatted string, as shown
in Listing 3.9:"
*/
// No side effects, pure functional
def formatArgs(args: Array[String]) = args.mkString("\n")
// to print the formatted strings then
val test2: Array[String] = Array("1","2","3","4","5","5","6","6")
println(formatArgs(test2))

// this makes testing easier
val res = formatArgs(Array("zero", "one", "two"))
// Note: assert returns quietly if true, throws assertion error if false.
assert(res == "zero\none\ntwo")

/*
Odersky summarises thus:

"A balanced attitude for Scala programmers
Prefer val s, immutable objects, and methods without side effects.
Reach for them first. Use var s, mutable objects, and methods with side
effects when you have a specific need and justification for them."
*/
