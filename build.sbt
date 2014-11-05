name := "play-predictionio"

organization := "com.github.filosganga"

homepage := Some(url("http://github.com/filosganga/play-predictionio"))

organizationHomepage := Some(url("http://filippodeluca.com"))

licenses := Seq("Apache 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.html"))

startYear := Some(2013)

scmInfo := Some(ScmInfo(
    url("http://github.com/filosganga/play-predictionio"),
    "scm:git:git@github.com:filosganga/play-predictionio.git",
    Some("scm:git:git@github.com:filosganga/play-predictionio.git")
))

scalaVersion := "2.10.3"

crossScalaVersions := Seq("2.10.3")

scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature")

libraryDependencies ++= {
   val playVersion = "2.3.6"
   Seq(
     "com.typesafe.play" %% "play" % playVersion % "provided",
     "com.typesafe.play" %% "play-json" % playVersion % "provided",
     "com.typesafe.play" %% "play-ws" % playVersion % "provided",
     "org.specs2" %% "specs2" % "1.14" % "test",
     "org.mockito" % "mockito-all" % "1.9.5" % "test",
     "com.typesafe.play" %% "play-test" % playVersion % "test"
   )
}

pomIncludeRepository := { _ => false }

pomExtra :=
  <developers>
    <developer>
      <id>filosganga</id>
      <name>Filippo De Luca</name>
      <url>http://filippodeluca.com</url>
      <email>me@filippodeluca.com</email>
      <roles>
        <role>developer</role>
      </roles>
      <timezone>GMT</timezone>
    </developer>
    <developer>
      <id>jeantil</id>
      <name>Jean Helou</name>
      <url>http://blog.byjean.eu</url>
      <email>jean.helou+github@gmail.com</email>
      <roles>
        <role>developer</role>
      </roles>
      <timezone>CET</timezone>
    </developer>
  </developers>


publishMavenStyle := true

publishArtifact in Test := false

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (version.value.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

resolvers ++= Seq("Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases/")

version in ThisBuild <<=(GitKeys.gitHeadCommit in ThisBuild) apply { (commit)=> commit.getOrElse("Undefined")}
