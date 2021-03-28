package com.android3.siegertpclient.data.user.usersource

import android.content.Context
import android.util.Log
import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.data.user.usersource.userRemote.UserRemoteDataSource
import com.android3.siegertpclient.utils.Constants.Companion.IS_LOGGED_IN
import com.android3.siegertpclient.utils.Constants.Companion.KEY_FORENAME
import com.android3.siegertpclient.utils.Constants.Companion.KEY_SURNAME
import com.android3.siegertpclient.utils.Constants.Companion.KEY_TOKEN
import com.android3.siegertpclient.utils.Constants.Companion.KEY_USERNAME
import com.android3.siegertpclient.utils.Constants.Companion.KEY_USER_ID
import com.android3.siegertpclient.utils.LocalCache
import com.android3.siegertpclient.utils.PreferencesProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

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
            localData.putCurrentUser(response.body()!!)
            localData.putString(KEY_USERNAME, response.body()!!.username)
            localData.putString(KEY_USER_ID, userId)
            localData.putString(KEY_FORENAME, forename)
            localData.putString(KEY_SURNAME, surname)
            localData.putString(KEY_TOKEN, token)
            localData.putBoolean(IS_LOGGED_IN, true)
            return response.body()!!
        }
        return null
    }

    suspend fun getUserById(userId: String, token: String): User? {
        val response = userRemoteDataSource.getUserById(userId, token)
        if (response.isSuccessful) {
            localData.putCurrentUser(response.body()!!)
            localData.putString(KEY_USERNAME, response.body()!!.username)
            localData.putString(KEY_USER_ID, userId)
            localData.putString(KEY_FORENAME, response.body()!!.forename)
            localData.putString(KEY_SURNAME, response.body()!!.surname)
            localData.putString(KEY_TOKEN, token)
            localData.putBoolean(IS_LOGGED_IN, true)
            return response.body()!!
        }
        return null
    }

    //getUserById alternative, not used at current implementation
    suspend fun getUserByUsername(username: String, token: String): User? {
        val response = userRemoteDataSource.getUserByUsername(username, token)
        if (response.isSuccessful) {
            localData.putCurrentUser(response.body()!!)
            localData.putString(KEY_USERNAME, username)
            localData.putString(KEY_USER_ID, response.body()!!.userId)
            localData.putString(KEY_TOKEN, token)
            localData.putBoolean(IS_LOGGED_IN, true)
            return response.body()!!
        }
        return null
    }

    suspend fun getUsersTournaments(): List<Tournament>? {
        val response = userRemoteDataSource.getUsersTournaments(LocalCache.getCurrentUsername(context)!!, LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            localData.putCurrentTournamentList(response.body()!!)
            return response.body()!!
        }
        return null
    }

    suspend fun getUserTeams(): List<Team>? {
        val response = userRemoteDataSource.getUsersTeams(LocalCache.getCurrentUsername(context)!!, LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            localData.putCurrentTeamList(response.body()!!)
            return response.body()!!
        }
        return null
    }

    suspend fun getUsersInvitations(): List<Invitation>? {
        val response = userRemoteDataSource.getUsersInvitations(LocalCache.getCurrentUsername(context)!!, LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            localData.putCurrentInvitationList(response.body()!!)
            return response.body()!!
        }
        return null
    }

    suspend fun updateUserDetail(
        newUsername: String, surname: String,
        forename: String
    ): User? {
        val response = userRemoteDataSource.updateUserDetail(LocalCache.getCurrentUsername(context)!!, newUsername, surname, forename, LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            localData.putCurrentUser(response.body()!!)
            localData.putString(KEY_USERNAME, newUsername)
            localData.putString(KEY_FORENAME, forename)
            localData.putString(KEY_SURNAME, surname)
            return response.body()!!
        }
        return null
    }

    fun checkUserLoggedIn() : Boolean {
        return localData.getBoolean(IS_LOGGED_IN)
    }

    fun getCurrentUser() : User? {
        return localData.getCurrentUser()
    }

    fun getCurrentUserList() : List<User> {
        return localData.getCurrentUserList()
    }
}