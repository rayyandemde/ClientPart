package com.android3.siegertpclient.data.user.usersource.userRemote

import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.user.TeamList
import com.android3.siegertpclient.data.user.TournamentList
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.data.userdummy.usersource.userRemote.UserServiceDummy
import com.android3.siegertpclient.utils.TokenUtil

class UserRemoteDataSource (private val userService : UserService) {

    fun createNewUser (username: String, surname: String, firstName: String, userId : String) : User {
        val user = hashMapOf<String, String>()
        user["surname"] = surname
        user["forename"] = firstName
        user["username"] = username
        user["userId"] = userId
        val userCall = userService.createNewUser(user, TokenUtil.getBearerToken())
        val response = userCall.execute()
        val uResp =  response.body()
        return User(uResp.userId, uResp.username, uResp.forename, uResp.surname, uResp.notificationList,
            uResp.teamList, uResp.tournamentList)

    }

    fun getUserById (userId : String) : User {
        val response = userService.getUserById(userId, TokenUtil.getBearerToken())
        if (response.isSuccessful) {
            //val user = response.body()
            //TOdo implement error code
        }
        return response.body()
    }

    fun getUserByUsername (username : String) : User {
        val response = userService.getUserByUsername(username, TokenUtil.getBearerToken())
        if (response.isSuccessful) {
            //val user = response.body()
            //TOdo implement error code
        }
        return response.body()
    }

    fun getUsersTournaments (username: String) : TournamentList {
        val response = userService.getUsersTournaments(username, TokenUtil.getBearerToken())
        return response.body()
    }

    fun getUsersTeams (username: String) : TeamList {
        val response = userService.getUserTeams(username, TokenUtil.getBearerToken())
        return response.body()
    }

    fun getUsersInvitations (username: String) : Array<Invitation> {
        val response = userService.getUserInvitations(username, TokenUtil.getBearerToken())
        return response.body()
    }

    fun updateUserDetail (oldUsername: String, newUsername : String, forename : String, surname : String) : User {
        val userCall = userService.updateUserDetails(oldUsername,newUsername,forename,surname,
            TokenUtil.getBearerToken())
        val response = userCall.execute()
        val uResp =  response.body()
        return User(uResp.userId, uResp.username, uResp.forename, uResp.surname, uResp.notificationList,
            uResp.teamList, uResp.tournamentList)
    }

}