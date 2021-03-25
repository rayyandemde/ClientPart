package com.android3.siegertpclient.data.user

import com.android3.siegertpclient.data.user.usersource.userRemote.UserRemoteDataSource
import kotlinx.coroutines.runBlocking
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.ResponseBody
import org.junit.Assert
import org.junit.Test
import retrofit2.Response

class UserRemoteDataSourceTest {

    private var userRemote = UserRemoteDataSource()

    @Test
    fun responseSuccessfulNewUser() = runBlocking {
        var newUser = userRemote.createNewUser("username", "forename", "surname", "userId", "123")
        Assert.assertNotEquals(null, newUser)
    }

    @Test
    fun responseSuccessfulGetUserById() = runBlocking {
        var newUser = userRemote.getUserById("userId", "123")
        Assert.assertNotEquals(null, newUser)
    }

    @Test
    fun responseSuccessfulGetUserByUsername() = runBlocking {
        var newUser = userRemote.getUserByUsername("username", "123")
        Assert.assertNotEquals(null, newUser)
    }

    @Test
    fun responseSuccessfulUpdateUserDetail() = runBlocking {
        var newUser = userRemote.updateUserDetail("username", "newU", "surname",
            "forename", "123")
        Assert.assertNotEquals(null, newUser)
    }

    @Test
    fun responseSuccessfulGetUsersInvitations() = runBlocking {
        var newUser = userRemote.getUsersInvitations("username", "123")
        Assert.assertNotEquals(null, newUser)
    }

    @Test
    fun responseSuccessfulGetUsersTeams() = runBlocking {
        var newUser = userRemote.getUsersTeams("username", "123")
        Assert.assertNotEquals(null, newUser)
    }

    @Test
    fun responseSuccessfulGetUsersTournaments() = runBlocking {
        var newUser = userRemote.getUsersTournaments("username", "123")
        Assert.assertNotEquals(null, newUser)
    }

    @Test
    fun emptyToken() = runBlocking {
        var newUser = userRemote.createNewUser("username", "forename", "surname", "userId", "")
        //Assert.assertEquals(Response.error(500, ResponseBody.create("message=")), newUser)TODO implement body
        //retrofit2.Response<Response{protocol=http/1.1, code=500, message=, url=https://sieger-teamthree.herokuapp.com/users}>
    }
}