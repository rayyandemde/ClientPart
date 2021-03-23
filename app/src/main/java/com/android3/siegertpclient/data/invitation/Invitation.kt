package com.android3.siegertpclient.data.invitation

data class Invitation(
    val invitationId: String,
    val participantForm: String,
    val recipientId: String,
    val senderId: String,
    val tournamentId: String
)