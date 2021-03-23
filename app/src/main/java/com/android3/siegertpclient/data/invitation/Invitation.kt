package com.android3.siegertpclient.data.invitation.invitationsource

data class Invitation(
    val invitationId: String,
    val participantForm: String,
    val recipientId: String,
    val senderId: String,
    val senderUsername: String,
    val tournamentId: String,
    val tournamentName: String
)