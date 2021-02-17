package com.android3.siegertpclient.data.invitation.invitationsource

import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.invitation.invitationsource.invitationRemote.InvitationRemoteDataSource
import com.android3.siegertpclient.utils.RestClient

class InvitationRepo () {

    private val restClient = RestClient()
    private val invitationService = restClient.getInvitationService()

    var invitationRemote = InvitationRemoteDataSource(invitationService)

    fun createInvitation(senderId : String, recipientId : String, tournamentId : String,
                         participantForm : String, token : String) : Invitation {
        val newInvitation = invitationRemote.createInvitation(senderId, recipientId, tournamentId, participantForm, token)
        return newInvitation
    }

    fun handleInvitationAcceptation(username: String, invitationID : String, accept : Boolean, token : String) {
        invitationRemote.handleInvitationAcceptation(username, invitationID, accept, token)
    }
}