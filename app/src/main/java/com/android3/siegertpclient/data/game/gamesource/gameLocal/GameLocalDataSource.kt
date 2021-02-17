package com.android3.siegertpclient.data.game.gamesource.gameLocal

import com.android3.siegertpclient.data.game.Game

class GameLocalDataSource(val gameDao: GameDao) {
    fun saveGame(game: Game) {
        gameDao.insertGame(game)
    }

    fun check(): Boolean {
        return false
    }
}