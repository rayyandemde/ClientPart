package com.android3.siegertpclient.data.invitation.invitationsource.invitationRemote

import com.android3.siegertpclient.data.invitation.Invitation

class InvitationRemoteDataSource (private val invitationService : InvitationService) {

    fun createInvitation(invitation : Invitation, ownUserId : String) : Invitation{
        val response = invitationService.createInvitation(invitation, ownUserId)
        return  response.body()
    }
}