package com.android3.siegertpclient.data.user.usersource.userLocal

import com.android3.siegertpclient.data.user.User
import java.util.regex.Pattern

class UserLocalDataSource {
    private val userDao: UserDao? = null
    fun check(firstname: String, surname: String?, password: String, eMail: String): Boolean {
        val b1 = Pattern.matches("[a-zA-Z]", firstname) && Pattern.matches("[a-zA-Z]", firstname)
        val b2 = Pattern.matches("[a-zA-Z0-9]", password)
        val b3 = Pattern.matches(
            "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$",
            eMail
        )
        return if (b1 && b2 && b3) {
            true
        } else false
    }

    fun saveUser(newUser: User) {
        userDao!!.insertUsers(newUser)
    }

    val ownUserId: List<String>
        get() = userDao!!.getAllUser()
}