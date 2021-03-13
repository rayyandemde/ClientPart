package com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote

import com.android3.siegertpclient.data.user.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface TournamentService2 {

    @POST("users")
    suspend fun createNewTournament(
        @Body user: Map<String, String>,
        @Header("Authorization") token: String
    ): Response<User>
}