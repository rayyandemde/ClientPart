package com.android3.siegertpclient.data.user.usersource

import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.data.user.usersource.userRemote.UserRemoteDataSource2

import retrofit2.Response

class UserRepo2 {

    private val userRemoteDataSource2 = UserRemoteDataSource2()

    suspend fun createNewUser(
        username: String,
        forename: String,
        surname: String,
        userId: String,
        token: String
    ): Response<User> {
        return userRemoteDataSource2.createNewUser(username, surname, forename, userId, token)
    }

    suspend fun updateUserDetail(
        oldUsername: String, newUsername: String, newForename: String,
        newSurname: String, token: String
    ): Response<User> {
        return userRemoteDataSource2.updateUserDetail(
            oldUsername,
            newUsername,
            newForename,
            newSurname,
            token
        )
    }
}