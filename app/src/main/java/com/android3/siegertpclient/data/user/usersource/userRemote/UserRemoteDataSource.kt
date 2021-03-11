package com.android3.siegertpclient.data.user.usersource.userRemote

import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.team.teamsource.teamLocal.Team
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.utils.TokenUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRemoteDataSource(private val userService: UserService) {

    private val runtimeError = "Response of Server was not successful"

    fun createNewUser(username: String, surname: String, firstName: String, userId: String) : User? {
        val user = hashMapOf<String, String>()
        user["surname"] = surname
        user["forename"] = firstName
        user["username"] = username
        user["userId"] = userId

        val userCall = userService.createNewUser(user, TokenUtil.getBearerToken())
        val response = userCall.execute()

        userCall.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return response.body()
    }

    fun getUserById(userId: String) : User? {
        val userCall = userService.getUserById(userId, TokenUtil.getBearerToken())
        val response = userCall.execute()
        userCall.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return response.body()
    }

    fun getUserByUsername(username: String) : User? {
        val userCall = userService.getUserByUsername(username, TokenUtil.getBearerToken())
        val response = userCall.execute()
        userCall.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return response.body()
    }

    fun getUsersTournaments(username: String) : List<Tournament>? {
        val userCall = userService.getUsersTournaments(username, TokenUtil.getBearerToken())
        val response = userCall.execute()
        userCall.enqueue(object : Callback<List<Tournament>> {
            override fun onResponse(
                call: Call<List<Tournament>>,
                response: Response<List<Tournament>>
            ) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<List<Tournament>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return response.body()
    }

    fun getUsersTeams(username: String) : List<Team>? {
        val userCall = userService.getUserTeams(username, TokenUtil.getBearerToken())
        val response = userCall.execute()
        userCall.enqueue(object : Callback<List<Team>> {
            override fun onResponse(call: Call<List<Team>>, response: Response<List<Team>>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<List<Team>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return response.body()
    }

    fun getUsersInvitations(username: String) : List<Invitation>? {
        val userCall = userService.getUserInvitations(username, TokenUtil.getBearerToken())
        val response = userCall.execute()
        userCall.enqueue(object : Callback<List<Invitation>> {
            override fun onResponse(
                call: Call<List<Invitation>>,
                response: Response<List<Invitation>>
            ) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<List<Invitation>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return response.body()
    }

    fun updateUserDetail(
        oldUsername: String,
        newUsername: String,
        forename: String,
        surname: String
    ) : User? {
        val userCall = userService.updateUserDetails(
            oldUsername, newUsername, forename, surname,
            TokenUtil.getBearerToken()
        )
        val response = userCall.execute()
        userCall.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
        return response.body()
    }
}
