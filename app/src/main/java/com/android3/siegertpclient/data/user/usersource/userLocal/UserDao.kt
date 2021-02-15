package com.android3.siegertpclient.data.user.usersource.userLocal

import androidx.room.*
import com.android3.siegertpclient.data.user.NotificationList
import com.android3.siegertpclient.data.user.TeamList
import com.android3.siegertpclient.data.user.TournamentList
import com.android3.siegertpclient.data.user.User


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

    @Query("SELECT team_list FROM User WHERE id = :id")
    fun getAllTeams(id: Int): TeamList

    @Query("SELECT tournament_list FROM User WHERE id = :id")
    fun getAllTournaments(id: Int): TournamentList


    @Query("SELECT notification_list FROM User WHERE id = :id")
    fun getAllNotifications(id: Int): NotificationList
}