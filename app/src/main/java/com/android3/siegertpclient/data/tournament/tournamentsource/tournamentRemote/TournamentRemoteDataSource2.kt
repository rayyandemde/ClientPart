package com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote

import com.android3.siegertpclient.data.payload.ApiResponse
import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.data.tournament.Game
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.tournament.TournamentDetail
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.utils.RestClient
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
        tournament["maxParticipantNumber"] = participantSize
        tournament["tournamentName"] = name
        tournament["tournamentDetail"] = tournamentDetail
        return RestClient.tournamentService.createNewTournament(tournament, token)
    }

    suspend fun getTournamentById(tourneyId : String, token: String) : Response<Tournament> {
        return RestClient.tournamentService.getTournamentById(tourneyId, token)
    }

    suspend fun getTournamentByName(tournamentName : String, token: String) : Response<Tournament> {
        return RestClient.tournamentService.getTournamentByName(tournamentName, token)
    }

    suspend fun getTournamentParticipantsUser(tournamentName : String, token: String) : Response<List<User>> {
        return RestClient.tournamentService.getTournamentParticipantsUser(tournamentName, token)
    }

    suspend fun getTournamentParticipantsTeam(tournamentName : String, token: String) : Response<List<Team>> {
        return RestClient.tournamentService.getTournamentParticipantsTeam(tournamentName, token)
    }

    suspend fun getTournamentGames(tournamentName : String, token: String) : Response<List<Game>> {
        return RestClient.tournamentService.getTournamentGames(tournamentName, token)
    }

    suspend fun getGameById(tournamentName : String, gameId : String,  token: String) : Response<Game> {
        return RestClient.tournamentService.getGameById(tournamentName, gameId, token)
    }

    suspend fun handleParticipation(tournamentName: String, participation : String, token: String) : Response<ApiResponse> {
        val participationBody = hashMapOf<String, String>()
        participationBody["participation"] = participation
        return RestClient.tournamentService.handleParticipation(tournamentName, participationBody, token)
    }

    suspend fun createGames(tournamentName : String, token: String) : Response<List<Game>> {
        return RestClient.tournamentService.createGames(tournamentName, token)
    }

    suspend fun updateGameById(tournamentName : String, game : Game, token: String) : Response<Game> {
        return RestClient.tournamentService.updateGameById(tournamentName, game.gameId, game, token)
    }

    suspend fun deleteTournament(tournamentName : String, token: String) : Response<ApiResponse> {
        return RestClient.tournamentService.deleteTournament(tournamentName, token)
    }

    suspend fun deleteGameById(tournamentName : String, gameId : String, token: String) : Response<ApiResponse> {
        return RestClient.tournamentService.deleteGameById(tournamentName, gameId, token)
    }

    suspend fun updateTournamentDetail(tournamentName: String, tournamentDetail: TournamentDetail, token: String) : Response<Tournament> {
        return RestClient.tournamentService.updateTournamentDetail(tournamentName, tournamentDetail, token)
    }


}