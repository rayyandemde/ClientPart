package com.android3.siegertpclient.data.team.teamSource.teamLocal

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Team::class], version = 1, exportSchema = false)
abstract class TeamDatabase : RoomDatabase() {
    abstract val teamDao: TeamDao?

    companion object {
        private var INSTANCE: TeamDatabase? = null
        @Synchronized
        fun getDatabase(context: Context): TeamDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    TeamDatabase::class.java,
                    "team_database"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
}