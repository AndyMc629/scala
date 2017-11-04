// after class definition, new instantiation needs keyword 'new'.
// FIelds are variables (val or var) referring to objects. Also known as
// 'instance' variables, i.e what I'm used to calling them.

// private access modifier behaves as in C++, only internal class methods
// can access the object. To make members public just don't specify the access
// modifier.
class ChecksumAccumulator {
  private var sum = 0
  def add(b: Byte): Unit = {
    sum += b
  }
  def checksum(): Int = {
    // return can be dropped, scala methods return last computed statement
    // by default.
    return ~ (sum & 0xFF) + 1
  }
}
// NOTE: In Scala, parameters to methods are always vals, i.e immutable. So
// for example, this wouldn't compile since b is a val:
/*
def add(b: Byte): Unit = {
  b = 1
  // This won’t compile, because b is a val
  sum += b
}
*/

// NOTE:
/* "The recommended style for methods is in fact to avoid having explicit,
and especially multiple, return statements. Instead, think of each method
as an expression that yields one value, which is returned. This philosophy
will encourage you to make methods quite small, to factor larger methods
into multiple smaller ones. On the other hand, design choices depend on the
design context, and Scala makes it easy to write methods that have multiple,
explicit return s if that’s what you desire."
*/

/*"Another shorthand for methods is that you can leave off the
curly braces if a method computes only a single result expression. If the
result expression is short, it can even be placed on the same line as the def
itself. With these changes, class ChecksumAccumulator looks like this:"*/
class ChecksumAccumulator {
  private var sum = 0
  def add(b: Byte): Unit = sum += b
  def checksum(): Int = ~ (sum & 0xFF) + 1
}

/*"Methods with a result type of Unit , such as ChecksumAccumulator ’s
add method, are executed for their side effects. A side effect is generally
defined as mutating state somewhere external to the method or performing
an I/O action. In add ’s case, for example, the side effect is that sum is reas-
signed. Another way to express such methods is to leave off the result type
and the equals sign, and enclose the body of the method in curly braces. In
this form, the method looks like a procedure, a method that is executed only
for its side effects. The add method in Listing 4.1 illustrates this style:"
*/
class ChecksumAccumulator {
  private var sum = 0
  def add(b: Byte) { sum += b }
  def checksum(): Int = ~ (sum & 0xFF) + 1
}
// NOTE: if you leave out the '=' when defining a function, the result is always
// Unit(),  so variables inside will get lost, i.e only do this when mutating
// state.

/* SEMICOLON INFERENCE:
"The rules of semicolon inference
The precise rules for statement separation are surprisingly simple for
how well they work. In short, a line ending is treated as a semicolon
unless one of the following conditions is true:
1. The line in question ends in a word that would not be legal as the
end of a statement, such as a period or an infix operator.
2. The next line begins with a word that cannot start a statement.
3. The line ends while inside parentheses (...) or brackets [...] ,
because these cannot contain multiple statements anyway."
*/
