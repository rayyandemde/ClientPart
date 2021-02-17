package com.android3.siegertpclient.data.user.usersource.userRemote

import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.user.TeamList
import com.android3.siegertpclient.data.user.TournamentList
import com.android3.siegertpclient.data.user.User

class UserRemoteDataSource (private val userService : UserService) {


    fun createNewUser (user: User) : User {
        val response = userService.createNewUser(user)
        return response.body()
    }

    fun getUserById (userId : String, ownUserId : String) : User {
        val response = userService.getUserById(userId, ownUserId)
        if (response.isSuccessful) {
             //val user = response.body()
            //TOdo implement error code
        }
        return response.body()
    }

    fun getUserByUsername (username : String, ownUserId : String) : User {
        val response = userService.getUserByUsername(username, ownUserId)
        if (response.isSuccessful) {
            //val user = response.body()
            //TOdo implement error code
        }
        return response.body()
    }

    fun getUsersTournaments (username: String, ownUserId : String) : TournamentList {
        val response = userService.getUsersTournaments(username, ownUserId)
        return response.body()
    }

    fun getUsersTeams (username: String, ownUserId : String) : TeamList {
        val response = userService.getUserTeams(username, ownUserId)
        return response.body()
    }

    fun getUsersInvitations (username: String, ownUserId : String) : Array<Invitation> {
        val response = userService.getUserInvitations(username, ownUserId)
        return response.body()
    }

    fun updateUserDetail (oldUsername: String, newUsername : String, forename : String, surname : String, ownUserId : String) {
        val response = userService.updateUserDetails(oldUsername,newUsername,forename,surname, ownUserId)
    }

}