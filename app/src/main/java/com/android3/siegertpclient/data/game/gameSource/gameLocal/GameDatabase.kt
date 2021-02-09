package com.android3.siegertpclient.data.game.gameSource.gameLocal

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Game::class], version = 1, exportSchema = false)
abstract class GameDatabase : RoomDatabase() {
    abstract val gameDao: GameDao?

    companion object {
        private var INSTANCE: GameDatabase? = null
        @Synchronized
        fun getDatabase(context: Context): GameDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    GameDatabase::class.java,
                    "game_database"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
}