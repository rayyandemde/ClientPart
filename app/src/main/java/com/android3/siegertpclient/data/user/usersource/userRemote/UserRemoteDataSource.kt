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
        if (!response.isSuccessful) {

            //TOdo implement error code
        }
        val uResp =  response.body()
        return User(uResp.userId, uResp.username, uResp.forename, uResp.surname, uResp.notificationList,
            uResp.teamList, uResp.tournamentList)

    }

    fun getUserById (userId : String) : User {
        val userCall = userService.getUserById(userId, TokenUtil.getBearerToken())
        val response = userCall.execute()
        if (!response.isSuccessful) {

            //TOdo implement error code
        }
        val uResp =  response.body()
        return User(uResp.userId, uResp.username, uResp.forename, uResp.surname, uResp.notificationList,
            uResp.teamList, uResp.tournamentList)
    }

    fun getUserByUsername (username : String) : User {
        val userCall = userService.getUserByUsername(username, TokenUtil.getBearerToken())
        val response = userCall.execute()
        if (!response.isSuccessful) {

            //TOdo implement error code
        }
        val uResp =  response.body()
        return User(uResp.userId, uResp.username, uResp.forename, uResp.surname, uResp.notificationList,
            uResp.teamList, uResp.tournamentList)
    }

    fun getUsersTournaments (username: String) : TournamentList {
        val userCall = userService.getUsersTournaments(username, TokenUtil.getBearerToken())
        val response = userCall.execute()
        if (!response.isSuccessful) {

            //TOdo implement error code
        }
        return response.body()
    }

    fun getUsersTeams (username: String) : TeamList {
        val userCall = userService.getUserTeams(username, TokenUtil.getBearerToken())
        val response = userCall.execute()
        if (!response.isSuccessful) {

            //TOdo implement error code
        }
        return response.body()
    }

    fun getUsersInvitations (username: String) : Array<Invitation> {
        val userCall = userService.getUserInvitations(username, TokenUtil.getBearerToken())
        val response = userCall.execute()
        if (!response.isSuccessful) {

            //TOdo implement error code
        }
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