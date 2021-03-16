package com.android3.siegertpclient.data.tournament.tournamentsource

import android.content.Context
import com.android3.siegertpclient.data.payload.ApiResponse
import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.data.tournament.Game
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.tournament.TournamentDetail
import com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote.TournamentRemoteDataSource2
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.utils.PreferencesProvider
import com.android3.siegertpclient.utils.Token
import retrofit2.Response

class TournamentRepo2(private val context: Context) {
    private val tournamentRemoteDataSource2 = TournamentRemoteDataSource2()
    private var localData = PreferencesProvider(context)

    suspend fun createNewTournament(
        type : String,
        participantSize: Int,
        name : String,
        tournamentDetail : TournamentDetail
    ): Tournament? {
        val response = tournamentRemoteDataSource2.createNewTournament(type,
            participantSize, name, tournamentDetail, Token.getBearerToken(context)!!)
        if (response.isSuccessful) {
            localData.putCurrentTournament(response.body()!!)
            return response.body()!!
        }
        return null
    }

    suspend fun getTournamentById(tourneyId: String): Tournament? {
        val response =
            tournamentRemoteDataSource2.getTournamentById(tourneyId, Token.getBearerToken(context)!!)
        if (response.isSuccessful) {
            localData.putCurrentTournament(response.body()!!)
            return response.body()!!
        }
        return null
    }

    suspend fun getTournamentByName(tourneyName: String): Tournament? {
        val response =
            tournamentRemoteDataSource2.getTournamentByName(tourneyName, Token.getBearerToken(context)!!)
        if (response.isSuccessful) {
            localData.putCurrentTournament(response.body()!!)
            return response.body()!!
        }
        return null
    }

    suspend fun getTournamentParticipantsUser(tournamentName : String) : List<User>? {
        val response =
            tournamentRemoteDataSource2.getTournamentParticipantsUser(tournamentName,
                Token.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun getTournamentParticipantsTeam(tournamentName : String) : List<Team>? {
        val response =
            tournamentRemoteDataSource2.getTournamentParticipantsTeam(tournamentName,
                Token.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun getTournamentGames(tournamentName : String) : List<Game>? {
        val response =
            tournamentRemoteDataSource2.getTournamentGames(tournamentName,
                Token.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun getGameById(tournamentName : String, gameId : String) : Game? {
        val response =
            tournamentRemoteDataSource2.getGameById(tournamentName, gameId,
                Token.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun handleParticipation(tournamentName : String, participation : String) : ApiResponse? {
        val response =
            tournamentRemoteDataSource2.handleParticipation(tournamentName, participation,
                Token.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun createGames(tournamentName : String) : List<Game>? {
        val response =
            tournamentRemoteDataSource2.createGames(tournamentName,
                Token.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun updateGameById(tournamentName : String, game : Game) : Game? {
        val response =
            tournamentRemoteDataSource2.updateGameById(tournamentName, game,
                Token.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun deleteTournament(tournamentName : String) : ApiResponse? {
        val response =
            tournamentRemoteDataSource2.deleteTournament(tournamentName,
                Token.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun deleteGameById(tournamentName : String, gameId : String) : ApiResponse? {
        val response =
            tournamentRemoteDataSource2.deleteGameById(tournamentName, gameId,
                Token.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun updateTournamentDetail(tournamentName : String, tournamentDetail: TournamentDetail) : Tournament? {
        val response =
            tournamentRemoteDataSource2.updateTournamentDetail(tournamentName, tournamentDetail,
                Token.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

}