package com.android3.siegertpclient.data.game.gamesource.gameLocal

import androidx.room.*
import com.android3.siegertpclient.data.game.Game

@Dao
interface GameDao {
    @Insert
    fun insertGame(vararg games: Game?)

    @Update
    fun updateGame(vararg games: Game?)

    @Delete
    fun deleteGame(vararg games: Game?)

    @Query("DELETE FROM Game")
    fun deleteAllGames()

    @get:Query("SELECT * FROM Game")
    val allGames: List<Game?>?

    @Query("SELECT * FROM Game WHERE gameId = :id")
    fun findGameById(id: Int): Game?
}