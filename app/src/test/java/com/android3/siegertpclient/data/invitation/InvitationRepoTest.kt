package com.android3.siegertpclient.data.invitation

import com.android3.siegertpclient.data.invitation.invitationsource.InvitationRepo
import org.junit.Assert
import org.junit.Test

class InvitationRepoTest {

    private var inviRepo = InvitationRepo()

    @Test//TODO update when function is implemented
    fun createInviTest(){
        var test = inviRepo.createInvitation("", "", "","", "")
        Assert.assertEquals(null, test)
    }

    @Test//TODO update when function is implemented
    fun handleInvitationTest() {
        inviRepo.handleInvitationAcceptation("", "", true, "")
    }
}