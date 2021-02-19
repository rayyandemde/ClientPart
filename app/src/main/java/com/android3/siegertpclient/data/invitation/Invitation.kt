package com.android3.siegertpclient.data.invitation

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Invitation class used to implement as an Entity for the Room database.
 */
@Entity
data class Invitation(
    @PrimaryKey
    var invitationId: String,
    @ColumnInfo(name = "sender_name") var senderName: String,
    @ColumnInfo(name = "recipient_Username") var recipientUsername: String,
    @ColumnInfo(name = "tournamentId") var tournamentId: String,

    )
