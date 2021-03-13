package com.android3.siegertpclient.data.tournament.tournamentsource

import com.android3.siegertpclient.data.tournament.TournamentData
import com.android3.siegertpclient.data.tournament.TournamentTest
import com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote.TournamentRemoteDataSource2
import com.android3.siegertpclient.data.user.User
import retrofit2.Response

class TournamentRepo2 {
    private val tournamentRemoteDataSource2 = TournamentRemoteDataSource2()

    suspend fun createNewTournament(
        username: String,
        forename: String,
        surname: String,
        userId: String,
        token: String
    ): Response<User> {
        return tournamentRemoteDataSource2.createNewTournament(username, surname, forename, userId, token)
    }

    suspend fun getTournamentById(tourneyId: String, token: String): Response<TournamentTest> {
        return tournamentRemoteDataSource2.getTournamentById(tourneyId, token)
    }
}