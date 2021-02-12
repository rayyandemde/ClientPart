package com.android3.siegertpclient.data.user.usersource.userRemote

import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.team.teamsource.teamLocal.Team
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.user.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface userService {

    @POST("users")
    fun createNewUser(user: User) : Boolean

    @GET("users/{username}")
    fun getUserByUsername(@Path("username") username: String) : Response<User>

    @GET("users")
    fun getUserById (@Query("id") id : Int) : Response<User>

    @GET("users/{username}/tournaments")
    fun getUsersTournaments (@Path("username") username: String) : Response<Tournament>

    @GET("users/{username}/teams")
    fun getUserTeams(@Path("username") username: String) : Response<Team>

    @GET("users/{username}/invitations")
    fun getUserInvitations(@Path("username") username: String) : Response<Invitation>

    @PUT("users/{username}")
    fun updateUserDetails(@Path("username") username: String)

    @POST("users/{username}/invitations/{id}")
    fun handleInvitationAcceptation(@Path("username") username: String, @Path("id") id: Int)

}