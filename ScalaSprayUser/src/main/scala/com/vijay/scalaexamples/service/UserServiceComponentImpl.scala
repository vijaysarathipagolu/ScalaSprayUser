package com.vijay.scalaexamples.service

/**
  * Created by vsarathipagolu on 7/29/16.
  */
import com.vijay.scalaexamples.domain.{User, UserDetails}
import akka.event.slf4j.SLF4JLogging
import com.vijay.scalaexamples.dao.UserDAO

trait UserServiceComponentImpl extends UserServiceComponent{

  val userService = new UserServiceImpl

    class UserServiceImpl extends UserService with SLF4JLogging {

    override def createUser(user:User): User={

      UserDAO.createUser(user)
    }

    override def getUserDetails(id:Int):UserDetails={
      println("in service component impl getUserDetails ");
      UserDAO.getUserDetails(id)
    }

      override def deleteUser(id:Int): Boolean ={
       UserDAO.deleteUser(id)
      }

      override def getAllUsers():Array[UserDetails] ={
        UserDAO.getAllUsers()
      }

      override def updateUser(id:Int,user:User):Unit={
        UserDAO.updateUser(id,user)
      }
  }

}
