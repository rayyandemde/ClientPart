package com.android3.siegertpclient.utils

import com.android3.siegertpclient.data.user.usersource.userRemote.UserService2
import com.android3.siegertpclient.ui.dummyretrofit.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestClient2 {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val userService: UserService2 by lazy {
        retrofit.create(UserService2::class.java)
    }
}