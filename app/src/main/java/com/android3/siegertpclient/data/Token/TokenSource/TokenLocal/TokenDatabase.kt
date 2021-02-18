package com.android3.siegertpclient.data.Token.TokenSource.TokenLocal

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android3.siegertpclient.data.Token.Token
import com.android3.siegertpclient.data.game.Game
import com.android3.siegertpclient.data.game.gamesource.gameLocal.GameDao

@Database(entities = [Token::class], version = 1, exportSchema = false)
abstract class TokenDatabase : RoomDatabase() {
    abstract val tokenDao: TokenDao?

    companion object {
        private var INSTANCE: TokenDatabase? = null
        @Synchronized
        fun getDatabase(context: Context): TokenDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    TokenDatabase::class.java,
                    "game_database"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
}