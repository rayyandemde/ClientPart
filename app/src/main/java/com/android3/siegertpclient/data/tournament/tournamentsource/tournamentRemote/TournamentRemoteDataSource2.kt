package com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote

import com.android3.siegertpclient.data.tournament.TournamentData
import com.android3.siegertpclient.data.tournament.TournamentTest
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.utils.RestClient2
import retrofit2.Response

class TournamentRemoteDataSource2 {

    suspend fun createNewTournament(username: String, surname: String, forename: String, userId: String, token: String) : Response<User> {
        val user = hashMapOf<String, String>()
        user["username"] = username
        user["surname"] = surname
        user["forename"] = forename
        user["userId"] = userId
        return RestClient2.userService.createNewUser(user, token)
    }

    suspend fun getTournamentById(tourneyId : String, token: String) : Response<TournamentTest> {
        return RestClient2.tournamentService.getTournamentById(tourneyId, token)
    }
}