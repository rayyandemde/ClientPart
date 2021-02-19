package com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote

import com.android3.siegertpclient.data.game.Game
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.tournament.tournamentsource.ITournamentDataSource
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.utils.ParticipantFormUtil
import com.android3.siegertpclient.utils.TournamentTypesUtil
import java.util.*

class TournamentRemoteDataSource (private val tournamentService: TournamentService) : ITournamentDataSource {

    /*TODO include as soon as Tournament is updated
    private fun convertTRespToTournament(tResp : TournamentResponse) : Tournament {

    }*/

    fun createNewTournament(tournamentForm : String, tournamentSize : String, tournamentName: String,
                            tournamentDetail: TournamentDetail, ownUserId: String) : Tournament {
        val userCall = tournamentService.createNewTournament(tournamentForm, tournamentSize,
            tournamentName, tournamentDetail, ownUserId)
        val response = userCall.execute()
        if (!response.isSuccessful) {

            //TOdo implement error code
        }
        return response.body()
    }

    fun getTournamentById(tourneyId : String, ownUserId: String) : Tournament {
        val userCall = tournamentService.getTournamentById(tourneyId, ownUserId)
        val response = userCall.execute()
        if (!response.isSuccessful) {

            //TOdo implement error code
        }
        return response.body()
    }

    fun getTournamentByName(tournamentName : String, ownUserId: String) : Tournament {
        val userCall = tournamentService.getTournamentByName(tournamentName, ownUserId)
        val response = userCall.execute()
        if (!response.isSuccessful) {

            //TOdo implement error code
        }
        return response.body()
    }

    fun getTournamentParticipants(tournamentName : String, ownUserId: String) : Array<User> {
        val userCall = tournamentService.getTournamentParticipants(tournamentName, ownUserId)
        val response = userCall.execute()
        if (!response.isSuccessful) {

            //TOdo implement error code
        }
        return response.body()
    }

    fun updateTournamentDetailById(tournamentName : String, participantForm: ParticipantFormUtil, adminId : String,
                                   tournamentTypes: TournamentTypesUtil, typeOfGame : String, location : String,
                                   registrationDeadline : Date, startTime : Date, endTime : Date,
                                   ownUserId: String) : Tournament {
        val userCall = tournamentService.updateTournamentDetailById(tournamentName, participantForm, adminId,
            tournamentTypes, typeOfGame, location, registrationDeadline, startTime, endTime, ownUserId)
        val response = userCall.execute()
        if (!response.isSuccessful) {

            //TOdo implement error code
        }
        return response.body()
    }

    fun deleteTournament(tournamentName : String, ownUserId: String) : Boolean {
        val userCall = tournamentService.deleteTournament(tournamentName, ownUserId)
        val response = userCall.execute()
        if (!response.isSuccessful) {

            //TOdo implement error code
        }
        return response.body()
    }

    fun handleParticipation(tournamentName : String, participate : Map<String, Boolean>, ownUserId: String) : Boolean {
        val userCall = tournamentService.handleParticipation(tournamentName, participate, ownUserId)
        val response = userCall.execute()
        if (!response.isSuccessful) {

            //TOdo implement error code
        }
        return response.body()
    }

    fun getTournamentsGames(tournamentName : String, ownUserId: String) : Array<Game> {
        val userCall = tournamentService.getTournamentsGames(tournamentName, ownUserId)
        val response = userCall.execute()
        if (!response.isSuccessful) {

            //TOdo implement error code
        }
        return response.body()
    }

    fun createGames(tournamentName : String, ownUserId: String) : Array<Game> {
        val userCall = tournamentService.createGames(tournamentName, ownUserId)
        val response = userCall.execute()
        if (!response.isSuccessful) {

            //TOdo implement error code
        }
        return response.body()
    }
}