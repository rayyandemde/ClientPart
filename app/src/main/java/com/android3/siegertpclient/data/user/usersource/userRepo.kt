package com.android3.siegertpclient.data.user.usersource

import com.android3.siegertpclient.data.user.NotificationList
import com.android3.siegertpclient.data.user.TeamList
import com.android3.siegertpclient.data.user.TournamentList
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.data.user.usersource.userRemote.userRemoteDataSource

class userRepo : IUserDataSource {

    var userRemote : userRemoteDataSource = userRemoteDataSource()
    //var userLocal

    fun createNewUser (username : String, eMail : String, firstName : String, surname : String, password : String) : User {
        val notificationList = NotificationList()
        val teamList = TeamList()
        val tournamentList = TournamentList()
        //Todo implement getting new notification team and tournament list
        return User(username, firstName, surname, eMail, password, notificationList, teamList, tournamentList)
    }
    /*
    fun getUserById (userId : String) : User {
        return userRemote.
    }

    fun getUserByUsername (username : String) : User {

    }*/

}