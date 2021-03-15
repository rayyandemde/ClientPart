package com.android3.siegertpclient.data.user.usersource.userRemote

import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.utils.RestClient2
import retrofit2.Response

class UserRemoteDataSource {

    suspend fun createNewUser(
        username: String,
        surname: String,
        forename: String,
        userId: String,
        token: String
    ): Response<User> {
        val user = hashMapOf<String, String>()
        user["username"] = username
        user["surname"] = surname
        user["forename"] = forename
        user["userId"] = userId
        return RestClient2.userService.createNewUser(user, token)
    }

    //getUserById alternative, not used at current implementation
    suspend fun getUserById(userId: String, token: String): Response<User> {
        return RestClient2.userService.getUserById(userId, token)
    }

    suspend fun getUserByUsername(username: String, token: String): Response<User> {
        return RestClient2.userService.getUserByUsername(username, token)
    }

    suspend fun getUsersTournaments(username: String, token: String): Response<List<Tournament>> {
        return RestClient2.userService.getUsersTournaments(username, token)
    }

    suspend fun getUsersTeams(username: String, token: String): Response<List<Team>> {
        return RestClient2.userService.getUserTeams(username, token)
    }

    suspend fun getUsersInvitations(username: String, token: String): Response<List<Invitation>> {
        return RestClient2.userService.getUserInvitations(username, token)
    }

    suspend fun updateUserDetail(
        oldUsername: String,
        newUsername: String,
        surname: String,
        forename: String,
        token: String
    ): Response<User> {
        val newUser = hashMapOf<String, String>()
        newUser["username"] = newUsername
        newUser["surname"] = surname
        newUser["forename"] = forename
        return RestClient2.userService.updateUserDetails(oldUsername, newUser, token)
    }
}