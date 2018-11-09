name := "SemigroupSandbox"

version := "1.0"

scalaVersion := "2.12.7"

val algebirdVersion = "0.13.4"
val catsVersion = "1.4.0"
val scalazVersion = "7.2.27"
val disciplineVersion = "0.10.0"
val scalaCheckVersion = "1.14.0"
val scalaTestVersion = "3.0.5"

libraryDependencies ++= Seq(
  "com.twitter" %% "algebird-core" % algebirdVersion,
  "org.typelevel" %% "cats-core" % catsVersion,
  "org.typelevel" %% "cats-laws" % catsVersion,
  "org.typelevel" %% "cats-testkit" % catsVersion,
  "org.scalaz" %% "scalaz-core" % scalazVersion,
  "org.typelevel" %% "discipline" % disciplineVersion,
  "org.scalacheck" %% "scalacheck" % scalaCheckVersion % "test",
  "org.scalatest" %% "scalatest" % scalaTestVersion % "test")

addCommandAlias("build", "; clean; scalastyle; compile; test")
