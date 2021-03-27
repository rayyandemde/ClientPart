package com.android3.siegertpclient.data.invitation

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.android3.siegertpclient.data.invitation.invitationsource.InvitationRepo
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class InvitationRepoTest {

    private lateinit var repo : InvitationRepo

    @Before
    fun setupRepo() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        repo = InvitationRepo(context)
    }

    @Test//TODO update when function is implemented
    fun createInviTest() = runBlocking{
        var test = repo.invite("")
        Assert.assertEquals(null, test)
    }

    @Test//TODO update when function is implemented
    fun handleInvitationTest() = runBlocking {
        repo.handleInvitationAcceptation("", true)
    }
}