package com.android3.siegertpclient.data.team.teamsource

import android.content.Context
import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.data.team.teamsource.teamRemote.TeamRemoteDataSource
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.data.user.usersource.userRemote.UserRemoteDataSource
import com.android3.siegertpclient.utils.PreferencesProvider
import com.android3.siegertpclient.utils.RestClient

class TeamRepo(private val context: Context) {

    private val taemRemoteDataSource = TeamRemoteDataSource()
    private var localData = PreferencesProvider(context)

    fun createNewTeam(adminId : String, name : String, password : String, token: String) : Team? {
        return null
    }

    fun getTeamByName(teamName : String, token: String) : Team? {
        return null
    }

    fun getTeamById(teamId : String, token: String) : Team? {
        return null
    }

    fun getTeamTournaments(teamName: String,token: String) : Array<Tournament>? {
        return null
    }

    fun getTeamInvitations(teamName: String, token: String) : Array<Invitation>? {
        return null
    }

    fun deleteTeam(teamName: String, token: String) {
    }

    fun getTeamMembers(teamName: String, token: String) : Array<User>? {
        return null
    }

    fun kickTeamMember(teamName: String, memberId : String, token: String) {
    }

    fun handleMembership(teamName: String, activity : String, password: String, token: String) {
    }
}