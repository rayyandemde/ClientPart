package com.android3.siegertpclient.data.user.usersource

import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.user.NotificationList
import com.android3.siegertpclient.data.user.TeamList
import com.android3.siegertpclient.data.user.TournamentList
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.data.user.usersource.userLocal.UserDao
import com.android3.siegertpclient.data.user.usersource.userLocal.UserLocalDataSource
import com.android3.siegertpclient.data.user.usersource.userRemote.UserRemoteDataSource
import com.android3.siegertpclient.utils.RestClient

class UserRepo() : IUserDataSource {

    private val restClient = RestClient()
    private val userService = restClient.getUserService()

    var userRemote = UserRemoteDataSource(userService)
    var userLocal = UserLocalDataSource()

    fun createNewUser(username: String, eMail: String, firstName: String, surname: String,
                      password: String, createdNewUserId : String) : User {
        //creating new empty Lists for new User
        val notificationList = NotificationList()
        val teamList = TeamList()
        val tournamentList = TournamentList()
        val newUser = User(createdNewUserId, username, firstName, surname, eMail, password,
            notificationList, teamList, tournamentList)
        userLocal.saveUser(newUser)
        return userRemote.createNewUser(username, surname, firstName, createdNewUserId)
    }

    fun getUserById (userId : String, token : String) : User {
        return userRemote.getUserById(userId, token)
    }

    fun getUserByUsername (username : String, token : String) : User {
        return userRemote.getUserByUsername(username, token)
    }

    fun getUsersTournaments (username: String, token : String) : TournamentList {
        return userRemote.getUsersTournaments(username, token)
    }

    fun getUserTeams (username: String, token : String) : TeamList {
        return userRemote.getUsersTeams(username, token)
    }

    fun getUsersInvitations (username: String, token : String) : Array<Invitation> {
        return userRemote.getUsersInvitations(username, token)
    }

    fun updateUserDetail (oldUsername : String, newUsername : String, firstName: String, surname: String, token : String) {
        userRemote.updateUserDetail(oldUsername, newUsername, firstName, surname, token)
    }

    fun check(firstName: String,surname: String,password: String,eMail: String) : Boolean {
        return userLocal.check(firstName,surname,password,eMail)
    }


}