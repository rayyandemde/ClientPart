package com.android3.siegertpclient.data.user.usersource

import android.content.Context
import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.data.user.usersource.userRemote.UserRemoteDataSource
import com.android3.siegertpclient.utils.Constants.Companion.IS_LOGGED_IN
import com.android3.siegertpclient.utils.Constants.Companion.KEY_TOKEN
import com.android3.siegertpclient.utils.Constants.Companion.KEY_USERNAME
import com.android3.siegertpclient.utils.Constants.Companion.KEY_USER_ID
import com.android3.siegertpclient.utils.PreferencesProvider
import com.android3.siegertpclient.utils.commonlocalgetter.Token
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

    suspend fun getUsersTournaments(username: String, token: String): Response<List<Tournament>> {
        return userRemoteDataSource.getUsersTournaments(username, token)
    }

    suspend fun getUserTeams(): List<Team>? {
        val response = userRemoteDataSource.getUsersTeams(localData.getString(KEY_USERNAME)!!, Token.getBearerToken(context)!!)
        if (response.isSuccessful) {
            localData.putCurrentUserTeams(response.body()!!)
            return response.body()!!
        }
        return null
    }

    suspend fun getUsersInvitations(username: String, token: String): Response<List<Invitation>> {
        return userRemoteDataSource.getUsersInvitations(username, token)
    }

    suspend fun updateUserDetail(
        oldUsername: String, newUsername: String, surname: String,
        forename: String, token: String
    ): User? {
        val response = userRemoteDataSource.updateUserDetail(oldUsername, newUsername, surname, forename, token)
        if (response.isSuccessful) {
            localData.putCurrentUser(response.body()!!)
            localData.putString(KEY_USERNAME, newUsername)
            localData.putString(KEY_TOKEN, token)
            return response.body()!!
        }
        return null
    }

    fun getFirebaseUser(): FirebaseUser {
        return FirebaseAuth.getInstance().currentUser!!
    }

    fun getUserLocal(): User? {
        return localData.getCurrentUser()
    }

    fun checkUserLoggedIn() : Boolean {
        return localData.getBoolean(IS_LOGGED_IN)
    }

    fun getToken() : String? {
        return localData.getString(KEY_TOKEN)
    }

    fun getCurrentUserId() : String? {
        return localData.getString(KEY_USER_ID)
    }

    fun getCurrentUserTeams() : List<Team> {
        return localData.getCurrentUserTeams()
    }
}