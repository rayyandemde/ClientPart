package com.android3.siegertpclient.data.user.usersource.userRemote

import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.user.TeamList
import com.android3.siegertpclient.data.user.TournamentList
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.data.user.usersource.IUserDataSource
import javax.inject.Inject

class UserRemoteDataSource (private val userService : UserService) {


    fun createNewUser (user: User) : User {
        val response = userService.createNewUser(user)
        return response.body()
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

    fun getUsersTournaments (username: String) : TournamentList {
        val response = userService.getUsersTournaments(username)
        return response.body()
    }

    fun getUsersTeams (username: String) : TeamList {
        val response = userService.getUserTeams(username)
        return response.body()
    }

    fun getUsersInvitations (username: String) : Array<Invitation> {
        val response = userService.getUserInvitations(username)
        return response.body()
    }

    fun updateUserDetail (oldUsername: String, newUsername : String, forname : String, surname : String) {
        val response = userService.updateUserDetails(oldUsername,newUsername,forname,surname)
    }

    fun handleInvitationAcceptation (username: String,invitationId : String) {
        val response = userService.handleInvitationAcceptation(username, invitationId)
    }

}