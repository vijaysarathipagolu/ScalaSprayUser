package com.vijay.scalaexamples.rest

import akka.actor.Actor
import akka.event.slf4j.SLF4JLogging
import java.text.{ParseException, SimpleDateFormat}

import com.vijay.scalaexamples.ComponentRegistry
import net.liftweb.json.Serialization._
import net.liftweb.json.{DateFormat, Formats}

import scala.Some
import spray.http._
import spray.httpx.unmarshalling._
import spray.routing._
import com.vijay.scalaexamples.domain.{Failure, User, UserDetails, UserJsonSupport}

import scala.concurrent.ExecutionContext

/**
  * Created by vsarathipagolu on 7/29/16.
  */
trait UserHttpService extends HttpService with SLF4JLogging {

  val userRoutes = putUserRoute ~ getUserRoute ~ postUserRoute ~ deleteUserRoute ~ getAllUserRoute

  //val userRoutes = postUserRoute ~ getUserRoute ~ putUserRoute

  implicit def ec: ExecutionContext

  import com.vijay.scalaexamples.domain.UserJsonSupport._

  protected def postUserRoute = {
    pathPrefix("scalasprayuser") {
      path("create") {
        post {
          entity(as[User]) { user =>
            respondWithMediaType(MediaTypes.`application/json`) {
              System.out.println("Welcome to create User microservice !")
              complete {
                ComponentRegistry.userService.createUser(user)
              }
            }
          }
        }

      }
    }
  }

  protected def getUserRoute = {
    pathPrefix("scalasprayuser") {
      path("get" / IntNumber) {
        userid =>
          get {
            complete {
              ComponentRegistry.userService.getUserDetails(userid).toString()
            }
          }

      }
    }
  }

  protected def putUserRoute = {
    pathPrefix("scalasprayuser") {
      path("update" / IntNumber) {
        userid => {
          put {
            entity(as[User]) { user => {
                complete {
                 val user2 = user.copy(userid = Some(userid))
                  ComponentRegistry.userService.updateUser(userid, user2).toString
                }
            }
            }
          }
        }
      }

    }
  }

  protected def deleteUserRoute ={
    pathPrefix("scalasprayuser") {
      path("delete" / IntNumber) { index => {
          delete {
            complete {
             ComponentRegistry.userService.deleteUser(index).toString()
            }
          }
        }
      }
    }
  }

  protected def getAllUserRoute = {
    pathPrefix("scalasprayuser") {
      path("get"/"all") {
        get {
          respondWithMediaType(MediaTypes.`application/json`) {
          complete {
          val userList = ComponentRegistry.userService.getAllUsers()
            userList.map(x => x.toString())
          }
        }
      }
      }
    }
  }

  /* protected def handleRequest(ctx: RequestContext, successCode: StatusCode = StatusCodes.OK)(action: => Either[Failure, _]) {
     action match {
       case Right(result: Object) =>
         ctx.complete(successCode, write(result))
       case Left(error: Failure) =>
         ctx.complete(error.getStatusCode, net.liftweb.json.Serialization.write(Map("error" -> error.message)))
       case _ =>
         ctx.complete(StatusCodes.InternalServerError)
     }
   }

   implicit val customRejectionHandler = RejectionHandler {
     case rejections => mapHttpResponse {
       response =>
         response.withEntity(HttpEntity(ContentType(MediaTypes.`application/json`),
           write(Map("error" -> response.entity.asString))))
     } {
       RejectionHandler.Default(rejections)
     }
   }*/
}
