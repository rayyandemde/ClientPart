package com.android3.siegertpclient.data.user.usersource

import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.user.NotificationList
import com.android3.siegertpclient.data.user.TeamList
import com.android3.siegertpclient.data.user.TournamentList
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.data.user.usersource.userLocal.UserLocalDataSource
import com.android3.siegertpclient.data.user.usersource.userRemote.UserRemoteDataSource
import com.android3.siegertpclient.utils.RestClient
import kotlin.coroutines.Continuation

class UserRepo() : IUserDataSource {

    private val restClient = RestClient()
    private val userService = restClient.getUserService()

    var userRemote = UserRemoteDataSource(userService)
    var userLocal = UserLocalDataSource()

    suspend fun createNewUser(username: String, eMail: String, firstName: String, surname: String,
                              password: String, createdNewUserId : String) : User {
        //creating new empty Lists for new User
        val notificationList = NotificationList()
        val teamList = TeamList()
        val tournamentList = TournamentList()
        val newUser = User(createdNewUserId, username, firstName, surname, eMail, password,
            notificationList, teamList, tournamentList)
        saveUserLocally(newUser)
        return userRemote.createNewUser(username, surname, firstName, createdNewUserId)
    }

    fun saveUserLocally(user : User) {
        userLocal.saveUser(user)
    }

    suspend fun getUserById (userId : String, token : String) : User {
        return userRemote.getUserById(userId, token)
    }

    suspend fun getUserByUsername (username : String, token : String) : User {
        return userRemote.getUserByUsername(username, token)
    }

    suspend fun getUsersTournaments (username: String, token : String) : TournamentList {
        return userRemote.getUsersTournaments(username, token)
    }

    suspend fun getUserTeams (username: String, token : String) : TeamList {
        return userRemote.getUsersTeams(username, token)
    }

    suspend fun getUsersInvitations (username: String, token : String) : Array<Invitation> {
        return userRemote.getUsersInvitations(username, token)
    }

    fun updateUserDetail (oldUsername : String, newUsername : String, firstName: String, surname: String, token : String) {
        userRemote.updateUserDetail(oldUsername, newUsername, firstName, surname, token)
    }

    fun check(firstName: String,surname: String,password: String,eMail: String) : Boolean {
        return userLocal.check(firstName,surname,password,eMail)
    }

}