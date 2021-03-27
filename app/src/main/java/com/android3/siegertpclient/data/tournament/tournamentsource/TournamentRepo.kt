package com.android3.siegertpclient.data.tournament.tournamentsource

import android.content.Context
import com.android3.siegertpclient.data.payload.ApiResponse
import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.data.tournament.CreateTournament
import com.android3.siegertpclient.data.tournament.Game
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.tournament.TournamentDetail
import com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote.TournamentRemoteDataSource
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.utils.Constants.Companion.KEY_TOURNAMENT_ID
import com.android3.siegertpclient.utils.Constants.Companion.KEY_TOURNAMENT_NAME
import com.android3.siegertpclient.utils.LocalCache
import com.android3.siegertpclient.utils.PreferencesProvider

class TournamentRepo(private val context: Context) {
    private val tournamentRemoteDataSource = TournamentRemoteDataSource()
    private var localData = PreferencesProvider(context)

    suspend fun createNewTournament(
        type : String,
        maxParticipantNumber: Int,
        tournamentName : String,
        tournamentDetail : TournamentDetail
    ): Tournament? {
        val createTournament = CreateTournament(maxParticipantNumber, tournamentDetail, tournamentName, type)
        val response = tournamentRemoteDataSource.createNewTournament(createTournament, LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            localData.putCurrentTournament(response.body()!!)
            localData.putString(KEY_TOURNAMENT_ID, response.body()!!.tournamentId)
            localData.putString(KEY_TOURNAMENT_NAME, tournamentName)
            return response.body()!!
        }
        return null
    }

    suspend fun getTournamentById(tourneyId: String): Tournament? {
        val response =
            tournamentRemoteDataSource.getTournamentById(tourneyId, LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            localData.putCurrentTournament(response.body()!!)
            return response.body()!!
        }
        return null
    }

    suspend fun getTournamentByName(tourneyName: String): Tournament? {
        val response =
            tournamentRemoteDataSource.getTournamentByName(tourneyName, LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            localData.putCurrentTournament(response.body()!!)
            return response.body()!!
        }
        return null
    }

    suspend fun getTournamentParticipantsUser() : List<User>? {
        val response =
            tournamentRemoteDataSource.getTournamentParticipantsUser(LocalCache.getCurrentTournamentName(context)!!,
                LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            localData.putCurrentUserList(response.body()!!)
            return response.body()!!
        }
        return null
    }

    suspend fun getTournamentParticipantsTeam() : List<Team>? {
        val response =
            tournamentRemoteDataSource.getTournamentParticipantsTeam(LocalCache.getCurrentTournamentName(context)!!,
                LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            localData.putCurrentTeamList(response.body()!!)
            return response.body()!!
        }
        return null
    }

    suspend fun getTournamentGames(tournamentName : String) : List<Game>? {
        val response =
            tournamentRemoteDataSource.getTournamentGames(tournamentName,
                LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun getGameById(tournamentName : String, gameId : String) : Game? {
        val response =
            tournamentRemoteDataSource.getGameById(tournamentName, gameId,
                LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun handleParticipation(tournamentName : String, participation : String) : ApiResponse? {
        val response =
            tournamentRemoteDataSource.handleParticipation(tournamentName, participation,
                LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun createGames(tournamentName : String) : List<Game>? {
        val response =
            tournamentRemoteDataSource.createGames(tournamentName,
                LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun updateGameById(tournamentName : String, game : Game) : Game? {
        val response =
            tournamentRemoteDataSource.updateGameById(tournamentName, game,
                LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun deleteTournament() : ApiResponse? {
        val response =
            tournamentRemoteDataSource.deleteTournament(localData.getCurrentTournament()!!.tournamentName,
                LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun deleteGameById(tournamentName : String, gameId : String) : ApiResponse? {
        val response =
            tournamentRemoteDataSource.deleteGameById(tournamentName, gameId,
                LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun updateTournamentDetail(tournamentName : String, tournamentDetail: TournamentDetail) : Tournament? {
        val response =
            tournamentRemoteDataSource.updateTournamentDetail(tournamentName, tournamentDetail,
                LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            localData.putCurrentTournament(response.body()!!)
            localData.putString(KEY_TOURNAMENT_ID, response.body()!!.tournamentId)
            localData.putString(KEY_TOURNAMENT_NAME, tournamentName)
            return response.body()!!
        }
        return null
    }

    fun getCurrentTournament() : Tournament {
        return localData.getCurrentTournament()!!
    }

    fun getCurrentTournamentList() : List<Tournament> {
        return localData.getCurrentTournamentList()
    }

    fun getCurrentGameList() : List<Game> {
        return localData.getCurrentGameList()
    }
}