package com.android3.siegertpclient.utils

import com.android3.siegertpclient.data.invitation.invitationsource.invitationRemote.InvitationService
import com.android3.siegertpclient.data.team.teamsource.teamRemote.TeamService
import com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote.TournamentService2
import com.android3.siegertpclient.data.user.usersource.userRemote.UserService
import com.android3.siegertpclient.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestClient {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val userService: UserService by lazy {
        retrofit.create(UserService::class.java)
    }

    val invitationService: InvitationService by lazy {
        retrofit.create(InvitationService::class.java)
    }

    val teamService: TeamService by lazy {
        retrofit.create(TeamService::class.java)
    }

    val tournamentService: TournamentService2 by lazy {
        retrofit.create(TournamentService2::class.java)
    }
}