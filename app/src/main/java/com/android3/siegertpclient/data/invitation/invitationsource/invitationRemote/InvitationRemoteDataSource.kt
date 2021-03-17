package com.android3.siegertpclient.data.invitation.invitationsource.invitationRemote

import com.android3.siegertpclient.data.invitation.Invitation

class InvitationRemoteDataSource () {

    fun createInvitation(senderId : String, recipientId : String, tournamentId : String,
                         participantForm : String, ownUserId : String) : Invitation? {
        return  null
    }

    fun handleInvitationAcceptation (username: String, invitationId : String, acceptB : Boolean, ownUserId : String) {
        val map = hashMapOf<String, Boolean>()
        map["access"] = acceptB
    }

}