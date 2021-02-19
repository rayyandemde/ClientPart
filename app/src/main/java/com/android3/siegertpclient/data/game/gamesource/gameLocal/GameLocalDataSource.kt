package com.android3.siegertpclient.data.game.gamesource.gameLocal

import com.android3.siegertpclient.data.Result.Result
import com.android3.siegertpclient.data.game.Game

/**
 * local data source of the room database.
 */
class GameLocalDataSource(val gameDao: GameDao) {
    fun saveGame(game: Game) {
        gameDao.insertGame(game)
    }

    fun getGame(){
        gameDao.allGames
    }
    fun deleteGame(){
        gameDao.deleteAllGames()
    }
    fun updateGame(game: Game){
        gameDao.updateGame(game)
    }
    fun check(): Boolean {
        return true
    }
}