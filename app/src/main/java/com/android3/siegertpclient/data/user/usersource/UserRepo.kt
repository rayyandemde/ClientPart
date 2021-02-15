package com.android3.siegertpclient.data.user.usersource

import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.user.NotificationList
import com.android3.siegertpclient.data.user.TeamList
import com.android3.siegertpclient.data.user.TournamentList
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.data.user.usersource.userRemote.UserRemoteDataSource
import com.android3.siegertpclient.utils.RestClient


class UserRepo : IUserDataSource {

    private val restClient = RestClient()
    private val userService = restClient.getUserService()

    var userRemote = UserRemoteDataSource(userService)
    //var userLocal

    fun createNewUser(username: String, eMail: String, firstName: String, surname: String, password: String) : User {
        val notificationList = NotificationList()
        val teamList = TeamList()
        val tournamentList = TournamentList()
        val userId = 1
        //Todo implement getting new notification team and tournament list and correct id
        val newUser = User(userId, username, firstName, surname, eMail, password, notificationList, teamList, tournamentList)
        return userRemote.createNewUser(newUser)
    }

    fun getUserById (userId : String) : User {
        return userRemote.getUserById(userId)
    }

    fun getUserByUsername (username : String) : User {
        return userRemote.getUserByUsername(username)
    }

    fun getUsersTournaments (username: String) : TournamentList {
        val user = getUserByUsername(username)
        return userRemote.getUsersTournaments(username)
    }

    fun getUserTeams (username: String) : TeamList {
        return userRemote.getUsersTeams(username)
    }

    fun getUsersInvitations (username: String) : Array<Invitation> {
        return userRemote.getUsersInvitations(username)
    }

    fun updateUserDetail (oldUsername : String, newUsername : String, firstName: String, surname: String) {
        userRemote.updateUserDetail(oldUsername, newUsername, firstName, surname)
    }

    fun handleInvitationAcceptation(username: String, invitationID : String) {
        userRemote.handleInvitationAcceptation(username, invitationID)
    }

}