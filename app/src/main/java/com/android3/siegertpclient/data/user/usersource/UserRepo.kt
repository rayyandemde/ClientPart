package com.android3.siegertpclient.data.user.usersource

import android.util.Log
import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.team.teamsource.teamLocal.Team
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.data.user.usersource.userRemote.UserRemoteDataSource
import com.android3.siegertpclient.utils.RestClient
import com.google.firebase.auth.FirebaseAuth

class UserRepo() {

    private val restClient = RestClient()
    private val userService = restClient.getUserService()
    private lateinit var auth : FirebaseAuth

    var userRemote = UserRemoteDataSource(userService)

    fun register(email : String,
                 password : String,
                 username: String,
                 firstName: String,
                 surname: String) : User? {
        auth = FirebaseAuth.getInstance()
        auth.createUserWithEmailAndPassword(email, password)
        return userRemote.createNewUser(username, surname, firstName, auth.currentUser?.uid.toString())
    }

    fun login(email : String, password : String) : User {
        auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword(email, password)
        return userRemote.getUserById(auth.currentUser?.uid.toString())
    }

//    fun getUserById (userId : String) : User {
//        return userRemote.getUserById(userId)
//    }
//
//    fun getUserByUsername (username : String) : User {
//        return userRemote.getUserByUsername(username)
//    }
    fun getCurrentUser() {
        auth = FirebaseAuth.getInstance()
        userRemote.getUserById(auth.currentUser?.uid.toString())
    }

    fun getUsersTournaments (username: String) : List<Tournament> {
        return userRemote.getUsersTournaments(username)
    }

    fun getUserTeams (username: String) : List<Team> {
        return userRemote.getUsersTeams(username)
    }

    fun getUsersInvitations (username: String) : List<Invitation> {
        return userRemote.getUsersInvitations(username)
    }

    fun updateUserDetail (oldUsername : String, newUsername : String, firstName: String,
                          surname: String) : User {
        return userRemote.updateUserDetail(oldUsername, newUsername, firstName, surname)
    }

}