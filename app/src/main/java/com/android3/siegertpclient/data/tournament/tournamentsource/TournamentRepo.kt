package com.android3.siegertpclient.data.tournament.tournamentsource

import android.content.Context
import com.android3.siegertpclient.data.payload.ApiResponse
import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.data.tournament.Game
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.tournament.TournamentDetail
import com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote.TournamentRemoteDataSource
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.utils.LocalCache
import com.android3.siegertpclient.utils.PreferencesProvider

class TournamentRepo(private val context: Context) {
    private val tournamentRemoteDataSource2 = TournamentRemoteDataSource()
    private var localData = PreferencesProvider(context)

    suspend fun createNewTournament(
        type : String,
        participantSize: Int,
        name : String,
        tournamentDetail : TournamentDetail
    ): Tournament? {
        val response = tournamentRemoteDataSource2.createNewTournament(type,
            participantSize, name, tournamentDetail, LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            localData.putCurrentTournament(response.body()!!)
            return response.body()!!
        }
        return null
    }

    suspend fun getTournamentById(tourneyId: String): Tournament? {
        val response =
            tournamentRemoteDataSource2.getTournamentById(tourneyId, LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            localData.putCurrentTournament(response.body()!!)
            return response.body()!!
        }
        return null
    }

    suspend fun getTournamentByName(tourneyName: String): Tournament? {
        val response =
            tournamentRemoteDataSource2.getTournamentByName(tourneyName, LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            localData.putCurrentTournament(response.body()!!)
            return response.body()!!
        }
        return null
    }

    suspend fun getTournamentParticipantsUser() : List<User>? {
        val response =
            tournamentRemoteDataSource2.getTournamentParticipantsUser(LocalCache.getCurrentTournamentName(context)!!,
                LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            localData.putCurrentUserList(response.body()!!)
            return response.body()!!
        }
        return null
    }

    suspend fun getTournamentParticipantsTeam() : List<Team>? {
        val response =
            tournamentRemoteDataSource2.getTournamentParticipantsTeam(LocalCache.getCurrentTournamentName(context)!!,
                LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            localData.putCurrentTeamList(response.body()!!)
            return response.body()!!
        }
        return null
    }

    suspend fun getTournamentGames(tournamentName : String) : List<Game>? {
        val response =
            tournamentRemoteDataSource2.getTournamentGames(tournamentName,
                LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun getGameById(tournamentName : String, gameId : String) : Game? {
        val response =
            tournamentRemoteDataSource2.getGameById(tournamentName, gameId,
                LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun handleParticipation(tournamentName : String, participation : String) : ApiResponse? {
        val response =
            tournamentRemoteDataSource2.handleParticipation(tournamentName, participation,
                LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun createGames(tournamentName : String) : List<Game>? {
        val response =
            tournamentRemoteDataSource2.createGames(tournamentName,
                LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun updateGameById(tournamentName : String, game : Game) : Game? {
        val response =
            tournamentRemoteDataSource2.updateGameById(tournamentName, game,
                LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun deleteTournament() : ApiResponse? {
        val response =
            tournamentRemoteDataSource2.deleteTournament(localData.getCurrentTournament()!!.tournamentName,
                LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun deleteGameById(tournamentName : String, gameId : String) : ApiResponse? {
        val response =
            tournamentRemoteDataSource2.deleteGameById(tournamentName, gameId,
                LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            return response.body()!!
        }
        return null
    }

    suspend fun updateTournamentDetail(tournamentName : String, tournamentDetail: TournamentDetail) : Tournament? {
        val response =
            tournamentRemoteDataSource2.updateTournamentDetail(tournamentName, tournamentDetail,
                LocalCache.getBearerToken(context)!!)
        if (response.isSuccessful) {
            localData.putCurrentTournament(response.body()!!)
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
}