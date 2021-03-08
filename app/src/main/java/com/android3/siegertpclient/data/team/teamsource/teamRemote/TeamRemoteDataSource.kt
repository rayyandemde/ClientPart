package com.android3.siegertpclient.data.team.teamsource.teamRemote

import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.team.teamsource.ITeamDataSource
import com.android3.siegertpclient.data.team.teamsource.teamLocal.Team
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.user.User
import retrofit2.Response
import retrofit2.http.*

class TeamRemoteDataSource (private val teamService: TeamService) : ITeamDataSource {

    fun createNewTeam(adminId : String, name : String, password : String, ownUserId: String) : Team? {
        val response = teamService.createNewTeam(adminId, name, password, ownUserId)
        return response.body()
    }

    fun getTeamByName(teamName : String, ownUserId: String) : Team? {
        val response = teamService.getTeamByName(teamName, ownUserId)
        return response.body()
    }

    fun getTeamById(teamId : String, ownUserId: String) : Team? {
        val response = teamService.getTeamById(teamId, ownUserId)
        return response.body()
    }

    fun getTeamTournaments(teamName: String,ownUserId: String) : Array<Tournament>? {
        val response = teamService.getTeamTournaments(teamName, ownUserId)
        return response.body()
    }

    fun getTeamInvitations(teamName: String, ownUserId: String) : Array<Invitation>? {
        val response = teamService.getTeamInvitations(teamName, ownUserId)
        return response.body()
    }

    fun deleteTeam(teamName: String, ownUserId: String) {
        val response = teamService.deleteTeam(teamName, ownUserId)
    }

    fun getTeamMembers(teamName: String, ownUserId: String) : Array<User>? {
        val response = teamService.getTeamMembers(teamName, ownUserId)
        return response.body()
    }

    fun kickTeamMember(teamName: String, memberId : String, ownUserId: String) {
        val response = teamService.kickTeamMember(teamName, memberId, ownUserId)
    }

    fun handleMembership(teamName: String, activity : String, password: String, ownUserId: String) {
        val response = teamService.handleMembership(teamName, activity, password, ownUserId)
    }
}