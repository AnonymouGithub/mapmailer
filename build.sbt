name := "mapmailer"

version := "1.0-SNAPSHOT"

resolvers += "Open Source Geospatial Foundation Repository" at "http://download.osgeo.org/webdav/geotools/"

libraryDependencies ++= Seq(
  cache,
  filters
)

libraryDependencies += "com.google.code.findbugs" % "jsr305" % "2.0.3" // see http://stackoverflow.com/questions/10007994/why-do-i-need-jsr305-to-use-guava-in-scala

libraryDependencies += "com.typesafe.play" %% "play-iteratees" % "2.2.2" from "http://repo.typesafe.com/typesafe/releases/com/typesafe/play/play-iteratees_2.10/2.2.2/play-iteratees_2.10-2.2.2.jar"

libraryDependencies += "org.reactivemongo" %% "play2-reactivemongo" % "0.10.2" excludeAll ExclusionRule(organization = "org.apache.logging.log4j")

libraryDependencies += "org.scala-lang" % "scala-compiler" % "2.10.3" // reactivemongo depends on scala-compiler

libraryDependencies += "org.apache.logging.log4j" % "log4j-to-slf4j" % "2.0-rc1"

libraryDependencies += "uk.co.coen" % "capsulecrm-java" % "[1.2,)"

libraryDependencies += "org.apache.camel" % "camel-core" % "2.11.4"

libraryDependencies += "org.apache.camel" % "camel-csv" % "2.11.4"

libraryDependencies += "org.apache.camel" % "camel-bindy" % "2.11.4"

libraryDependencies += "org.geotools" % "gt-main" % "10.5" excludeAll ExclusionRule(organization = "javax.media")

libraryDependencies += "org.geotools" % "gt-epsg-hsql" % "10.5" excludeAll ExclusionRule(organization = "javax.media")

play.Project.playScalaSettings

net.virtualvoid.sbt.graph.Plugin.graphSettings

libraryDependencies ~= { _ map {
  case m if m.organization == "org.apache.httpcomponents" =>
    m.exclude("commons-logging", "commons-logging")
  case m if m.organization == "com.typesafe.play" =>
    m.exclude("commons-logging", "commons-logging").exclude("org.springframework", "spring-aop").exclude("org.springframework", "spring-context").exclude("org.springframework", "spring-beans").exclude("org.springframework", "spring-core").exclude("org.springframework", "spring-expression").exclude("org.springframework", "spring-asm")
  case m => m
}}
