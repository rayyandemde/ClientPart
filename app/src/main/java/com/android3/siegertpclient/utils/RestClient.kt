package com.android3.siegertpclient.utils

import com.android3.siegertpclient.data.user.usersource.userRemote.UserService
import retrofit2.Retrofit

class RestClient {

    private val retrofit : Retrofit

    init {
        retrofit = Retrofit.Builder()
        .baseUrl("https://our.server.com/")
            .build()
        //Todo Include baseURL
    }

    fun getUserService(): UserService {
        return retrofit.create(UserService::class.java)
    }


}