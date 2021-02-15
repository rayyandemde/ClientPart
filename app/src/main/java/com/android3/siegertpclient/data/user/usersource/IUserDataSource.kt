package com.android3.siegertpclient.data.user.usersource

import com.android3.siegertpclient.data.user.usersource.userLocal.UserDao

interface IUserDataSource {
    abstract val userDao: UserDao?
}