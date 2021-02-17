package com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote

import com.android3.siegertpclient.data.game.Game
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.tournament.tournamentsource.ITournamentDataSource
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.utils.ParticipantFormUtil
import com.android3.siegertpclient.utils.TournamentTypesUtil
import retrofit2.Response
import retrofit2.http.*
import java.util.*

class TournamentRemoteDataSource (private val tournamentService: TournamentService) : ITournamentDataSource {

    //TODO change param
    fun createNewTournament(tournament : Tournament, ownUserId: String) : Tournament {
        val response = tournamentService.createNewTournament(tournament, ownUserId)
        return response.body()
    }

    fun getTournamentById(tourneyId : String, ownUserId: String) : Tournament {
        val response = tournamentService.getTournamentById(tourneyId, ownUserId)
        return response.body()
    }

    fun getTournamentByName(tournamentName : String, ownUserId: String) : Tournament {
        val response = tournamentService.getTournamentByName(tournamentName, ownUserId)
        return response.body()
    }

    fun getTournamentParticipants(tournamentName : String, ownUserId: String) : Array<User> {
        val response = tournamentService.getTournamentParticipants(tournamentName, ownUserId)
        return response.body()
    }

    fun updateTournamentDetailById(tournamentName : String, participantForm: ParticipantFormUtil, adminId : String,
                                   tournamentTypes: TournamentTypesUtil, typeOfGame : String, location : String,
                                   registrationDeadline : Date, startTime : Date, endTime : Date,
                                   ownUserId: String) : Tournament {
        val response = tournamentService.updateTournamentDetailById(tournamentName, participantForm, adminId,
            tournamentTypes, typeOfGame, location, registrationDeadline, startTime, endTime, ownUserId)
        return response.body()
    }

    fun deleteTournament(tournamentName : String, ownUserId: String) : Boolean {
        val response = tournamentService.deleteTournament(tournamentName, ownUserId)
        return response.body()
    }

    fun handleParticipation(tournamentName : String, participate : Map<String, Boolean>, ownUserId: String) : Boolean {
        val response = tournamentService.handleParticipation(tournamentName, participate, ownUserId)
        return response.body()
    }

    fun getTournamentsGames(tournamentName : String, ownUserId: String) : Array<Game> {
        val response = tournamentService.getTournamentsGames(tournamentName, ownUserId)
        return response.body()
    }

    fun createGames(tournamentName : String, ownUserId: String) : Array<Game> {
        val response = tournamentService.createGames(tournamentName, ownUserId)
        return response.body()
    }
}