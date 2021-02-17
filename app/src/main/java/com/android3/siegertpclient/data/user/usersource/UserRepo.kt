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

class UserRepo(override val userDao: UserDao?) : IUserDataSource {

    private val restClient = RestClient()
    private val userService = restClient.getUserService()

    var userRemote = UserRemoteDataSource(userService)
    var userLocal = UserLocalDataSource(userDao)

    private val ownUserId = "1"//TODO change for a method of UerLocalDataSource

    fun createNewUser(username: String, eMail: String, firstName: String, surname: String, password: String) : User {
        val notificationList = NotificationList()
        val teamList = TeamList()
        val tournamentList = TournamentList()
        val userId = userLocal.id
        //Todo implement getting new notification team and tournament list and correct id
        val newUser = User(userId, username, firstName, surname, eMail, password, notificationList, teamList, tournamentList)
        userLocal.saveUser(newUser)
        return userRemote.createNewUser(newUser)
    }

    fun getUserById (userId : String) : User {
        return userRemote.getUserById(userId, ownUserId)
    }

    fun getUserByUsername (username : String) : User {
        return userRemote.getUserByUsername(username, ownUserId)
    }

    fun getUsersTournaments (username: String) : TournamentList {
        //ownUserId = userLocal.getOwnUserId()
        return userRemote.getUsersTournaments(username, ownUserId)
    }

    fun getUserTeams (username: String) : TeamList {
        return userRemote.getUsersTeams(username, ownUserId)
    }

    fun getUsersInvitations (username: String) : Array<Invitation> {
        return userRemote.getUsersInvitations(username, ownUserId)
    }

    fun updateUserDetail (oldUsername : String, newUsername : String, firstName: String, surname: String) {
        userRemote.updateUserDetail(oldUsername, newUsername, firstName, surname, ownUserId)
    }

    fun check(firstName: String,surname: String,password: String,eMail: String) : Boolean {
        return userLocal.check(firstName,surname,password,eMail)
    }


}