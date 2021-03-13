package com.android3.siegertpclient.data.game.gamesource

import com.android3.siegertpclient.data.game.Game
import com.android3.siegertpclient.data.game.gamesource.gameRemote.GameRemoteDataSource
import com.android3.siegertpclient.utils.RestClient

/**
 * Repository about the game used to call the game data source.
 */
class GameRepo : IGameDataSource {

    private val restClient = RestClient()
    private val gameService = restClient.getGameService()

    private val gameRemote = GameRemoteDataSource(gameService)

    fun getGameById(tournamentName : String, gameId : String, token : String) : Game? {
        return gameRemote.getGameById(tournamentName, gameId, token)
    }

    fun updateGameById(tournamentName : String, gameId : String, firstWins : Boolean, secondWins : Boolean, draws : Boolean, token : String) : Game? {
        return gameRemote.updateGameById(tournamentName, gameId, firstWins, secondWins, draws, token)
    }

    fun deleteGame(tournamentName : String, gameId : String, token : String) {
        gameRemote.deleteGame(tournamentName, gameId, token)
    }

}