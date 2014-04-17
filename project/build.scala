import sbt._
import Keys._
import sbtassembly.Plugin._
import AssemblyKeys._

object Build extends Build {

  lazy val raml = RootProject(uri("https://github.com/asikorski/raml-scala-parser.git#%s".format("v0.8.4")))

  lazy val defaultSettings =
    Defaults.defaultSettings ++
      Seq(
        name := "raml-validator",
        version := "1.0",
        scalaVersion := "2.10.1",
        scalacOptions := Seq(
          "-feature",
          "-language:implicitConversions",
          "-language:postfixOps",
          "-unchecked",
          "-deprecation",
          "-encoding", "utf8",
          "-Ywarn-adapted-args"))


  lazy val root = Project("root",
    file("."),
    settings = defaultSettings ++ assemblySettings ++ Seq(
      resolvers ++= Seq(
        "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/",
        "Maven repository" at "http://morphia.googlecode.com/svn/mavenrepo/"),
      libraryDependencies ++= Seq(
        )))
    .dependsOn(raml)

}