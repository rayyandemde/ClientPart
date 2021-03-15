package com.android3.siegertpclient.data.team.teamsource.teamRemote

import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.payload.ApiResponse
import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.utils.RestClient2
import com.google.android.gms.common.api.Api
import retrofit2.Response
import retrofit2.http.*

class TeamRemoteDataSource {

    suspend fun createNewTeam(
        adminId: String,
        name: String,
        password: String,
        token: String
    ): Response<Team> {
        val team = hashMapOf<String, Any>()
        team["adminId"] = adminId
        team["name"] = name
        team["password"] = password
        return RestClient2.teamService.createNewTeam(team,  token)
    }

    suspend fun getTeamByName(teamName: String, token : String): Response<Team> {
        return RestClient2.teamService.getTeamByName(teamName, token)
    }

    suspend fun getTeamById(teamId: String, token: String): Response<Team> {
        return RestClient2.teamService.getTeamById(teamId, token)
    }

    suspend fun getTeamTournaments(teamName: String, token : String): Response<List<Tournament>> {
        return RestClient2.teamService.getTeamTournaments(teamName, token)
    }

    suspend fun getTeamInvitations(teamName: String, token: String): Response<List<Invitation>> {
        return RestClient2.teamService.getTeamInvitations(teamName, token)
    }

    suspend fun deleteTeam(teamName: String, token: String) : Response<ApiResponse> {
        return RestClient2.teamService.deleteTeam(teamName, token)
    }

    suspend fun getTeamMembers(teamName : String, token : String): Response<List<User>>? {
        return RestClient2.teamService.getTeamMembers(teamName, token)
    }

    suspend fun kickTeamMember(teamName: String, memberId: String, token : String) : Response<ApiResponse> {
        return RestClient2.teamService.kickTeamMember(teamName, memberId, token)
    }

    suspend fun joinTeam(teamName: String, password: String, token: String) : Response<ApiResponse> {
        val membership = hashMapOf<String, String>()
        membership["activity"] = "join"
        membership["password"] = password
        return RestClient2.teamService.handleMembership(teamName, membership, token)
    }

    suspend fun quitTeam(teamName : String, token : String) : Response<ApiResponse> {
        val membership = hashMapOf<String, String>()
        membership["activity"] = "quit"
        return RestClient2.teamService.handleMembership(teamName, membership, token)
    }
}