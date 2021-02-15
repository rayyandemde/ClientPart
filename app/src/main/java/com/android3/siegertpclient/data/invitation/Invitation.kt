package com.android3.siegertpclient.data.invitation

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Invitation(
    @PrimaryKey(autoGenerate = true)
    var invitationId: Int,
    @ColumnInfo(name = "sender_name") var senderName: String,
    @ColumnInfo(name = "recipient_Username") var recipientUsername: String,
    @ColumnInfo(name = "tournamentId") var tournamentId: String,

    )
