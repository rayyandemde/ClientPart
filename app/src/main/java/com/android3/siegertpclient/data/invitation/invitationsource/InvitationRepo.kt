package com.android3.siegertpclient.data.invitation.invitationsource

import com.android3.siegertpclient.data.invitation.invitationsource.invitationRemote.InvitationRemoteDataSource

/**
 * Invitation repository that calls the remote and local data source.
 */
class InvitationRepo () {

    private val invitationRemoteDataSource = InvitationRemoteDataSource()

    fun createInvitation(senderId : String, recipientId : String, tournamentId : String,
                         participantForm : String, token : String) : Invitation? {
        val newInvitation = invitationRemoteDataSource.createInvitation(senderId, recipientId, tournamentId, participantForm, token)
        return newInvitation
    }

    fun handleInvitationAcceptation(username: String, invitationID : String, accept : Boolean, token : String) {
        invitationRemoteDataSource.handleInvitationAcceptation(username, invitationID, accept, token)
    }
}