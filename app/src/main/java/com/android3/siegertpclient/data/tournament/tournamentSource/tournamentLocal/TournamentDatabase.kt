package com.android3.siegertpclient.data.tournament.tournamentSource.tournamentLocal

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Tournament::class], version = 1, exportSchema = false)
abstract class TournamentDatabase : RoomDatabase() {
    abstract val tournamentDao: TournamentDao?

    companion object {
        private var INSTANCE: TournamentDatabase? = null
        @Synchronized
        fun getDatabase(context: Context): TournamentDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    TournamentDatabase::class.java,
                    "word_database"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
}