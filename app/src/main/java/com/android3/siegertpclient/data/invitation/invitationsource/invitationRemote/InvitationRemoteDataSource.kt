package com.android3.siegertpclient.data.invitation.invitationsource.invitationRemote

import com.android3.siegertpclient.data.invitation.Invitation

class InvitationRemoteDataSource (private val invitationService : InvitationService) {

    fun createInvitation(senderId : String, recipientId : String, tournamentId : String,
                         participantForm : String, ownUserId : String) : Invitation {
        val response = invitationService.createInvitation(senderId, recipientId, tournamentId,participantForm, ownUserId)
        return  response.body()
    }

    fun handleInvitationAcceptation (username: String, invitationId : String, acceptB : Boolean, ownUserId : String) {
        val map = hashMapOf<String, Boolean>()
        map["access"] = acceptB
        val response = invitationService.handleInvitationAcceptation(username, invitationId, map, ownUserId)
    }

}