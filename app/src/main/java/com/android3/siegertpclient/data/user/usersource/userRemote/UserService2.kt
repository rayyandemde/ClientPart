package com.android3.siegertpclient.data.user.usersource.userRemote

import com.android3.siegertpclient.data.user.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface UserService2 {

    @POST("users")
    suspend fun createNewUser(
        @Body user: Map<String, String>,
        @Header("Authorization") token: String
    ): Response<User>

    @PUT("users/{username}")
    suspend fun updateUserDetails(
        @Path("username") oldUsername: String,
        @Body username: String, @Body surname: String,
        @Body forename: String, @Header("Authorization") token: String
    )
            : Response<User>
}