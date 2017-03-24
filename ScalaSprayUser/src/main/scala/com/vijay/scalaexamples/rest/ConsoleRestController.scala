package com.vijay.scalaexamples.rest

import akka.actor.Actor
import akka.event.slf4j.SLF4JLogging
import spray.routing.HttpService

import scala.concurrent.ExecutionContext

/**
  * Created by vsarathipagolu on 7/29/16.
  */
class ConsoleRestController extends Actor with UserHttpService with HttpService{

  def actorRefFactory = context

  def ec: ExecutionContext = context.dispatcher

  def receive = {
    runRoute(userRoutes)
  }
}

