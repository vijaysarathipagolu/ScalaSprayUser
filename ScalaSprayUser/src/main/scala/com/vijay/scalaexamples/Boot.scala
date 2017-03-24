package com.vijay.scalaexamples

import akka.actor.{ActorSystem, Props}
import com.vijay.scalaexamples.config.Configuration
import com.vijay.scalaexamples.rest.ConsoleRestController
import scalikejdbc.{ConnectionPoolFactoryRepository, DB}
import spray.servlet.WebBoot
import com.vijay.scalaexamples.config.C3P0ConnectionPoolFactory
import scalikejdbc.config.DBs
import akka.io.IO
import spray.can.Http


/**
  * Created by vsarathipagolu on 7/29/16.
  */
object Boot extends App with Configuration {

  implicit val system = ComponentRegistry.actorSystem

 lazy val serviceActor = system.actorOf(Props[ConsoleRestController],"spray-sample-service")

  ConnectionPoolFactoryRepository.add("c3p0", C3P0ConnectionPoolFactory)

  //DBs.setup('dbName)

  DBs.setupAll()

  IO(Http) ! Http.Bind(serviceActor, interface = "localhost", port = 5555)

}
