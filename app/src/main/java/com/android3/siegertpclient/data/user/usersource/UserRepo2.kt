package com.android3.siegertpclient.data.user.usersource

import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.team.teamsource.teamLocal.Team
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.data.user.usersource.userRemote.UserRemoteDataSource2
import com.google.firebase.auth.FirebaseAuth

import retrofit2.Response

class UserRepo2 {

    private val userRemoteDataSource = UserRemoteDataSource2()

    suspend fun createNewUser(
        username: String,
        forename: String,
        surname: String,
        userId: String,
        token: String
    ): Response<User> {
        return userRemoteDataSource.createNewUser(username, surname, forename, userId, token)
    }

    suspend fun getUserById(userId: String, token: String): Response<User> {
        return userRemoteDataSource.getUserById(userId, token)
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
}