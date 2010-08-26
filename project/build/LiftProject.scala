import sbt._
import de.element34.sbteclipsify._
import de.tuxed.codefellow.plugin._
import com.github.olim7t.sbtscalariform._


class LiftProject(info: ProjectInfo) extends DefaultWebProject(info) 
with CodeFellowPlugin 
with ScalariformPlugin
with IdeaProject {
  val liftVersion = "2.1-SNAPSHOT"

  val snapshots = ScalaToolsSnapshots


    override def managedStyle = ManagedStyle.Maven
    override def jettyWebappPath = webappPath
    override def scanDirectories = Nil 

  lazy val subProject = project("subproject", "subproject", new DefaultProject(_) with IdeaProject) 

  override def libraryDependencies = Set(
    "net.liftweb" % "lift-webkit_2.8.0" % liftVersion % "compile->default",
    "net.liftweb" % "lift-mapper_2.8.0" % liftVersion % "compile->default",
    "org.mortbay.jetty" % "jetty" % "6.1.22" % "test->default",
    "junit" % "junit" % "4.5" % "test->default",
    "org.scala-tools.testing" % "specs" % "1.6.2.1" % "test->default",
    "com.h2database" % "h2" % "1.2.138"
  ) ++ super.libraryDependencies
}
