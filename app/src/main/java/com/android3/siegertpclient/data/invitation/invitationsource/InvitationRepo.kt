package com.android3.siegertpclient.data.invitation.invitationsource

import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.invitation.invitationsource.invitationRemote.InvitationRemoteDataSource
import com.android3.siegertpclient.utils.RestClient

class InvitationRepo (private val ownUserId : String) {

    private val restClient = RestClient()
    private val invitationService = restClient.getInvitationService()

    var invitationRemote = InvitationRemoteDataSource(invitationService)

    fun createInvitation(senderId : String, recipientId : String, tournamentId : String,
                         participantForm : String) : Invitation {
        val newInvitation = invitationRemote.createInvitation(senderId, recipientId, tournamentId, participantForm, ownUserId)
        return newInvitation
    }

    fun handleInvitationAcceptation(username: String, invitationID : String, accept : Boolean) {
        invitationRemote.handleInvitationAcceptation(username, invitationID, accept, ownUserId)
    }
}