package com.android3.siegertpclient.data.game.gamesource.gameRemote

import com.android3.siegertpclient.data.game.Game
import retrofit2.Response
import retrofit2.http.*

interface GameService {

    @GET("tournaments/{tournamentName}/games/{id}")
    fun getGameById(@Path("tournamentName") tournamentName : String,
                    @Path("id") gameId : String, @Header("currentUserId") ownUserId : String) : Response<Game>

    @PUT("tournaments/{tournamentName}/games/{id}")
    fun updateGameById(@Path("tournamentName") tournamentName : String,
                       @Path("id") gameId : String, @Body firstWins : Boolean, secondWins : Boolean, draws : Boolean,
                       @Header("currentUserId") ownUserId : String) : Response<Game>//TODO maybe change body to result

    @DELETE("tournaments/{tournamentName}/games/{id}")
    fun deleteGame(@Path("tournamentName") tournamentName : String,
                   @Path("id") gameId : String, @Header("currentUserId") ownUserId : String)
}