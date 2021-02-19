package com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote

import com.android3.siegertpclient.data.game.Game
import com.android3.siegertpclient.data.tournament.TournamentData
import com.android3.siegertpclient.data.tournament.tournamentsource.ITournamentDataSource
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.utils.ParticipantFormUtil
import com.android3.siegertpclient.utils.TournamentState
import com.android3.siegertpclient.utils.TournamentTypesUtil
import java.net.CacheResponse
import java.util.*

class TournamentRemoteDataSource (private val tournamentService: TournamentService) : ITournamentDataSource {

    private fun convertTRespToTournament(tResp : Map<String, Any?>) : TournamentData {

    }
    private fun convertToLeague(response: Map<String, Any?>):TournamentLeague{
        val tournamentId: String = response.get("tournamentId").toString()
        val detail : TournamentDetail = response.get("tournamentDetail") as TournamentDetail


        return TournamentLeague(tournamentId,detail,response.get("gameList") as List<String>,
            response.get("participantList") as List<String>,response.get("tournamentName") as String,
            response.get("maxParticipantNumber") as Int, response.get("currentState") as TournamentState,
            response.get("leagueTable") as LeagueTable)
    }

    fun createNewTournament(tournamentForm : String, tournamentSize : String, tournamentName: String,
                            tournamentDetail: TournamentDetail, ownUserId: String) : TournamentData {
        val userCall = tournamentService.createNewTournament(tournamentForm, tournamentSize,
            tournamentName, tournamentDetail, ownUserId)
        val response = userCall.execute()
        if (!response.isSuccessful) {

            //TOdo implement error code
        }
        return convertTRespToTournament(response.body())
    }

    fun getTournamentById(tourneyId : String, ownUserId: String) : Tournament {
        val userCall = tournamentService.getTournamentById(tourneyId, ownUserId)
        val response = userCall.execute()
        if (!response.isSuccessful) {

            //TOdo implement error code
        }
        if(response.body()["type"]?.equals("League") == true){
            return convertToLeague(response.body())
        }
        if(response.body()["type"]?.equals("KnockOut") == true){
            return convertToLeague(response.body())
        }
        if(response.body()["type"]?.equals("KnockOutWithGroup") == true){
            return convertToLeague(response.body())
        }
    }

    fun getTournamentByName(tournamentName : String, ownUserId: String) : TournamentData {
        val userCall = tournamentService.getTournamentByName(tournamentName, ownUserId)
        val response = userCall.execute()
        if (!response.isSuccessful) {

            //TOdo implement error code
        }
        return convertTRespToTournament(response.body())
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
                                   ownUserId: String) : TournamentData {
        val userCall = tournamentService.updateTournamentDetailById(tournamentName, participantForm, adminId,
            tournamentTypes, typeOfGame, location, registrationDeadline, startTime, endTime, ownUserId)
        val response = userCall.execute()
        if (!response.isSuccessful) {

            //TOdo implement error code
        }
        return convertTRespToTournament(response.body())
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