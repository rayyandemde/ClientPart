package com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote

import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.data.tournament.Game
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.user.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface TournamentService2 {

    @POST("tournaments")
    suspend fun createNewTournament(
        @Body tournament : Map<String, Object>,
        @Header("Authorization") token: String
    ): Response<Tournament>

    @GET("tournaments")
    suspend fun getTournamentById(@Query("id") tourneyId : String,
                                  @Header("Authorization") token: String)
    : Response<Tournament>

    @GET("tournaments/{tournamentName}")
    suspend fun getTournamentByName(
        @Path("tournamentName") tournamentName : String,
        @Header("Authorization") token : String
    ) : Response<Tournament>

    @GET("tournaments/{tournamentName}/participants")
    suspend fun getTournamentParticipantsUser(
        @Path("tournamentName") tournamentName : String,
        @Header("Authorization") token : String
    ) : Response<User>

    @GET("tournaments/{tournamentName}/participants")
    suspend fun getTournamentParticipantsTeam(
        @Path("tournamentName") tournamentName : String,
        @Header("Authorization") token : String
    ) : Response<Team>

    @GET("tournaments/{tournamentName}/games")
    suspend fun getTournamentGames(
        @Path("tournamentName") tournamentName : String,
        @Header("Authorization") token : String
    ) : Response<List<Game>>

    @GET("tournaments/{tournamentName}/games/{id}")
    suspend fun getGameById(
        @Path("tournamentName") tournamentName : String,
        @Path("id") gameId : String,
        @Header("Authorization") token : String
    ) : Response<Game>

    @POST("tournaments/{tournamentName}")
    suspend fun handleParticipation(
        @Path("tournamentName") tournamentName : String,
        @Body participation : Map<String, String>,
        @Header("Authorization") token : String
    ) : Response<Map<String, Any>>

    @POST("tournaments/{tournamentName}/games")
    suspend fun createGames(
        @Path("tournamentName") tournamentName : String,
        @Header("Authorization") token : String
    ) : Response<Map<String, Any>>

    @PUT("tournaments/{tournamentName}/games/{id}")
    suspend fun updateGameById(
        @Path("tournamentName") tournamentName : String,
        @Path("id") gameId : String,
        @Header("Authorization") token : String
    ) : Response<Game>

    @DELETE("tournaments/{tournamentName}")
    suspend fun deleteTournament(
        @Path("tournamentName") tournamentName : String,
        @Header("Authorization") token : String
    ) : Response<Any>

    @DELETE("tournaments/{tournamentName}/games/{id}")
    suspend fun deleteGameById(
        @Path("tournamentName") tournamentName : String,
        @Path("id") gameId : String,
        @Header("Authorization") token : String
    ) : Response<Any>
}