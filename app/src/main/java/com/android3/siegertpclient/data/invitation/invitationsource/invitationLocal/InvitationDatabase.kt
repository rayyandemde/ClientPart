package com.android3.siegertpclient.data.invitation.invitationsource.invitationLocal

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android3.siegertpclient.data.invitation.Invitation

/**
 * Roomdatabase use to store the invitation.
 */
@Database(entities = [Invitation::class], version = 1, exportSchema = false)
abstract class InvitationDatabase : RoomDatabase() {
    abstract val invitationDao: InvitationDao?

    companion object {
        private var INSTANCE: InvitationDatabase? = null
        @Synchronized
        fun getDatabase(context: Context): InvitationDatabase? {
            if (INSTANCE == null) {
                Room.databaseBuilder(
                    context.applicationContext,
                    InvitationDatabase::class.java,
                    "invitation_database"
                )
                    .allowMainThreadQueries()
                    .build().also { INSTANCE = it }
            }
            return INSTANCE
        }
    }
}