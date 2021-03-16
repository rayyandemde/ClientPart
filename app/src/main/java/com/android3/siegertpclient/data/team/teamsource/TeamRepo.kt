package com.android3.siegertpclient.data.team.teamsource

import android.content.Context
import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.payload.ApiResponse
import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.data.team.teamsource.teamRemote.TeamRemoteDataSource
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.data.user.usersource.userRemote.UserRemoteDataSource
import com.android3.siegertpclient.ui.dummyretrofit.util.Constants
import com.android3.siegertpclient.utils.PreferencesProvider
import com.android3.siegertpclient.utils.RestClient
import com.android3.siegertpclient.utils.Token

class TeamRepo(private val context: Context) {

    private val teamRemoteDataSource = TeamRemoteDataSource()
    private var localData = PreferencesProvider(context)

    suspend fun createNewTeam(adminId : String, name : String, password : String, token: String) : Team? {
        val response =
            teamRemoteDataSource.createNewTeam(adminId, name, password, Token.getBearerToken(context)!!)
        if (response.isSuccessful) {
            localData.putCurrentTeam(response.body()!!)
            return response.body()!!
        }
        return null
    }

    suspend fun getTeamByName(teamName : String, token: String) : Team? {
        val response =
            teamRemoteDataSource.getTeamByName(teamName, Token.getBearerToken(context)!!)
        if (response.isSuccessful) {
            localData.putCurrentTeam(response.body()!!)
            return response.body()!!
        }
        return null
    }

    suspend fun getTeamById(teamId : String, token: String) : Team? {
        val response =
            teamRemoteDataSource.getTeamById(teamId, Token.getBearerToken(context)!!)
        if (response.isSuccessful) {
            localData.putCurrentTeam(response.body()!!)
            return response.body()!!
        }
        return null
    }

    suspend fun getTeamTournaments(teamName: String, token: String) : List<Tournament>? {
        val response =
            teamRemoteDataSource.getTeamTournaments(teamName, Token.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun getTeamInvitations(teamName: String, token: String) : List<Invitation>? {
        val response =
            teamRemoteDataSource.getTeamInvitations(teamName, Token.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun deleteTeam(teamName: String, token: String) : ApiResponse? {
        val response =
            teamRemoteDataSource.deleteTeam(teamName, Token.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun getTeamMembers(teamName: String, token: String) : List<User>? {
        val response =
            teamRemoteDataSource.getTeamMembers(teamName, Token.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun kickTeamMember(teamName: String, memberId : String, token: String) : ApiResponse? {
        val response =
            teamRemoteDataSource.kickTeamMember(teamName, memberId, Token.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun joinTeam(teamName : String, password : String) : ApiResponse? {
        val response =
            teamRemoteDataSource.joinTeam(teamName, password, Token.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun quitTeam(teamName : String) : ApiResponse? {
        val response =
            teamRemoteDataSource.quitTeam(teamName, Token.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }
}