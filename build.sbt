// Project info

name := "play-mongo-jackson-mapper"

organization := "net.vz.mongodb.jackson"

// The version comes from version.sbt, and is generated by the release plugin

scalaVersion := "2.9.1"

// Dependencies

libraryDependencies ++= Seq(
    "net.vz.mongodb.jackson" % "mongo-jackson-mapper" % "1.4.1",
    "com.fasterxml" % "jackson-module-scala" % "1.9.3",
    "play" %% "play" % "2.0"
)

// Test dependencies

libraryDependencies ++= Seq(
    "org.specs2" %% "specs2" % "1.8.2" % "test",
    "play" %% "play-test" % "2.0" % "test"
)

// Configuration required for deploying to sonatype

publishMavenStyle := true

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

pomIncludeRepository := { _ => false }

publishArtifact in Test := false

pomExtra := (
  <url>http://github.com/vznet/play-mongo-jackson-mapper</url>
  <inceptionYear>2012</inceptionYear>
  <licenses>
    <license>
      <name>Apache 2</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
      <distribution>repo</distribution>
      <comments>A business-friendly OSS license</comments>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:vznet/play-mongo-jackson-mapper.git</url>
    <connection>scm:git:git@github.com:vznet/play-mongo-jackson-mapper.git</connection>
  </scm>
  <developers>
    <developer>
      <name>James Roper</name>
      <email>james@jazzy.id.au</email>
      <url>http://jazzy.id.au</url>
      <roles>
        <role>Author</role>
      </roles>
      <organization>VZ Netzwerke</organization>
    </developer>
  </developers>)
