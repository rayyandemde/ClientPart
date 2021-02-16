package com.android3.siegertpclient.utils

import com.android3.siegertpclient.data.game.gamesource.gameRemote.GameService
import com.android3.siegertpclient.data.invitation.invitationsource.invitationRemote.InvitationService
import com.android3.siegertpclient.data.team.teamsource.teamRemote.TeamService
import com.android3.siegertpclient.data.user.usersource.userRemote.UserService
import retrofit2.Retrofit

class RestClient {

    private val retrofit : Retrofit

    init {
        retrofit = Retrofit.Builder()
        .baseUrl("https://our.server.com/")
            .build()
        //Todo Include baseURL
    }

    fun getUserService(): UserService {
        return retrofit.create(UserService::class.java)
    }

    fun getInvitationService(): InvitationService {
        return retrofit.create(InvitationService::class.java)
    }

    fun getTeamService() : TeamService {
        return retrofit.create(TeamService::class.java)
    }

    fun getGameService() : GameService {
        return retrofit.create(GameService::class.java)
    }


}