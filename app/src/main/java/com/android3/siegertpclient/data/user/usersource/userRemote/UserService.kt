package com.android3.siegertpclient.data.user.usersource.userRemote

import com.android3.siegertpclient.data.invitation.invitationsource.Invitation
import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.user.User
import retrofit2.Response
import retrofit2.http.*

interface UserService {

    @POST("users")
    suspend fun createNewUser(
        @Body user: Map<String, String>,
        @Header("Authorization") token: String
    ): Response<User>

    //getUserById alternative, not used at current implementation
    @GET("users/{username}")
    suspend fun getUserByUsername(
        @Path("username") username: String,
        @Header("Authorization") token: String
    ): Response<User>

    @GET("users")
    suspend fun getUserById(
        @Query("id") id: String,
        @Header("Authorization") token: String
    ): Response<User>

    @GET("users/{username}/tournaments")
    suspend fun getUsersTournaments(
        @Path("username") username: String,
        @Header("Authorization") token: String
    ): Response<List<Tournament>>

    @GET("users/{username}/teams")
    suspend fun getUserTeams(
        @Path("username") username: String,
        @Header("Authorization") token: String
    ): Response<List<Team>>

    @GET("users/{username}/invitations")
    suspend fun getUserInvitations(
        @Path("username") username: String,
        @Header("Authorization") token: String
    ): Response<List<Invitation>>

    @PUT("users/{username}")
    suspend fun updateUserDetails(
        @Path("username") oldUsername: String,
        @Body user: Map<String, String>, @Header("Authorization") token: String
    )
            : Response<User>
}