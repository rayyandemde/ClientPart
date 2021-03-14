package com.android3.siegertpclient.data.user.usersource

import android.content.Context
import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.team.teamsource.teamLocal.Team
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.data.user.usersource.userRemote.UserRemoteDataSource
import com.android3.siegertpclient.ui.dummyretrofit.util.Constants.Companion.KEY_TOKEN
import com.android3.siegertpclient.ui.dummyretrofit.util.Constants.Companion.KEY_USER
import com.android3.siegertpclient.ui.dummyretrofit.util.Constants.Companion.KEY_USERNAME
import com.android3.siegertpclient.ui.dummyretrofit.util.Constants.Companion.KEY_USER_ID
import com.android3.siegertpclient.utils.PreferencesProvider

import retrofit2.Response

class UserRepo(private val context: Context) {

    private val userRemoteDataSource = UserRemoteDataSource()
    private var localData = PreferencesProvider(context)

    suspend fun createNewUser(
        username: String,
        forename: String,
        surname: String,
        userId: String,
        token: String
    ): User? {
        val response =
            userRemoteDataSource.createNewUser(username, surname, forename, userId, token)
        if (response.isSuccessful) {
            localData.putUser(response.body()!!)
            localData.putString(KEY_USERNAME, response.body()!!.username)
            localData.putString(KEY_USER_ID, userId)
            localData.putString(KEY_TOKEN, token)
            return response.body()!!
        }
        return null
    }

    suspend fun getUserById(userId: String, token: String): User? {
        val response = userRemoteDataSource.getUserById(userId, token)
        if (response.isSuccessful) {
            localData.putUser(response.body()!!)
            localData.putString(KEY_USERNAME, response.body()!!.username)
            localData.putString(KEY_USER_ID, userId)
            localData.putString(KEY_TOKEN, token)
            return response.body()!!
        }
        return null
    }

    suspend fun getUserByUsername(username: String, token: String): Response<User> {
        return userRemoteDataSource.getUserByUsername(username, token)
    }

    suspend fun getUsersTournaments(username: String, token: String): Response<List<Tournament>> {
        return userRemoteDataSource.getUsersTournaments(username, token)
    }

    suspend fun getUserTeams(username: String, token: String): Response<List<Team>> {
        return userRemoteDataSource.getUsersTeams(username, token)
    }

    suspend fun getUsersInvitations(username: String, token: String): Response<List<Invitation>> {
        return userRemoteDataSource.getUsersInvitations(username, token)
    }

    suspend fun updateUserDetail(
        oldUsername: String, newUsername: String, newForename: String,
        newSurname: String, token: String
    ): Response<User> {
        return userRemoteDataSource.updateUserDetail(
            oldUsername,
            newUsername,
            newForename,
            newSurname,
            token
        )
    }

    suspend fun getUserLocal(): User? {
        return localData.getUser(KEY_USER)
    }
}