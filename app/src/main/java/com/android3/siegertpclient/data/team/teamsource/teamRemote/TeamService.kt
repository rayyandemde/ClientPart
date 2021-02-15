package com.android3.siegertpclient.data.team.teamsource.teamRemote

import androidx.room.Delete
import com.android3.siegertpclient.data.team.teamsource.teamLocal.Team
import com.android3.siegertpclient.data.user.User
import retrofit2.Response
import retrofit2.http.*

interface TeamService {

    @POST("teams")
    fun createNewTeam(@Body team : Team)

    @GET("teams/{teamName}")
    fun getTeamByName(@Path("teamName") teamName : String) : Response<Team>

    @GET("teams")
    fun getTeamById(@Query("id") teamId : String) : Response<Team>

    @DELETE("teams/{teamName}")
    fun deleteTeam(@Path("teamName") teamName: String)

    @GET("teams/{teamName}/members")
    fun getTeamMembers(@Path("teamName") teamName: String) : Response<User>//TODo fix because you get multiple Users

    @DELETE("teams/{teamName}/members/{id}")
    fun kickTeamMember(@Path("teamName") teamName: String, @Path("id") memberId : String)

    @POST("teams/{teamName}")
    fun handleMembership(@Path("teamName") teamName: String)
    //TODO add body

}