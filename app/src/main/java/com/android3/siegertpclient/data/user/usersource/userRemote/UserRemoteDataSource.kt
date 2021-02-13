package com.android3.siegertpclient.data.user.usersource.userRemote

import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.data.user.usersource.IUserDataSource

class UserRemoteDataSource (private val userService : UserService) : IUserDataSource {

    fun createNewUser (user: User)  {
        val response = userService.createNewUser(user)
    }

    fun getUserById (userId : String) : User {
        val response = userService.getUserById(userId)
        if (response.isSuccessful) {
             //val user = response.body()
            //TOdo implement error code
        }
        return response.body()
    }

    fun getUserByUsername (username : String) : User {
        val response = userService.getUserByUsername(username)
        if (response.isSuccessful) {
            //val user = response.body()
            //TOdo implement error code
        }
        return response.body()
    }

}