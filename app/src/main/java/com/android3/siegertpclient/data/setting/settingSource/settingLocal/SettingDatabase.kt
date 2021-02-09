package com.android3.siegertpclient.data.setting.settingSource.settingLocal

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Setting::class], version = 1, exportSchema = false)
abstract class SettingDatabase : RoomDatabase() {
    abstract val settingDao: SettingDao?

    companion object {
        private var INSTANCE: SettingDatabase? = null
        @Synchronized
        fun getDatabase(context: Context): SettingDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    SettingDatabase::class.java,
                    "setting_database"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
}