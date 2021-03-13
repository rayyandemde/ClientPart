package com.android3.siegertpclient.data.user.usersource.userRemote

import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.utils.RestClient2
import com.android3.siegertpclient.utils.TokenUtil
import retrofit2.Response

class UserRemoteDataSource2 {

    suspend fun createNewUser(
        username: String,
        surname: String,
        forename: String,
        userId: String,
        token: String
    ): Response<User> {
        val user = hashMapOf<String, String>()
        user["username"] = username
        user["surname"] = surname
        user["forename"] = forename
        user["userId"] = userId
        return RestClient2.userService.createNewUser(user, token)
    }

    suspend fun updateUserDetail(
        oldUsername: String,
        newUsername: String,
        newForename: String,
        newSurname: String,
        token: String
    ): Response<User> {
        return RestClient2.userService.updateUserDetails(
            oldUsername,
            newUsername,
            newForename,
            newSurname,
            token
        )
    }
}