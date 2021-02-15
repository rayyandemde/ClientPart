package com.android3.siegertpclient.data.invitation.invitationsource.invitationRemote

import com.android3.siegertpclient.data.invitation.Invitation

class InvitationRemoteDataSource (private val invitationService : InvitationService) {

    fun createInvitation(invitation : Invitation) : Invitation{
        val response = invitationService.createInvitation(invitation)
        return  response.body()
    }
}