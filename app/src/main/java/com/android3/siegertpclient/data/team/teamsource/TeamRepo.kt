package com.android3.siegertpclient.data.team.teamsource

import com.android3.siegertpclient.data.team.teamsource.teamLocal.Team
import com.android3.siegertpclient.data.team.teamsource.teamRemote.TeamRemoteDataSource
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.utils.RestClient

class TeamRepo : ITeamDataSource {

    private val restClient = RestClient()
    private val teamService = restClient.getTeamService()

    var teamRemote = TeamRemoteDataSource(teamService)

    fun createNewTeam(adminId : String, name : String, password : String, ownUserId: String) : Team {
        return teamRemote.createNewTeam(adminId, name, password, ownUserId)
    }

    fun getTeamByName(teamName : String, ownUserId: String) : Team {
        return teamRemote.getTeamByName(teamName, ownUserId)
    }

    fun getTeamById(teamId : String, ownUserId: String) : Team {
        return teamRemote.getTeamById(teamId, ownUserId)
    }

    fun deleteTeam(teamName: String, ownUserId: String) {
        teamRemote.deleteTeam(teamName, ownUserId)
    }

    fun getTeamMembers(teamName: String, ownUserId: String) : Array<User> {
        return teamRemote.getTeamMembers(teamName, ownUserId)
    }

    fun kickTeamMember(teamName: String, memberId : String, ownUserId: String) {
        teamRemote.kickTeamMember(teamName, memberId, ownUserId)
    }

    fun handleMembership(teamName: String, activity : String, password: String, ownUserId: String) {
        teamRemote.handleMembership(teamName, activity, password, ownUserId)
    }
}