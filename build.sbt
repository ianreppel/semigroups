name := "SemigroupSandbox"

version := "1.0"

scalaVersion := "2.12.7"

libraryDependencies ++= Seq(
  "com.twitter" %% "algebird-core" % "0.13.4",
  "org.scalacheck" %% "scalacheck" % "1.14.0" % "test",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test")
