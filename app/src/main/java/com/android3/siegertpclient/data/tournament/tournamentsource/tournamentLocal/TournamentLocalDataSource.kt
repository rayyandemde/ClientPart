package com.android3.siegertpclient.data.tournament.tournamentsource.tournamentLocal

import com.android3.siegertpclient.data.tournament.Tournament
import java.util.regex.Pattern

class TournamentLocalDataSource(val tournamentDao: TournamentDao) {
    fun check(tournamentName: String): Boolean {
        val b1 = Pattern.matches("[a-zA-Z0-9]", tournamentName)
        return if (b1) {
            true
        } else false
    }

    fun saveUser(newtournament: Tournament) {
        tournamentDao.insertTournaments(newtournament)
    }
}