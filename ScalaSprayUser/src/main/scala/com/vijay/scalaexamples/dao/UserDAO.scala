package com.vijay.scalaexamples.dao


import com.vijay.scalaexamples.domain.{User, UserDetails}
import scalikejdbc._

/**
  * Created by vsarathipagolu on 7/29/16.
  */
object UserDAO {


  def createUser(user:User) (implicit session: DBSession = AutoSession) : User = {

    println("in dao create user ---- -- >" + user.lastname)
    withSQL{
      insert.into(UserDetails).values(user.userid,user.firstname,user.lastname,user.gender)
    }.update().apply()
  user
  }

 def getUserDetails(id :Int) (implicit session: DBSession = AutoSession):UserDetails = {

   println("in dao getUserDetails method ---- -- >" + id)
val ud = UserDetails.syntax("ud")
 val userDetails =withSQL{
    select.from(UserDetails as ud).where.eq(ud.userid,id)
  }.map(UserDetails(ud.resultName)).single().apply()
   //val m = UserDetails.syntax("m")
   //val values = sql"SELECT * FROM user where id =${id}".map(rs => UserDetails(rs)).list().apply()
userDetails match {
  case Some(x) => x
  case  _ => throw new NullPointerException
}
 }


 def getAllUsers() (implicit session: DBSession = AutoSession):Array[UserDetails]={

   val ud = UserDetails.syntax("ud")
   val usersList = withSQL {
     select.from(UserDetails as ud)
   }.map(UserDetails(ud.resultName)).list().apply()

   println("all users in dao -- >" +usersList)
   usersList.toArray
 }


 def updateUser(id:Int, user: User)  (implicit session: DBSession = AutoSession): Unit= {

    val ud = UserDetails.syntax("ud")
   val updateUser = withSQL {
      update(UserDetails as ud).set(
        ud.userid -> user.userid,
        ud.firstname -> user.firstname,
        ud.lastname -> user.lastname,
        ud.gender -> user.gender
      ).where.eq(ud.userid, user.userid)
    }.update().apply()

    println(updateUser)

    updateUser match {
      case x if x == 1 => println("The user details updated successfully ! :)")
      case _ => println("NO user found with the given details ! :( ")
    }

  }

  def deleteUser(id:Int) (implicit session: DBSession = AutoSession): Boolean = {

    val ud = UserDetails.syntax("ud")
  val uid = id.toString()
   val value = withSQL{
      delete.from(UserDetails).where.eq(UserDetails.column.userid,uid)
    }.update().apply()

    value match {
      case x if x ==1 => true
      case _ => false
    }

  }
}
