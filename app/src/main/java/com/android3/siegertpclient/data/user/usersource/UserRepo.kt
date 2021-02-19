package com.android3.siegertpclient.data.user.usersource

import android.util.Log
import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.user.NotificationList
import com.android3.siegertpclient.data.user.TeamList
import com.android3.siegertpclient.data.user.TournamentList
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.data.user.usersource.userLocal.UserLocalDataSource
import com.android3.siegertpclient.data.user.usersource.userRemote.UserRemoteDataSource
import com.android3.siegertpclient.utils.RestClient
import com.google.firebase.auth.FirebaseAuth
import kotlin.coroutines.Continuation

class UserRepo() : IUserDataSource {

    private val restClient = RestClient()
    private val userService = restClient.getUserService()
    private lateinit var auth : FirebaseAuth

    var userRemote = UserRemoteDataSource(userService)
    var userLocal = UserLocalDataSource()

    fun register(email : String,
                 password : String,
                 username: String,
                 firstName: String,
                 surname: String) : User {
        auth = FirebaseAuth.getInstance()
        auth.createUserWithEmailAndPassword(email, password)
        val user = userRemote.createNewUser(username, surname, firstName, auth.currentUser?.uid.toString())
        if(user.teamList == null) {
            Log.e("LOG","This object has been failed to created")
        } else {
            Log.e("LOG","Object Success")
        }

        userLocal.saveUser(user)
        return user
    }

    fun login(email : String, password : String) : User {
        auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword(email, password)
        val user = userRemote.getUserById(auth.currentUser?.uid.toString())
        userLocal.saveUser(user)
        return user
    }

    fun getUserById (userId : String) : User {
        return userRemote.getUserById(userId)
    }

    fun getUserByUsername (username : String) : User {
        return userRemote.getUserByUsername(username)
    }

    fun getUsersTournaments (username: String) : TournamentList {
        return userRemote.getUsersTournaments(username)
    }

    fun getUserTeams (username: String) : TeamList {
        return userRemote.getUsersTeams(username)
    }

    fun getUsersInvitations (username: String) : Array<Invitation> {
        return userRemote.getUsersInvitations(username)
    }

    fun updateUserDetail (oldUsername : String, newUsername : String, firstName: String, surname: String) : User {
        return userRemote.updateUserDetail(oldUsername, newUsername, firstName, surname)
    }

}