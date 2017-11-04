// Print from a script
println("Hello world from a script!")
println()

// Say hello to the first argument
println("Hello "+args(0)+"!")
println()

/*
Multiline comment.
*/

// While: Imperative
var i = 0
while (i<args.length) {
  println(args(i))
  i+=1
}
println()

// echo args: Imperative
i = 0
while (i<args.length) {
  if(i != 0)
    print(" ")
  print(args(i))
  i += 1
}
println()

//echo args verbose code: Imperative
i = 0;
while (i<args.length) {
  if(i != 0) {
    print(" ");
  }
  print(args(i));
  i += 1
}
println()

// echo args no newline: Functional
args.foreach(arg => println(arg))
println()

// more explicit: Functional
args.foreach((arg: String) => println(arg))
println()

// if a functional literal consists of one statement that takes a single
// argument, you need not explicitly name and specify the argument.
args.foreach(println)
println()

// for expression: Functional cousin of Imperative for
for (arg <- args)
  println(arg)
