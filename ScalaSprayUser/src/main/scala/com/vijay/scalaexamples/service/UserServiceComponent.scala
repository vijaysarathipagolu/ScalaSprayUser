package com.vijay.scalaexamples.service

import com.vijay.scalaexamples.domain.{User, UserDetails}

/**
  * Created by vsarathipagolu on 7/29/16.
  */

trait UserServiceComponent {

val userService:UserService

  trait UserService {

    def createUser(user:User): User

    def getUserDetails(id :Int):UserDetails

    def deleteUser(id:Int): Boolean

    def getAllUsers():Array[UserDetails]

    def updateUser(id:Int, user: User): Unit

  }

}
