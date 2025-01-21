import Dependencies._

/* Project settings */
ThisBuild / name := "bilge"
ThisBuild / scalaVersion := "2.13.15"
ThisBuild / version := "1.0.0-SNAPSHOT"
ThisBuild / description := "Bilge is the core application server of the ovvl.org"
ThisBuild / licenses := List(("MIT", url("https://opensource.org/license/mit")))
ThisBuild / developers ++= List(
  Developer(
    id = "ovvl-org",
    name = "ovvl-org",
    email = "dev.csgn@gmail.com",
    url = url("https://github.com/ovvl-org")
  )
)

/* Test settings */
ThisBuild / testFrameworks += new TestFramework("munit.Framework")

/* Scalafix settings */
ThisBuild / semanticdbEnabled := true
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision

/* Publish settings */
ThisBuild / publishMavenStyle := true

/* Compiler settings */
ThisBuild / scalacOptions ++= Seq(
  "-Wunused",
)

lazy val common = project
  .in(file("modules/common"))
  .settings(
    name := "common",
    moduleName := "bilge-common",
  )
  .settings(
    libraryDependencies ++= {
      Seq(
        munit % Test,
      )
    }
  )
  .enablePlugins(ScalafixPlugin)

lazy val core = project
  .in(file("."))
  .settings(
    name := "bilge-core",
  )
  .aggregate(common)
