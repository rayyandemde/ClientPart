package com.android3.siegertpclient.data.invitation.invitationsource.invitationLocal

import com.android3.siegertpclient.data.invitation.Invitation

class InvitationLocalDataSource(val invitationDao: InvitationDao) {
    fun saveInvitation(newInvitation: Invitation) {
        invitationDao.insertInvitation(newInvitation)
    }
}