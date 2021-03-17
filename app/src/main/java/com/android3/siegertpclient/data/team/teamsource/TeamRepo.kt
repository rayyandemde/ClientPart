package com.android3.siegertpclient.data.team.teamsource

import android.content.Context
import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.payload.ApiResponse
import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.data.team.teamsource.teamRemote.TeamRemoteDataSource
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.utils.PreferencesProvider
import com.android3.siegertpclient.utils.commonlocalgetter.TeamNameUtil
import com.android3.siegertpclient.utils.commonlocalgetter.Token

class TeamRepo(private val context: Context) {

    private val teamRemoteDataSource = TeamRemoteDataSource()
    private var localData = PreferencesProvider(context)

    suspend fun createNewTeam(adminId : String, name : String, password : String) : Team? {
        val response =
            teamRemoteDataSource.createNewTeam(adminId, name, password, Token.getBearerToken(context)!!)
        if (response.isSuccessful) {
            localData.putCurrentTeam(response.body()!!)
            return response.body()!!
        }
        return null
    }

    suspend fun getTeamByName(teamName : String) : Team? {
        val response =
            teamRemoteDataSource.getTeamByName(teamName, Token.getBearerToken(context)!!)
        if (response.isSuccessful) {
            localData.putCurrentTeam(response.body()!!)
            return response.body()!!
        }
        return null
    }

    suspend fun getTeamById(teamId : String) : Team? {
        val response =
            teamRemoteDataSource.getTeamById(teamId, Token.getBearerToken(context)!!)
        if (response.isSuccessful) {
            localData.putCurrentTeam(response.body()!!)
            return response.body()!!
        }
        return null
    }

    suspend fun getTeamTournaments(teamName: String) : List<Tournament>? {
        val response =
            teamRemoteDataSource.getTeamTournaments(teamName, Token.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun getTeamInvitations(teamName: String) : List<Invitation>? {
        val response =
            teamRemoteDataSource.getTeamInvitations(teamName, Token.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun deleteTeam(teamName: String) : ApiResponse? {
        val response =
            teamRemoteDataSource.deleteTeam(teamName, Token.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun getTeamMembers() : List<User>? {
        val response = teamRemoteDataSource.getTeamMembers(TeamNameUtil.getCurrentTeamName(context)!!, Token.getBearerToken(context)!!)

        /* dummy implementation
        val token = "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjRlMDBlOGZlNWYyYzg4Y2YwYzcwNDRmMzA3ZjdlNzM5Nzg4ZTRmMWUiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL3NlY3VyZXRva2VuLmdvb2dsZS5jb20vYW5kcm9pZHRlYW0zLTdmOTY4IiwiYXVkIjoiYW5kcm9pZHRlYW0zLTdmOTY4IiwiYXV0aF90aW1lIjoxNjE1OTM3NTY4LCJ1c2VyX2lkIjoiOTBzd3Bwb3E2TmVhMmFaSjAwalFDYkZFVGFtMiIsInN1YiI6Ijkwc3dwcG9xNk5lYTJhWkowMGpRQ2JGRVRhbTIiLCJpYXQiOjE2MTU5Mzc1NjgsImV4cCI6MTYxNTk0MTE2OCwiZW1haWwiOiJ0ZXN0MjhmZWJAZ21haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJmaXJlYmFzZSI6eyJpZGVudGl0aWVzIjp7ImVtYWlsIjpbInRlc3QyOGZlYkBnbWFpbC5jb20iXX0sInNpZ25faW5fcHJvdmlkZXIiOiJwYXNzd29yZCJ9fQ.R2zW5OtWrvPux_8sF91ZmPTYAA1TCSsrRNafoJ4U8zYmqgf_7o_bP8TPJqpaj10uum3NEQGnSvHYr_ujReU66TsR_xnIqrGt_mZiR45C1V91yJVhqfd2fq61XXj-S5UbWcsTT90UUxRB5mAw6iPavp3KpX6kOv1hiRwzERNY36PqdaMbjVpYOvy5GZ2VTZ-pWV-5YQU47LLUZ0g_M9cv9waIcvkqgd4Xp1kkPYuB2v_wJbEwsQhyQRcSbXAUARoDxmO7UO0dxa2NisJ5fZGJ1XH6EFOcPf252-KvF_c0uXnYd87F8dSQGhDtXEzLvaD85fOftV_bHGNvR-4n0SmezQ"
        val response = teamRemoteDataSource.getTeamMembers("test28febteam", token) */
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun kickTeamMember(teamName: String, memberId : String) : ApiResponse? {
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