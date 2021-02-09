package com.android3.siegertpclient.data.user.userSource.userLocal

import androidx.room.*
import com.android3.siegertpclient.data.team.teamSource.teamLocal.Member

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
    fun getAllTeams(id: Int): List<TeamOfUser?>?

    @Query("SELECT tournament_list FROM User WHERE id = :id")
    fun getAllTournaments(id: Int): List<TournamentOfUser?>?


    @Query("SELECT notification_list FROM User WHERE id = :id")
    fun getAllNotifications(id: Int): List<NotificationOfUser?>?
}