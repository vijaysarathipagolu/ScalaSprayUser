package com.vijay.scalaexamples.config

import com.typesafe.config.ConfigFactory
import util.Try
/**
  * Created by vsarathipagolu on 7/27/16.
  */
trait Configuration {
  val config = ConfigFactory.load("application")

  val dbConfig = config.getConfig("db.default")

  /** Host name/address to start service on. */
  lazy val serviceHost = Try(config.getString("service.host")).getOrElse("localhost")

  /** Port to start service on. */
  lazy val servicePort = Try(config.getInt("service.port")).getOrElse(8080)

  /** Database host name/address. */
  lazy val dbHost = Try(dbConfig.getString("host")).getOrElse("localhost")

  /** Database driver name */
  lazy val driverName = Try(dbConfig.getString("driver")).getOrElse("localhost")

  /** Database host port number. */
  lazy val dbPort = Try(dbConfig.getInt("port")).getOrElse(3306)

  /** Service database name. */
  lazy val dbName = Try(dbConfig.getString("name")).getOrElse("rest")

  /** User name used to access database. */
  lazy val dbUser = Try(dbConfig.getString("user")).toOption.orNull

  /** Password for specified user and database. */
  lazy val dbPassword = Try(dbConfig.getString("password")).toOption.orNull
}
