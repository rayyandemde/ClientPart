package com.android3.siegertpclient.utils

import com.android3.siegertpclient.data.invitation.invitationsource.invitationRemote.InvitationService
import com.android3.siegertpclient.data.team.teamsource.teamRemote.TeamService
import com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote.TournamentService2
import com.android3.siegertpclient.data.user.usersource.userRemote.UserService
import com.android3.siegertpclient.utils.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RestClient {
    private val okhttp =
        OkHttpClient.Builder()
            .callTimeout(2, TimeUnit.MINUTES)
            .writeTimeout(2, TimeUnit.MINUTES)
            .readTimeout(2, TimeUnit.MINUTES)
            .connectTimeout(2, TimeUnit.MINUTES)
            .build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okhttp)
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