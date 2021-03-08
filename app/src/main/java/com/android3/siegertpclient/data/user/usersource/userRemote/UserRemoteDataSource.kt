package com.android3.siegertpclient.data.user.usersource.userRemote

import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.team.teamsource.teamLocal.Team
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.utils.RestClient
import com.android3.siegertpclient.utils.TokenUtil
import retrofit2.Response

class UserRemoteDataSource(private val userService: UserService) {

    private val runtimeError = "Response of Server was not successful"

    fun createNewUser (username: String, surname: String, firstName: String, userId : String) : User? {
        val user = hashMapOf<String, String>()
        user["surname"] = surname
        user["forename"] = firstName
        user["username"] = username
        user["userId"] = userId

        val userCall = userService.createNewUser(user, TokenUtil.getBearerToken())
        if (userCall.isCanceled) {
            throw RuntimeException(runtimeError)
        }
        val response = userCall.execute()
        return response.body()
    }

    fun getUserById (userId : String) : User? {
        val userCall = userService.getUserById(userId, TokenUtil.getBearerToken())
        val response = userCall.execute()
        if (!response.isSuccessful) {
            throw RuntimeException(runtimeError)
        }
        return response.body()
    }

    fun getUserByUsername (username : String) : User? {
        val userCall = userService.getUserByUsername(username, TokenUtil.getBearerToken())
        val response = userCall.execute()
        if (!response.isSuccessful) {
            throw RuntimeException(runtimeError)
        }
        return response.body()
    }

    fun getUsersTournaments (username: String) : List<Tournament>? {
        val userCall = userService.getUsersTournaments(username, TokenUtil.getBearerToken())
        val response = userCall.execute()
        if (!response.isSuccessful) {
            throw RuntimeException(runtimeError)
        }
        return response.body()
    }

    fun getUsersTeams (username: String) : List<Team>? {
        val userCall = userService.getUserTeams(username, TokenUtil.getBearerToken())
        val response = userCall.execute()
        if (!response.isSuccessful) {
            throw RuntimeException(runtimeError)
        }
        return response.body()
    }

    fun getUsersInvitations (username: String) : List<Invitation>? {
        val userCall = userService.getUserInvitations(username, TokenUtil.getBearerToken())
        val response = userCall.execute()
        if (!response.isSuccessful) {
            throw RuntimeException(runtimeError)
        }
        return response.body()
    }

    fun updateUserDetail (oldUsername: String, newUsername : String, forename : String, surname : String) : User? {
        val userCall = userService.updateUserDetails(oldUsername,newUsername,forename,surname,
            TokenUtil.getBearerToken())
        val response = userCall.execute()
        val uResp =  response.body()
        if (!response.isSuccessful) {
            throw RuntimeException(runtimeError)
        }
        return uResp
    }
}