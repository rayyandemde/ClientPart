package com.android3.siegertpclient.data.Result.resultsource.resultLocal

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android3.siegertpclient.data.Result.Result

/**
 * Room database use result as entity.
 */
@Database(entities = [Result::class], version = 1, exportSchema = false)
abstract class ResultDatabase : RoomDatabase() {
    abstract val resultDao: ResultDao?

    companion object {
        private var INSTANCE: ResultDatabase? = null
        @Synchronized
        fun getDatabase(context: Context): ResultDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    ResultDatabase::class.java,
                    "result_database"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
}