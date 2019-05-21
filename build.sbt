name := """mockapi"""
organization := "io.project"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.8"

val mongodb = "org.mongodb.scala" %% "mongo-scala-driver" % "2.6.0"


libraryDependencies += guice
libraryDependencies += mongodb
libraryDependencies += "com.typesafe.play" %% "play" % "2.7.2"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "io.project.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "io.project.binders._"
