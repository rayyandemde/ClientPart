package com.android3.siegertpclient.data.user.usersource.userRemote

import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.user.TeamList
import com.android3.siegertpclient.data.user.TournamentList
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.data.userdummy.usersource.userRemote.UserServiceDummy
import com.android3.siegertpclient.utils.TokenUtil
import retrofit2.Response
import kotlin.RuntimeException

class UserRemoteDataSource (private val userService : UserService) {

    private val runtimeError = "Response of Server was not successful"

    private fun convertURespToUser (uResp : UserResponse) : User {
        return User(uResp.userId, uResp.username, uResp.forename, uResp.surname, uResp.notificationList,
            uResp.teamList, uResp.tournamentList)
    }

    fun createNewUser (username: String, surname: String, firstName: String, userId : String) : User {
        val user = hashMapOf<String, String>()
        user["surname"] = surname
        user["forename"] = firstName
        user["username"] = username
        user["userId"] = userId
        val userCall = userService.createNewUser(user, TokenUtil.getBearerToken())
        if (userCall.isCanceled) {
            throw RuntimeException(runtimeError)
        }
        var response : Response<UserResponse>? = null
        Thread(Runnable {
            response = userCall.execute()
        }).start()
//        val response = userCall.execute()
        if (!response?.isSuccessful!!) {
            throw RuntimeException(runtimeError)
        }
        val uResp = response?.body()
        return convertURespToUser(uResp!!)

    }

    fun getUserById (userId : String) : User {
        val userCall = userService.getUserById(userId, TokenUtil.getBearerToken())
        val response = userCall.execute()
        if (!response.isSuccessful) {
            throw RuntimeException(runtimeError)
        }
        val uResp =  response.body()
        return convertURespToUser(uResp)
    }

    fun getUserByUsername (username : String) : User {
        val userCall = userService.getUserByUsername(username, TokenUtil.getBearerToken())
        val response = userCall.execute()
        if (!response.isSuccessful) {
            throw RuntimeException(runtimeError)
        }
        val uResp =  response.body()
        return convertURespToUser(uResp)
    }

    fun getUsersTournaments (username: String) : TournamentList {
        val userCall = userService.getUsersTournaments(username, TokenUtil.getBearerToken())
        val response = userCall.execute()
        if (!response.isSuccessful) {
            throw RuntimeException(runtimeError)
        }
        return response.body()
    }

    fun getUsersTeams (username: String) : TeamList {
        val userCall = userService.getUserTeams(username, TokenUtil.getBearerToken())
        val response = userCall.execute()
        if (!response.isSuccessful) {
            throw RuntimeException(runtimeError)
        }
        return response.body()
    }

    fun getUsersInvitations (username: String) : Array<Invitation> {
        val userCall = userService.getUserInvitations(username, TokenUtil.getBearerToken())
        val response = userCall.execute()
        if (!response.isSuccessful) {
            throw RuntimeException(runtimeError)
        }
        return response.body()
    }

    fun updateUserDetail (oldUsername: String, newUsername : String, forename : String, surname : String) : User {
        val userCall = userService.updateUserDetails(oldUsername,newUsername,forename,surname,
            TokenUtil.getBearerToken())
        val response = userCall.execute()
        val uResp =  response.body()
        if (!response.isSuccessful) {
            throw RuntimeException(runtimeError)
        }
        return convertURespToUser(uResp)
    }

}