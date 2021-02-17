package com.android3.siegertpclient.data.tournament.tournamentsource

import com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote.TournamentRemoteDataSource
import com.android3.siegertpclient.utils.RestClient

class TournamentRepo {

    private val restClient = RestClient()
    private val tournamentService = restClient.getTournamentService()

    private val tournamentRemote = TournamentRemoteDataSource(tournamentService)
}