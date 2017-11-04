// let's make a class for rational numbers
// Note: In Java, classes have constructors, which can take parameters,
// whereas in Scala, classes can take parameters directly.
class Rational(n: Int, d: Int) {
  // precondition checking
  require( d != 0)

  // greatest common divisor, so simplfy top-heavy fractions
  // passing absolute value ensures g > 0.
  private val g = gcd(n.abs, d.abs)

  val numer: Int = n / g
  val denom: Int = d / g

  // auxiliary constructor for passing in single number
  def this(n: Int) = this(n, 1)

  // add method
  /*def add(that: Rational): Rational =
    new Rational(
      numer*that.denom + that.numer*denom,
      denom*that.denom
    )*/
  def + (that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
  )
  // overload to perform addition with an integer
  def + (i: Int): Rational =
    new Rational(numer + i * denom, denom)

  // subtract and overloaded subtract
  def - (that: Rational): Rational =
      new Rational(
      numer * that.denom - that.numer * denom,
      denom * that.denom
    )
  def - (i: Int): Rational =
    new Rational(numer - i * denom, denom)

  // multiply method
  def * (that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom)

  def * (i: Int): Rational =
    new Rational(numer * i, denom)

  // divide and overloaded divide
  def / (that: Rational): Rational =
    new Rational(numer * that.denom, denom * that.numer)

  def / (i: Int): Rational =
    new Rational(numer, denom * i)

  // is current rational smaller than another, this here is superfluous
  def lessThan(that: Rational) =
    this.numer * that.denom < that.numer * this.denom

  // what's bigger, this (current object) or that (other object)
  // note: first "this" is not necessary.
  def max(that: Rational) =
    if (this.lessThan(that)) that else this

  // method override to tell scala how to print this object's summary
  override def toString = numer + "/" + denom

  // get the greatest common divisor
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}
// try this in interpreter
// val x = new Rational(3,4)
// val test = new Rational(3,4)
// val test2 = new Rational(4,5)
// test add test2
// you can now access the members since numer and denom are public
// test.numer
// test.denom

// The keyword this refers to the object instance on which the currently exe-
// cuting method was invoked, or if used in a constructor, the object instance
// being constructed.

// Auxiliary constructors in scala start with def this(...)
// In Scala, every auxiliary constructor must invoke another constructor of
// the same class as its first action.

// so that you can write 2*test as well as test*2 you'd need an implicit conversion
// defined like:
// implicit def intToRational(x: Int) = new Rational(x)

/* "Note that for an implicit conversion to work, it needs to be in scope. If
you place the implicit method definition inside class Rational , it won’t be
in scope in the interpreter. For now, you’ll need to define it directly in the
interpreter."*/
