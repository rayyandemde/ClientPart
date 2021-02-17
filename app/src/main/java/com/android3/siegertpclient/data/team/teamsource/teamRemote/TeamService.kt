package com.android3.siegertpclient.data.team.teamsource.teamRemote

import androidx.room.Delete
import com.android3.siegertpclient.data.team.teamsource.teamLocal.Team
import com.android3.siegertpclient.data.user.User
import retrofit2.Response
import retrofit2.http.*

interface TeamService {

    @POST("teams")
    fun createNewTeam(@Body adminId : String, name : String, password : String, @Header("currentUserId") ownUserId: String) : Response<Team>

    @GET("teams/{teamName}")
    fun getTeamByName(@Path("teamName") teamName : String, @Header("currentUserId") ownUserId: String) : Response<Team>

    @GET("teams")
    fun getTeamById(@Query("id") teamId : String, @Header("currentUserId") ownUserId: String) : Response<Team>

    @DELETE("teams/{teamName}")
    fun deleteTeam(@Path("teamName") teamName: String, @Header("currentUserId") ownUserId: String)

    @GET("teams/{teamName}/members")
    fun getTeamMembers(@Path("teamName") teamName: String, @Header("currentUserId") ownUserId: String) : Response<Array<User>>

    @DELETE("teams/{teamName}/members/{id}")
    fun kickTeamMember(@Path("teamName") teamName: String, @Path("id") memberId : String, @Header("currentUserId") ownUserId: String)

    @POST("teams/{teamName}")
    fun handleMembership(@Path("teamName") teamName: String, @Body activity : String, password: String, @Header("currentUserId") ownUserId: String)
    //TODO toggle password only on join activity

}