package com.android3.siegertpclient.utils

import com.android3.siegertpclient.data.game.gamesource.gameRemote.GameService
import com.android3.siegertpclient.data.invitation.invitationsource.invitationRemote.InvitationService
import com.android3.siegertpclient.data.team.teamsource.teamRemote.TeamService
import com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote.TournamentService
import com.android3.siegertpclient.data.user.usersource.userRemote.UserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors

class RestClient {
    private var baseUrl = "https://sieger-teamthree.herokuapp.com/"

    fun getUserService(): UserService {
        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .callbackExecutor(Executors.newSingleThreadExecutor())
            .build()
        return retrofit.create(UserService::class.java)
    }

    fun getInvitationService(): InvitationService {
        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .callbackExecutor(Executors.newSingleThreadExecutor())
            .build()
        return retrofit.create(InvitationService::class.java)
    }

    fun getTeamService() : TeamService {
        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .callbackExecutor(Executors.newSingleThreadExecutor())
            .build()
        return retrofit.create(TeamService::class.java)
    }

    fun getGameService() : GameService {
        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .callbackExecutor(Executors.newSingleThreadExecutor())
            .build()
        return retrofit.create(GameService::class.java)
    }

    fun getTournamentService() : TournamentService {
        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .callbackExecutor(Executors.newSingleThreadExecutor())
            .build()
        return retrofit.create(TournamentService::class.java)
    }



}