package com.android3.siegertpclient.data.userdummy.usersource

import com.android3.siegertpclient.data.Token.Token
import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.userdummy.usersource.userRemote.UserService
import com.android3.siegertpclient.data.userdummy.NotificationList
import com.android3.siegertpclient.data.userdummy.TeamList
import com.android3.siegertpclient.data.userdummy.TournamentList
import com.android3.siegertpclient.data.userdummy.User
import com.android3.siegertpclient.data.userdummy.usersource.userLocal.UserDao
import com.android3.siegertpclient.data.userdummy.usersource.userLocal.UserLocalDataSource
import com.android3.siegertpclient.data.userdummy.usersource.userRemote.UserRemoteDataSource
import com.android3.siegertpclient.utils.OnlineChecker
import com.android3.siegertpclient.utils.RestClient
import com.android3.siegertpclient.utils.TokenUtil
import com.google.firebase.auth.FirebaseAuth
import retrofit2.Retrofit

class UserRepo() {

    private val restClient = RestClient()

    private val retrofit = Retrofit.Builder().baseUrl("https://our.server.com/").build()

    fun getUserService(): UserService {
        return retrofit.create(UserService::class.java)
    }

    private val userService = getUserService()
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

    fun updateUserDetail (oldUsername : String, newUsername : String, firstName: String, surname: String) {
        userRemote.updateUserDetail(oldUsername, newUsername, firstName, surname)
    }
}