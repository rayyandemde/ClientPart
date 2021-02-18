package com.android3.siegertpclient.data.userdummy.usersource

import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.userdummy.usersource.userRemote.UserService
import com.android3.siegertpclient.data.userdummy.NotificationList
import com.android3.siegertpclient.data.userdummy.TeamList
import com.android3.siegertpclient.data.userdummy.TournamentList
import com.android3.siegertpclient.data.userdummy.User
import com.android3.siegertpclient.data.userdummy.usersource.userLocal.UserDao
import com.android3.siegertpclient.data.userdummy.usersource.userLocal.UserLocalDataSource
import com.android3.siegertpclient.data.userdummy.usersource.userRemote.UserRemoteDataSource
import com.android3.siegertpclient.utils.OnlineChecker
import com.android3.siegertpclient.utils.RestClient
import retrofit2.Retrofit

class UserRepo() : IUserDataSource {

    private val restClient = RestClient()

    private val retrofit = Retrofit.Builder().baseUrl("https://our.server.com/").build()

    fun getUserService(): UserService {
        return retrofit.create(UserService::class.java)
    }

    private val userService = getUserService()
    private val oc = OnlineChecker()

    var userRemote = UserRemoteDataSource(userService)
    var userLocal = UserLocalDataSource()

    fun createNewUser(username: String, firstName: String, surname: String, createdNewUserId : String) : User {
        //creating new empty Lists for new User
        val notificationList = NotificationList()
        val teamList = TeamList()
        val tournamentList = TournamentList()
        val newUser = User(createdNewUserId, username, firstName, surname, notificationList, teamList, tournamentList)
        //userLocal.saveUser(newUser)
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