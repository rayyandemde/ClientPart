package com.android3.siegertpclient.data.user

import android.content.Context
import com.android3.siegertpclient.data.user.usersource.UserRepo
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.util.*
import androidx.test.core.app.ApplicationProvider

class UserRepoTest {
    private lateinit var repo: UserRepo

    @Before
    fun setupRepo() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val repo = UserRepo(context)
    }

    @Test
    suspend fun emptyToken() {
        var username = String
        val forename = String
        var surname = String
        var userId = String
        var token = String
        var newUser = repo.createNewUser("username", "forename", "surname", "userId", "")
        assertEquals(newUser, null)
    }
}