import com.twitter.algebird.{Semigroup => AlgebirdSemigroup}

case class NotASemigroup(i: Int)

object NotASemigroup extends AlgebirdSemigroup[NotASemigroup] {
  override def plus(l: NotASemigroup, r: NotASemigroup): NotASemigroup =
    NotASemigroup(if (l.i == 1) l.i + r.i else l.i * r.i)
}

object NotASemigroupCats {
  implicit val binaryOp: cats.Semigroup[NotASemigroup] =
    new cats.Semigroup[NotASemigroup] {
      override def combine(l: NotASemigroup, r: NotASemigroup): NotASemigroup =
        NotASemigroup(if (l.i == 1) l.i + r.i else l.i * r.i)
    }
}

object NotASemigroupScalaz {
  implicit val binaryOp: scalaz.Semigroup[NotASemigroup] =
    new scalaz.Semigroup[NotASemigroup] {
      override def append(l: NotASemigroup, r: => NotASemigroup): NotASemigroup =
        NotASemigroup(if (l.i == 1) l.i + r.i else l.i * r.i)
    }
}
