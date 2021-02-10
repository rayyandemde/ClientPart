package com.android3.siegertpclient.data.user.userSource

import com.android3.siegertpclient.data.user.userSource.userLocal.User
import com.android3.siegertpclient.data.user.userSource.userRemote.userRemoteDataSource

class userRepo : IUserDataSource {

    var userRemote : userRemoteDataSource = userRemoteDataSource()
    //var userLocal

    fun createNewUser (username : String, eMail : String, firstName : String, surname : String, password : String) : User {
        val list = mutableListOf<String>()
        //Todo implement getting new notification team and tournament list
        return User(username, firstName, surname, eMail, password, list, list, list)
    }
    /*
    fun getUserById (userId : String) : User {
        return userRemoteDataSource.
    }*/

}