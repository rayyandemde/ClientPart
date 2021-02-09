package com.android3.siegertpclient.data.team.teamSource.teamLocal

import androidx.room.*

@Dao
interface TeamDao {
    @Insert
    fun insertTeam(vararg teams: Team?)

    @Update
    fun updateTeam(vararg teams: Team?)

    @Delete
    fun deleteTeam(vararg teams: Team?)

    @Query("DELETE FROM Team")
    fun deleteAllTeam()

    @get:Query("SELECT * FROM Team ORDER BY teamId DESC")
    val allTeams: List<Team?>?

    @Query("SELECT * FROM Team WHERE team_name = :name")
    fun findTeamByName(name: String?): Team?

    @Query("SELECT * FROM Team WHERE teamId = :id")
    fun findTeamById(id: Int): Team?

    @Query("SELECT member_list FROM Team WHERE teamId = :id")
    fun findMember(id: Int): List<Member?>?
}