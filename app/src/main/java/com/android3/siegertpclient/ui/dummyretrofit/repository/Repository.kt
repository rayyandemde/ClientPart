package com.android3.siegertpclient.ui.dummyretrofit.repository

import com.android3.siegertpclient.ui.dummyretrofit.api.RetrofitInstance
import com.android3.siegertpclient.ui.dummyretrofit.model.User
import retrofit2.Call
import retrofit2.Response

class Repository {

    suspend fun createNewUser(username: String, surname: String, forename: String, userId: String, token: String) : Response<User> {
        val user = hashMapOf<String, String>()
        user["username"] = username
        user["surname"] = surname
        user["forename"] = forename
        user["userId"] = userId
        return RetrofitInstance.api.createNewUser(user, token)
    }
}