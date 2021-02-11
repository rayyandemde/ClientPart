package com.android3.siegertpclient.data.user

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.android3.siegertpclient.data.user.userSource.userLocal.UserDao

@Database(entities = [User::class], version = 1, exportSchema = false)
@TypeConverters(RoomConverter::class)
abstract class UserDatabase : RoomDatabase() {
    abstract val userDao: UserDao?

    companion object {
        private var INSTANCE: UserDatabase? = null
        @Synchronized
        fun getDatabase(context: Context): UserDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, UserDatabase::class.java, "user_database") .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
}