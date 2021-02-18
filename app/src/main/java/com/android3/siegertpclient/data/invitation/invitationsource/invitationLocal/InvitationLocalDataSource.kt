package com.android3.siegertpclient.data.invitation.invitationsource.invitationLocal

import com.android3.siegertpclient.data.Result.Result
import com.android3.siegertpclient.data.invitation.Invitation

class InvitationLocalDataSource(val invitationDao: InvitationDao) {
    fun saveInvitation(newInvitation: Invitation) {
        invitationDao.insertInvitation(newInvitation)
    }
    fun getInvitation(){
        invitationDao.allInvitations
    }
    fun deleteResult(){
        invitationDao.deleteAllInvitations()
    }
    fun updateResult(invitation: Invitation){
        invitationDao.updateInvitation(invitation)
    }
}