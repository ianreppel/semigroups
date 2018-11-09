import cats.tests.CatsSuite
import org.scalacheck.Arbitrary

class SemigroupLawsSuite extends CatsSuite {

  import NotASemigroupCats._
  import cats.kernel.laws.discipline.SemigroupTests

  implicit val arbNotASemigroup: Arbitrary[NotASemigroup] = Arbitrary {
    Arbitrary.arbInt.arbitrary.map(NotASemigroup(_))
  }
  implicit val eqNotASemigroup: cats.kernel.Eq[NotASemigroup] =
    cats.kernel.Eq.fromUniversalEquals

  checkAll("cats.Semigroup laws for NotASemigroup", SemigroupTests[NotASemigroup].semigroup)
}
