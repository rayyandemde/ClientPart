package com.android3.siegertpclient.data.invitation.invitationsource

import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.invitation.invitationsource.invitationRemote.InvitationRemoteDataSource
import com.android3.siegertpclient.utils.RestClient

class InvitationRepo (private val ownUserId : String) {

    private val restClient = RestClient()
    private val invitationService = restClient.getInvitationService()

    var invitationRemote = InvitationRemoteDataSource(invitationService)

    fun createInvitation(invitationId : String, senderName : String, recipientName : String, tournamentId : String) {
        val newInvitation = Invitation(invitationId, senderName, recipientName, tournamentId)
        invitationService.createInvitation(newInvitation, ownUserId)
    }
}