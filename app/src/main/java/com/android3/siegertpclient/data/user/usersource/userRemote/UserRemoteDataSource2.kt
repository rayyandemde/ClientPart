package com.android3.siegertpclient.data.user.usersource.userRemote

import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.utils.RestClient2
import retrofit2.Response

class UserRemoteDataSource2 {

    suspend fun createNewUser(username: String, surname: String, forename: String, userId: String, token: String) : Response<User> {
        val user = hashMapOf<String, String>()
        user["username"] = username
        user["surname"] = surname
        user["forename"] = forename
        user["userId"] = userId
        return RestClient2.userService.createNewUser(user, token)
    }
}