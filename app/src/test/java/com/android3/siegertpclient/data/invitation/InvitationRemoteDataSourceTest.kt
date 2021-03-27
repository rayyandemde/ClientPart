package com.android3.siegertpclient.data.invitation

import com.android3.siegertpclient.data.invitation.invitationsource.invitationRemote.InvitationRemoteDataSource
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class InvitationRemoteDataSourceTest {

    private var inviRemote = InvitationRemoteDataSource()

    @Test//TODO update when function is implemented
    fun createInviTest() = runBlocking{
        var test = inviRemote.createInvitation("", "", "","", "")
        Assert.assertNotEquals(null, test)
    }

    @Test//TODO update when function is implemented
    fun handleInvitationTest() = runBlocking {
        inviRemote.handleInvitationAcceptation("", true, "")
        Assert.assertNotEquals(null, inviRemote)
    }
}