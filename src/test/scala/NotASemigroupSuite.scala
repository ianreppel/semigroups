import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers}

class NotASemigroupSuite extends FlatSpec with Matchers with GeneratorDrivenPropertyChecks {

  "NotASemigroup's binary operation" should "be closed" in {
    forAll((i1: Int, i2: Int) => {
      val (a1, a2) = (NotASemigroup(i1), NotASemigroup(i2))
      NotASemigroup.plus(a1, a2) shouldBe a [NotASemigroup]
    })
  }

  it should "be associative" in {
    forAll((i1: Int, i2: Int, i3: Int) => {
      val (a1, a2, a3) = (NotASemigroup(i1), NotASemigroup(i2), NotASemigroup(i3))
      val left = NotASemigroup.plus(NotASemigroup.plus(a1, a2), a3)
      val right = NotASemigroup.plus(a1, NotASemigroup.plus(a2, a3))
      left shouldEqual right
    })
  }
}
