package com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote

import com.android3.siegertpclient.data.payload.ApiResponse
import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.data.tournament.Game
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.tournament.TournamentDetail
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.utils.RestClient2
import retrofit2.Response

class TournamentRemoteDataSource2 {

    suspend fun createNewTournament(
        type : String,
        participantSize : Int,
        name : String,
        tournamentDetail : TournamentDetail,
        token : String) : Response<Tournament> {
        val tournament = hashMapOf<String, Any>()
        tournament["type"] = type
        tournament["participantSize"] = participantSize
        tournament["name"] = name
        tournament["tournamentDetail"] = tournamentDetail
        return RestClient2.tournamentService.createNewTournament(tournament, token)
    }

    suspend fun getTournamentById(tourneyId : String, token: String) : Response<Tournament> {
        return RestClient2.tournamentService.getTournamentById(tourneyId, token)
    }

    suspend fun getTournamentByName(tournamentName : String, token: String) : Response<Tournament> {
        return RestClient2.tournamentService.getTournamentByName(tournamentName, token)
    }

    suspend fun getTournamentParticipantsUser(tournamentName : String, token: String) : Response<List<User>> {
        return RestClient2.tournamentService.getTournamentParticipantsUser(tournamentName, token)
    }

    suspend fun getTournamentParticipantsTeam(tournamentName : String, token: String) : Response<List<Team>> {
        return RestClient2.tournamentService.getTournamentParticipantsTeam(tournamentName, token)
    }

    suspend fun getTournamentGames(tournamentName : String, token: String) : Response<List<Game>> {
        return RestClient2.tournamentService.getTournamentGames(tournamentName, token)
    }

    suspend fun getGameById(tournamentName : String, gameId : String,  token: String) : Response<Game> {
        return RestClient2.tournamentService.getGameById(tournamentName, gameId, token)
    }

    suspend fun handleParticipation(tournamentName: String, participation : String, token: String) : Response<ApiResponse> {
        val participationBody = hashMapOf<String, String>()
        participationBody["participation"] = participation
        return RestClient2.tournamentService.handleParticipation(tournamentName, participationBody, token)
    }

    suspend fun createGames(tournamentName : String, token: String) : Response<List<Game>> {
        return RestClient2.tournamentService.createGames(tournamentName, token)
    }

    suspend fun updateGameById(tournamentName : String, game : Game, token: String) : Response<Game> {
        return RestClient2.tournamentService.updateGameById(tournamentName, game.gameId, game, token)
    }

    suspend fun deleteTournament(tournamentName : String, token: String) : Response<ApiResponse> {
        return RestClient2.tournamentService.deleteTournament(tournamentName, token)
    }

    suspend fun deleteGameById(tournamentName : String, gameId : String, token: String) : Response<ApiResponse> {
        return RestClient2.tournamentService.deleteGameById(tournamentName, gameId, token)
    }


}