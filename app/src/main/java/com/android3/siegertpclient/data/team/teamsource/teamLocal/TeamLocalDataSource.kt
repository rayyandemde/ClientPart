package com.android3.siegertpclient.data.team.teamsource.teamLocal

import com.android3.siegertpclient.data.tournament.Tournament
import java.util.regex.Pattern
/**
 * Local data source of the team.
 */
class TeamLocalDataSource(val teamDao: TeamDao) {
    fun check(teamName: String): Boolean {
        val b1 = Pattern.matches("[a-zA-Z0-9]", teamName)
        return if (b1) {
            true
        } else false
    }

    fun saveTeam(newteam: Team) {
        teamDao.insertTeam(newteam)
    }
    fun getUser(){
        teamDao!!.allTeams
    }
    fun deleteUser(){
        teamDao!!.deleteAllTeam()
    }
    fun updateUser(team :Team){
        teamDao!!.updateTeam(team)
    }
}