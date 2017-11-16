import sbt.CrossVersion

enablePlugins(ScalaJSPlugin, WorkbenchPlugin)

name := "Example"

version := "0.1-SNAPSHOT"

scalaVersion in ThisBuild := "2.12.4"

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)

scalacOptions ++= Seq("-Xxml:coalescing", "-P:scalajs:sjsDefinedByDefault")

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.3",
  "com.lihaoyi" %%% "scalatags" % "0.6.7",
  "com.thoughtworks.extractor" %% "extractor" % "1.1.1",
  "com.thoughtworks.binding" %%% "dom" % "11.0.0-M3",
  "com.thoughtworks.enableIf" %% "enableif" % "1.1.4"
)
