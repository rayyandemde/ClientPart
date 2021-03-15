package com.android3.siegertpclient.data.team.teamsource.teamRemote

import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.payload.ApiResponse
import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.user.User
import retrofit2.Response
import retrofit2.http.*

interface TeamService {

    @GET("teams/{teamName}")
    suspend fun getTeamByName(
        @Path("teamName") teamName: String,
        @Header("Authorization") token: String
    ): Response<Team>

    @GET("teams")
    suspend fun getTeamById(
        @Query("id") teamId: String,
        @Header("Authorization") token: String
    ): Response<Team>

    @GET("teams/{teamName}/members")
    suspend fun getTeamMembers(
        @Path("teamName") teamName: String,
        @Header("Authorization") token: String
    ): Response<List<User>>

    @GET("teams/{teamName}/tournaments")
    suspend fun getTeamTournaments(
        @Path("teamName") teamName: String,
        @Header("Authorization") token: String
    ): Response<List<Tournament>>

    @GET("teams/{teamName}/invitations")
    suspend fun getTeamInvitations(
        @Path("teamName") teamName: String,
        @Header("Authorization") token: String
    ): Response<List<Invitation>>

    @POST("teams")
    suspend fun createNewTeam(
        @Body team : Map<String, Any>,
        @Header("Authorization") token: String
    ): Response<Team>


    @DELETE("teams/{teamName}")
    suspend fun deleteTeam(
        @Path("teamName") teamName: String,
        @Header("Authorization") token: String
    ) : Response<ApiResponse>

    @DELETE("teams/{teamName}/members/{id}")
    suspend fun kickTeamMember(
        @Path("teamName") teamName: String, @Path("id") memberId: String,
        @Header("Authorization") token: String
    ) : Response<ApiResponse>

    @POST("teams/{teamName}")
    suspend fun joinTeam(
        @Path("teamName") teamName: String, @Body activity: String, password: String,
        @Header("Authorization") token: String
    ) : Response<ApiResponse>
    //TODO toggle password only on join activity

    @POST("teams/{teamName}")
    suspend fun quitTeam(
        @Path("teamName") teamName: String, @Body activity: String,
        @Header("Authorization") token: String
    ) : Response<ApiResponse>
}