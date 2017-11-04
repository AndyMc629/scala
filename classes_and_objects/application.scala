/* To run a Scala program, you must supply the name of a standalone singleton
object with a main method that takes one parameter, an Array[String] ,
and has a result type of Unit . Any standalone object with a main method of
the proper signature can be used as the entry point into an application. */

//For example
import singleton.ChecksumAccumulator.calculate
object Summer {
  def main(args: Array[String]) {
    for (arg <- args)
      println(arg +": "+ calculate(arg))
    }
}

// compile this on command line with
// $ scala singleton.scala application.scala,
// then run with
// $ scala Summer of love
