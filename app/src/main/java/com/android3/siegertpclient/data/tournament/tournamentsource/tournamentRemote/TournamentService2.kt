package com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote

import com.android3.siegertpclient.data.tournament.TournamentTest
import com.android3.siegertpclient.data.user.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface TournamentService2 {

    @POST("users")
    suspend fun createNewTournament(
        @Body user: Map<String, String>,
        @Header("Authorization") token: String
    ): Response<User>

    @GET("tournaments")
    suspend fun getTournamentById(@Query("id") tourneyId : String,
                                  @Header("Authorization") token: String) : Response<TournamentTest>
}