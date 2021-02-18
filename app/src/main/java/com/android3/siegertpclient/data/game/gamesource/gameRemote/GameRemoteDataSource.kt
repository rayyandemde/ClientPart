package com.android3.siegertpclient.data.game.gamesource.gameRemote

import com.android3.siegertpclient.data.game.Game

class GameRemoteDataSource (private val gameService: GameService) {

    fun getGameById(tournamentName : String, gameId : String, ownUserId : String) : Game {
        val response = gameService.getGameById(tournamentName, gameId, ownUserId)
        return response.body()
    }

    fun updateGameById(tournamentName : String, gameId : String, firstWins : Boolean,
                       secondWins : Boolean, draws : Boolean, ownUserId : String) : Game {
        val response = gameService.updateGameById(tournamentName, gameId, firstWins, secondWins, draws, ownUserId)
        return response.body()
    }

    fun deleteGame(tournamentName : String, gameId : String, ownUserId : String) {
        val response = gameService.deleteGame(tournamentName, gameId, ownUserId)
    }

}