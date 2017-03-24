logLevel := Level.Warn
resolvers += Classpaths.typesafeResolver

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.12.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.0.0-M4")

addSbtPlugin("com.typesafe.sbt" % "sbt-multi-jvm" % "0.3.9")

addSbtPlugin("com.earldouglas" % "xsbt-web-plugin" % "2.1.0")

addSbtPlugin("org.scalikejdbc" %% "scalikejdbc-mapper-generator" % "2.4.2")


scalacOptions ++= Seq("-feature", "-deprecation")

