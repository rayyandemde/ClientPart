package com.android3.siegertpclient.data.tournament.tournamentsource

import com.android3.siegertpclient.data.game.Game
import com.android3.siegertpclient.data.tournament.TournamentData
import com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote.Tournament
import com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote.TournamentDetail
import com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote.TournamentRemoteDataSource
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.utils.ParticipantFormUtil
import com.android3.siegertpclient.utils.RestClient
import com.android3.siegertpclient.utils.TournamentTypesUtil
import java.util.*

class TournamentRepo {

    private val restClient = RestClient()
    private val tournamentService = restClient.getTournamentService()

    private val tournamentRemote = TournamentRemoteDataSource(tournamentService)

    fun createNewTournament(
        tournamentForm: String, tournamentSize: String, tournamentName: String,
        tournamentDetail: TournamentDetail, ownUserId: String
    ): TournamentData {
        return tournamentRemote.createNewTournament(
            tournamentForm, tournamentSize,
            tournamentName, tournamentDetail, ownUserId
        )
    }

    fun getTournamentById(tourneyId: String, ownUserId: String): Tournament {
        return tournamentRemote.getTournamentById(tourneyId, ownUserId)
    }

    fun getTournamentByName(tournamentName: String, ownUserId: String): TournamentData {
        return tournamentRemote.getTournamentByName(tournamentName, ownUserId)
    }

    fun getTournamentParticipants(tournamentName: String, ownUserId: String): Array<User> {
        return tournamentRemote.getTournamentParticipants(tournamentName, ownUserId)
    }

    fun updateTournamentDetailById(
        tournamentName: String, participantForm: ParticipantFormUtil, adminId: String,
        tournamentTypes: TournamentTypesUtil, typeOfGame: String, location: String,
        registrationDeadline: Date, startTime: Date, endTime: Date,
        ownUserId: String
    ): TournamentData {
        return tournamentRemote.updateTournamentDetailById(
            tournamentName, participantForm, adminId, tournamentTypes,
            typeOfGame, location, registrationDeadline, startTime, endTime, ownUserId
        )
    }

    fun deleteTournament(tournamentName : String, ownUserId: String) : Boolean {
        return tournamentRemote.deleteTournament(tournamentName, ownUserId)
    }

    fun handleParticipation(tournamentName : String, participate : Map<String, Boolean>, ownUserId: String) : Boolean {
        return tournamentRemote.handleParticipation(tournamentName, participate, ownUserId)
    }

    fun getTournamentsGames(tournamentName : String, ownUserId: String) : Array<Game> {
        return tournamentRemote.getTournamentsGames(tournamentName, ownUserId)
    }

    fun createGames(tournamentName : String, ownUserId: String) : Array<Game> {
        return tournamentRemote.createGames(tournamentName, ownUserId)
    }
}


