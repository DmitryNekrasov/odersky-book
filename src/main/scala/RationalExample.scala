import scala.annotation.tailrec
import scala.language.implicitConversions

object RationalExample extends App {

  class Rational(n: Int, d: Int) {
    require(d != 0)

    def this(n: Int) = this(n, 1)

    private val g = gcd(n.abs, d.abs)

    val num: Int = (if (d < 0) -n else n) / g
    val den: Int = d.abs / g

    def +(that: Rational): Rational = new Rational(num * that.den + that.num * den, den * that.den)

    def -(that: Rational): Rational = new Rational(num * that.den - that.num * den, den * that.den)

    def *(that: Rational): Rational = new Rational(num * that.num, den * that.den)

    def /(that: Rational): Rational = new Rational(num * that.den, den * that.num)

    override def toString: String = num + (if (den != 1) "/" + den else "")

    @tailrec
    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  }

  object Rational {
    implicit def toRational(n: Int): Rational = new Rational(n)
  }


  val r1 = new Rational(-7, 5)
  val r2 = new Rational(-3, 5)
  val r3 = r1 / r2
  println(r3 + 1)
  println(3 * r1)
}