package com.vijay.scalaexamples

import akka.actor.ActorSystem
import com.vijay.scalaexamples.service.UserServiceComponentImpl

/**
  * Created by vsarathipagolu on 8/5/16.
  */
object ComponentRegistry extends UserServiceComponentImpl {

  val actorSystem = ActorSystem("user")
}
