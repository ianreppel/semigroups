import org.scalacheck.Prop.forAllNoShrink
import org.scalatest.FlatSpec
import org.scalatest.prop.Checkers.check
import org.scalatest.prop.GeneratorDrivenPropertyChecks

class NotASemigroupSuite extends FlatSpec with GeneratorDrivenPropertyChecks {

  "NotASemigroup's binary operation" should "be closed" in {
    check {
      forAllNoShrink((i1: Int, i2: Int) => {
        val (a1, a2) = (NotASemigroup(i1), NotASemigroup(i2))
        NotASemigroup.plus(a1, a2).isInstanceOf[NotASemigroup]
      })
    }
  }

  it should "be associative" in {
    check {
      forAllNoShrink((i1: Int, i2: Int, i3: Int) => {
        val (a1, a2, a3) = (NotASemigroup(i1), NotASemigroup(i2), NotASemigroup(i3))
        val left = NotASemigroup.plus(NotASemigroup.plus(a1, a2), a3)
        val right = NotASemigroup.plus(a1, NotASemigroup.plus(a2, a3))
        left == right
      })
    }
  }
}
