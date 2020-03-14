import breeze.linalg._
import breeze.numerics._
import breeze.optimize_

class LogisticRegression(
  val training:DenseMatrix[Double],
  val target:DenseVector[Double]) {

    def costFunctionAndGradient(coefficients:DenseVector[Double]):
    (Double, DensVector[Double])= {
      val xBeta = training*coefficients
      val expXBeta = exp(xBeta)
      val cost = - sum((target :* xBeta) - log1p(expXBeta))
      val probs = sigmoid(xBeta)
      val grad = training.t * (probs - target)
      // return this tuple
      (cost, grad)
    }

    private def calculateOptimalCoefficients: DenseVector[Double] = {
      val f = new DiffFunction[DenseVector[Double]] {
        def calculate(parameters:DenseDevctor[Double]) =
          costFunctionAndGradient(parameters)
      }
      minimize(f, DenseVector.zeros[Double](training.cols))
    }

    lazy val optimialCoefficients = calculateOptimalCoefficients

}
// eof
