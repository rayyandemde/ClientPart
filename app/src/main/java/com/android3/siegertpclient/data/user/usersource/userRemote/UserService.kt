package com.android3.siegertpclient.data.user.usersource.userRemote

import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.user.TeamList
import com.android3.siegertpclient.data.user.TournamentList
import com.android3.siegertpclient.data.user.User
import retrofit2.Response
import retrofit2.http.*


interface UserService {

    @POST("users")
    fun createNewUser(user: User) : Response<User>

    @GET("users/{username}")
    fun getUserByUsername(@Path("username") username: String) : Response<User>

    @GET("users")
    fun getUserById (@Query("id") id : String) : Response<User>

    @GET("users/{username}/tournaments")
    fun getUsersTournaments (@Path("username") username: String) : Response<TournamentList>

    @GET("users/{username}/teams")
    fun getUserTeams(@Path("username") username: String) : Response<TeamList>

    @GET("users/{username}/invitations")
    fun getUserInvitations(@Path("username") username: String) : Response<Invitation>

    @PUT("users/{username}")
    fun updateUserDetails(@Path("username") oldUsername: String,@Body newUsername : String, @Body forename : String, @Body surname : String)

    @POST("users/{username}/invitations/{id}")
    fun handleInvitationAcceptation(@Path("username") username: String, @Path("id") invitationId: String)

}