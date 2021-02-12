package com.android3.siegertpclient.data.user.usersource.userRemote

import com.android3.siegertpclient.data.user.NotificationList
import com.android3.siegertpclient.data.user.TeamList
import com.android3.siegertpclient.data.user.TournamentList
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.data.user.usersource.IUserDataSource

class userRemoteDataSource (private val userService : UserService) : IUserDataSource {

    fun createNewUser (username : String, eMail : String, firstName : String, surname : String, password : String) : User {

        val notificationList = NotificationList()
        val teamList = TeamList()
        val tournamentList = TournamentList()
        //Todo implement getting new notification team and tournament list
        return User(username, firstName, surname, eMail, password, notificationList, teamList, tournamentList)
    }

    fun getUserById (userId : String) : User {
        val response = userService.getUserById(userId)
        if (response.isSuccessful) {
             //val user = response.body()
            //TOdo implement error code
        }
        return response.body()
    }

    fun getUserByUsername (username : String) : User {
        val response = userService.getUserByUsername(username)
        if (response.isSuccessful) {
            //val user = response.body()
            //TOdo implement error code
        }
        return response.body()
    }

}