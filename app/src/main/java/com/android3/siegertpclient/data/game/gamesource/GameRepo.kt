package com.android3.siegertpclient.data.game.gamesource

import com.android3.siegertpclient.data.game.Game
import com.android3.siegertpclient.data.game.gamesource.gameRemote.GameRemoteDataSource
import com.android3.siegertpclient.utils.RestClient

class GameRepo : IGameDataSource {

    private val restClient = RestClient()
    private val gameService = restClient.getGameService()

    private val gameRemote = GameRemoteDataSource(gameService)

    fun getGameById(tournamentName : String, gameId : String, ownUserId : String) : Game {
        return gameRemote.getGameById(tournamentName, gameId, ownUserId)
    }

    fun updateGameById(tournamentName : String, gameId : String, game : Game, ownUserId : String) : Game {
        return gameRemote.updateGameById(tournamentName, gameId, game, ownUserId)
    }

    fun deleteGame(tournamentName : String, gameId : String, ownUserId : String) {
        gameRemote.deleteGame(tournamentName, gameId, ownUserId)
    }

}