package com.android3.siegertpclient.data.team.teamsource

import android.content.Context
import com.android3.siegertpclient.data.invitation.invitationsource.Invitation
import com.android3.siegertpclient.data.payload.ApiResponse
import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.data.team.teamsource.teamRemote.TeamRemoteDataSource
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.utils.LocalCache
import com.android3.siegertpclient.utils.PreferencesProvider

class TeamRepo(private val context: Context) {

    private val teamRemoteDataSource = TeamRemoteDataSource()
    private var localData = PreferencesProvider(context)

    suspend fun createNewTeam(adminId : String, name : String, password : String) : Team? {
        val response =
            teamRemoteDataSource.createNewTeam(adminId, name, password, LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            localData.putCurrentTeam(response.body()!!)
            return response.body()!!
        }
        return null
    }

    suspend fun getTeamByName(teamName : String) : Team? {
        val response =
            teamRemoteDataSource.getTeamByName(teamName, LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            localData.putCurrentTeam(response.body()!!)
            return response.body()!!
        }
        return null
    }

    suspend fun getTeamById(teamId : String) : Team? {
        val response =
            teamRemoteDataSource.getTeamById(teamId, LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            localData.putCurrentTeam(response.body()!!)
            return response.body()!!
        }
        return null
    }

    suspend fun getTeamTournaments(teamName: String) : List<Tournament>? {
        val response =
            teamRemoteDataSource.getTeamTournaments(teamName, LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun getTeamInvitations(teamName: String) : List<Invitation>? {
        val response =
            teamRemoteDataSource.getTeamInvitations(teamName, LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun deleteTeam(teamName: String) : ApiResponse? {
        val response =
            teamRemoteDataSource.deleteTeam(teamName, LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun getTeamMembers() : List<User>? {
        val response = teamRemoteDataSource.getTeamMembers(LocalCache.getCurrentTeamName(context)!!, LocalCache.getBearerToken(context)!!)

        /*
        val token = "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjRlMDBlOGZlNWYyYzg4Y2YwYzcwNDRmMzA3ZjdlNzM5Nzg4ZTRmMWUiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL3NlY3VyZXRva2VuLmdvb2dsZS5jb20vYW5kcm9pZHRlYW0zLTdmOTY4IiwiYXVkIjoiYW5kcm9pZHRlYW0zLTdmOTY4IiwiYXV0aF90aW1lIjoxNjE1OTQ2MjA5LCJ1c2VyX2lkIjoiOTBzd3Bwb3E2TmVhMmFaSjAwalFDYkZFVGFtMiIsInN1YiI6Ijkwc3dwcG9xNk5lYTJhWkowMGpRQ2JGRVRhbTIiLCJpYXQiOjE2MTU5NDYyMDksImV4cCI6MTYxNTk0OTgwOSwiZW1haWwiOiJ0ZXN0MjhmZWJAZ21haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJmaXJlYmFzZSI6eyJpZGVudGl0aWVzIjp7ImVtYWlsIjpbInRlc3QyOGZlYkBnbWFpbC5jb20iXX0sInNpZ25faW5fcHJvdmlkZXIiOiJwYXNzd29yZCJ9fQ.aENhhJ2nHS3NdkgdHZG_aCjznthpUK5-1i-MnlhXQS8QNQK6DMfyxiI2ZxNQMLGwnQnrhjFbEBXg74eTng8mBp5L30g2UFYTcDdMrcesoX2otOmJb-BtOLra8ToQM1QUf0_Xuuc8jDsHV0ls9euHVYaa2BCjvBgLnFBgC3feu02NU2a3G7BnLFJmZsAXEEsl9HC5x_6vzXW5MLf1PwWBcOJMAuHfg6CQtSDflHTWvTPOJui8jDhSsUlYq-PDpRuZPbRVTEX193B0xGiandOEYe4DPHQQ0QEWYx1Lpxdya0MlVfuIKNEkODVbPUJ9sVORd9kXhNsKzdIrK9gEeBIOhw"
        val response = teamRemoteDataSource.getTeamMembers("test28febteam", token)*/
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun kickTeamMember(teamName: String, memberId : String) : ApiResponse? {
        val response =
            teamRemoteDataSource.kickTeamMember(teamName, memberId, LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun joinTeam(teamName : String, password : String) : ApiResponse? {
        val response =
            teamRemoteDataSource.joinTeam(teamName, password, LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun quitTeam(teamName : String) : ApiResponse? {
        val response =
            teamRemoteDataSource.quitTeam(teamName, LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }
}