package com.android3.siegertpclient.data.user

import android.content.Context
import com.android3.siegertpclient.data.user.usersource.UserRepo
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.util.*
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.runBlocking

class UserRepoTest {
    private lateinit var repo: UserRepo
/*
    @Before
    fun setupRepo() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        repo = UserRepo(context)
    }

    @Test
    fun emptyToken() = runBlocking {
        var newUser = repo.createNewUser("username", "forename", "surname", "userId", "")
        assertEquals(newUser, null)
    }*/
}