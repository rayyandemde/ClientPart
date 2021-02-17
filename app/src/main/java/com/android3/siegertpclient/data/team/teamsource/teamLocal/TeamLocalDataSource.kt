package com.android3.siegertpclient.data.team.teamsource.teamLocal

import java.util.regex.Pattern

class TeamLocalDataSource(val teamDao: TeamDao) {
    fun check(teamName: String): Boolean {
        val b1 = Pattern.matches("[a-zA-Z0-9]", teamName)
        return if (b1) {
            true
        } else false
    }

    fun saveUser(newteam: Team) {
        teamDao.insertTeam(newteam)
    }
}