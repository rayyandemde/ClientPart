package com.android3.siegertpclient.data.team.teamsource.teamRemote

import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.utils.RestClient2
import retrofit2.Response
import retrofit2.http.*

class TeamRemoteDataSource {

    suspend fun createNewTeam(
        adminId: String,
        name: String,
        password: String,
        token: String
    ): Response<Team> {
        return RestClient2.teamService.createNewTeam(adminId, name, password, token)
    }

    suspend fun getTeamByName(teamName: String, ownUserId: String): Response<Team>? {
        return null
    }

    suspend fun getTeamById(teamId: String, ownUserId: String): Response<Team>? {
        return null
    }

    suspend fun getTeamTournaments(
        teamName: String,
        ownUserId: String
    ): Response<Array<Tournament>>? {
        return null
    }

    suspend fun getTeamInvitations(
        teamName: String,
        ownUserId: String
    ): Response<Array<Invitation>>? {
        return null
    }

    suspend fun deleteTeam(teamName: String, ownUserId: String) {

    }

    suspend fun getTeamMembers(teamName: String, ownUserId: String): Response<List<User>>? {
        return null
    }

    suspend fun kickTeamMember(teamName: String, memberId: String, ownUserId: String) {

    }

    suspend fun handleMembership(
        teamName: String,
        activity: String,
        password: String,
        ownUserId: String
    ) {

    }
}