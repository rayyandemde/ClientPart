package com.android3.siegertpclient.data.user

import androidx.room.*

@Dao
interface UserDao {
    @Insert
    fun insertUsers(vararg users: User?)

    @Update
    fun updateUsers(vararg users: User?)

    @Delete
    fun deleteUsers(vararg users: User?)

    @Query("DELETE From User")
    fun deleteAllUsers()

    @get:Query("SELECT * FROM User ORDer by id desc")
    val allUsers: List<User?>?

    @Query("SELECT * FROM User WHERE id = :id")
    fun findUserById(id: Int): User?

    @Query("SELECT * FROM User where email = :Email")
    fun findUserById(Email: String?): User?
}