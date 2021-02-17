package com.android3.siegertpclient.data.team.teamsource

import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.team.teamsource.teamLocal.Team
import com.android3.siegertpclient.data.team.teamsource.teamRemote.TeamRemoteDataSource
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.utils.RestClient

class TeamRepo : ITeamDataSource {

    private val restClient = RestClient()
    private val teamService = restClient.getTeamService()

    var teamRemote = TeamRemoteDataSource(teamService)

    fun createNewTeam(adminId : String, name : String, password : String, token: String) : Team {
        return teamRemote.createNewTeam(adminId, name, password, token)
    }

    fun getTeamByName(teamName : String, token: String) : Team {
        return teamRemote.getTeamByName(teamName, token)
    }

    fun getTeamById(teamId : String, token: String) : Team {
        return teamRemote.getTeamById(teamId, token)
    }

    fun getTeamTournaments(teamName: String,token: String) : Array<Tournament> {
        return teamRemote.getTeamTournaments(teamName, token)
    }

    fun getTeamInvitations(teamName: String, token: String) : Array<Invitation> {
        return teamRemote.getTeamInvitations(teamName, token)
    }

    fun deleteTeam(teamName: String, token: String) {
        teamRemote.deleteTeam(teamName, token)
    }

    fun getTeamMembers(teamName: String, token: String) : Array<User> {
        return teamRemote.getTeamMembers(teamName, token)
    }

    fun kickTeamMember(teamName: String, memberId : String, token: String) {
        teamRemote.kickTeamMember(teamName, memberId, token)
    }

    fun handleMembership(teamName: String, activity : String, password: String, token: String) {
        teamRemote.handleMembership(teamName, activity, password, token)
    }
}