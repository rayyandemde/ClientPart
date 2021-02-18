package com.android3.siegertpclient.data.Token.TokenSource.TokenLocal

import androidx.room.*
import com.android3.siegertpclient.data.Token.Token
import com.android3.siegertpclient.data.game.Game

@Dao
interface TokenDao {
    @Insert
    fun insertToken(vararg tokens : Token?)

    @Update
    fun updateToken(vararg tokens : Token?)

    @Delete
    fun deleteToken(vararg tokens : Token?)

    @Query("DELETE FROM Token")
    fun deleteAllTokens()

    @Query("SELECT * FROM Token")
    fun getAllTokens():List<Token?>?
}