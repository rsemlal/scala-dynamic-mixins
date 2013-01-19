import sbt._
import Keys._

object WorkspaceBuild extends Build {
  lazy val root = Project(id = "scala-dynamic-mixins", base = file(".")) aggregate(scalaDynamicMixinsCore)

  lazy val scalaDynamicMixinsCore = Project(id = "scala-dynamic-mixins-core", base = file("scala-dynamic-mixins"))

  // template lazy val projet = Project(id = "project-name", base = file("project-name"))
}
