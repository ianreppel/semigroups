import com.twitter.algebird.Semigroup

case class NotASemigroup(i: Int)

object NotASemigroup extends Semigroup[NotASemigroup] {
  override def plus(l: NotASemigroup, r: NotASemigroup): NotASemigroup =
    NotASemigroup(if (l.i == 1) l.i + r.i else l.i * r.i)
}
