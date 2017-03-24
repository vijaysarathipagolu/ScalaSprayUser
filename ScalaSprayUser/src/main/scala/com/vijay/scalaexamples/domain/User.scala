package com.vijay.scalaexamples.domain

import scalikejdbc._
import spray.httpx.SprayJsonSupport
import spray.json._

import scala._


/**
  * Created by vsarathipagolu on 7/29/16.
  */
case class User(userid: Option[Int],
                firstname: String,
                lastname: String,
                gender: String){

  // overriding toString for logging
  override def toString() : String = {
    s"userid=$userid, " +
      s"firstname=$firstname, lastName=$lastname, gender=$gender"
  }
}

case class UserDetails(userid: Option[Int],
                firstname: String,
                lastname: String,
                gender: String){

  // overriding toString for logging
  override def toString() : String = {
    s"userid=$userid, " +
      s"firstname=$firstname, lastName=$lastname, gender=$gender"
  }
}


object UserJsonSupport extends DefaultJsonProtocol with SprayJsonSupport {
  implicit val userFormat = jsonFormat4(User)
}


object UserDetails extends SQLSyntaxSupport[UserDetails] {
  override val tableName = "user"
  //override val useSnakeCaseColumnName = false
  def apply(user: ResultName[UserDetails])(rs: WrappedResultSet): UserDetails = new UserDetails(

    userid = rs.intOpt(user.userid),
    firstname = rs.string(user.firstname),
    lastname = rs.string(user.lastname),
    gender = rs.string(user.gender)
  )

}

