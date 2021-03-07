package com.android3.siegertpclient.ui.dummyretrofit.api

import com.android3.siegertpclient.ui.dummyretrofit.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface SimpleApi {

    @POST("users")
    suspend fun createNewUser(@Body user : Map<String, String>,
                      @Header("Authorization") token : String) : Response<User>
}