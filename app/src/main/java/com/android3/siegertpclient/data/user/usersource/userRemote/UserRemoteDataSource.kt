package com.android3.siegertpclient.data.user.usersource.userRemote

import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.user.TeamList
import com.android3.siegertpclient.data.user.TournamentList
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.data.user.usersource.IUserDataSource

class UserRemoteDataSource (private val userService : UserService) : IUserDataSource {


    suspend fun createNewUser (username: String, surname: String, firstName: String, userId : String) : User {
        val response = userService.createNewUser(username, surname, firstName, userId)
        return response.body()
    }

    suspend fun getUserById (userId : String, ownUserId : String) : User {
        val response = userService.getUserById(userId, ownUserId)
        if (response.isSuccessful) {
             //val user = response.body()
            //TOdo implement error code
        }
        return response.body()
    }

    suspend fun getUserByUsername (username : String, ownUserId : String) : User {
        val response = userService.getUserByUsername(username, ownUserId)
        if (response.isSuccessful) {
            //val user = response.body()
            //TOdo implement error code
        }
        return response.body()
    }

    suspend fun getUsersTournaments (username: String, ownUserId : String) : TournamentList {
        val response = userService.getUsersTournaments(username, ownUserId)
        return response.body()
    }

    suspend fun getUsersTeams (username: String, ownUserId : String) : TeamList {
        val response = userService.getUserTeams(username, ownUserId)
        return response.body()
    }

    suspend fun getUsersInvitations (username: String, ownUserId : String) : Array<Invitation> {
        val response = userService.getUserInvitations(username, ownUserId)
        return response.body()
    }

    fun updateUserDetail (oldUsername: String, newUsername : String, forename : String, surname : String, ownUserId : String) {
        val response = userService.updateUserDetails(oldUsername,newUsername,forename,surname, ownUserId)
    }

}