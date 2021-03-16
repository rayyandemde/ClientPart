//package com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote
//
//import com.android3.siegertpclient.data.game.Game
//import com.android3.siegertpclient.data.tournament.Tournament
//import com.android3.siegertpclient.data.tournament.tournamentsource.ITournamentDataSource
//import com.android3.siegertpclient.data.user.User
//import java.util.*
//
//class TournamentRemoteDataSource (private val tournamentService: TournamentService) : ITournamentDataSource {
//
//    private fun convertTRespToTournament() : Tournament? {
//        return null
//    }
//
//    fun createNewTournament(tournamentForm : String, tournamentSize : String, tournamentName: String, ownUserId: String) : Tournament? {
//        return null
//    }
//
//    fun getTournamentById(tourneyId : String, ownUserId: String) : Tournament? {
//        val userCall = tournamentService.getTournamentById(tourneyId, ownUserId)
//        val response = userCall.execute()
//        if (!response.isSuccessful) {
//
//            //TOdo implement error code
//        }
//        return null
//    }
//
//    fun getTournamentByName(tournamentName : String, ownUserId: String) : Tournament? {
//        val userCall = tournamentService.getTournamentByName(tournamentName, ownUserId)
//        val response = userCall.execute()
//        if (!response.isSuccessful) {
//
//            //TOdo implement error code
//        }
//        return null
//    }
//
//    fun getTournamentParticipants(tournamentName : String, ownUserId: String) : Array<User>? {
//        val userCall = tournamentService.getTournamentParticipants(tournamentName, ownUserId)
//        val response = userCall.execute()
//        if (!response.isSuccessful) {
//
//            //TOdo implement error code
//        }
//        return response.body()
//    }
//
//    fun updateTournamentDetailById(tournamentName : String, adminId : String, typeOfGame : String, location : String,
//                                   registrationDeadline : Date, startTime : Date, endTime : Date,
//                                   ownUserId: String) : Tournament? {
//        return null
//    }
//
//    fun deleteTournament(tournamentName : String, ownUserId: String) : Boolean? {
//        val userCall = tournamentService.deleteTournament(tournamentName, ownUserId)
//        val response = userCall.execute()
//        if (!response.isSuccessful) {
//
//            //TOdo implement error code
//        }
//        return response.body()
//    }
//
//    fun handleParticipation(tournamentName : String, participate : Map<String, Boolean>, ownUserId: String) : Boolean? {
//        val userCall = tournamentService.handleParticipation(tournamentName, participate, ownUserId)
//        val response = userCall.execute()
//        if (!response.isSuccessful) {
//
//            //TOdo implement error code
//        }
//        return response.body()
//    }
//
//    fun getTournamentsGames(tournamentName : String, ownUserId: String) : Array<Game>? {
//        val userCall = tournamentService.getTournamentsGames(tournamentName, ownUserId)
//        val response = userCall.execute()
//        if (!response.isSuccessful) {
//
//            //TOdo implement error code
//        }
//        return response.body()
//    }
//
//    fun createGames(tournamentName : String, ownUserId: String) : Array<Game>? {
//        val userCall = tournamentService.createGames(tournamentName, ownUserId)
//        val response = userCall.execute()
//        if (!response.isSuccessful) {
//
//            //TOdo implement error code
//        }
//        return response.body()
//    }
//}