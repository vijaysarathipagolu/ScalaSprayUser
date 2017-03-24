name := "ScalaSprayUser"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "io.spray" %% "spray-can" % "1.3.3",
  "io.spray" %% "spray-servlet" % "1.3.1",
  "io.spray" %% "spray-routing" % "1.3.3",
  "com.typesafe.akka" %% "akka-actor" % "2.3.4",
  "com.typesafe.akka" %% "akka-slf4j" % "2.3.4",
  "com.typesafe.slick" %% "slick" % "2.1.0",
  "mysql" % "mysql-connector-java" % "5.1.25",
  "net.liftweb" %% "lift-json" % "2.6+",
  "ch.qos.logback" % "logback-classic" % "1.0.13",
  "org.scalikejdbc" %% "scalikejdbc"        % "2.3.5",
  "org.scalikejdbc" %% "scalikejdbc-config" % "2.3.5",
  "org.scalikejdbc" %% "scalikejdbc-test"   % "2.3.5"   % "test",
  "c3p0" % "c3p0" % "0.9.0.4",
  "com.wordnik" %  "swagger-annotations" % "1.3.10",
  "com.wordnik" % "swagger-core_2.11" % "1.3.12",
  "com.gettyimages" % "spray-swagger_2.11" % "0.5.1",
  "org.webjars" % "swagger-ui" % "2.2.0",
  "io.spray" %%  "spray-json" % "1.3.2",
  "javax.servlet" % "javax.servlet-api" % "3.0.1" % "provided"


)

enablePlugins(TomcatPlugin)

resolvers ++= Seq(
  "Spray repository" at "http://repo.spray.io",
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
)
