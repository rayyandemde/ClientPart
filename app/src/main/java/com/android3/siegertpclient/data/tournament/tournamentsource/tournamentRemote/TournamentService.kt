package com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote

import com.android3.siegertpclient.data.game.Game
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.utils.ParticipantFormUtil
import com.android3.siegertpclient.utils.TournamentTypesUtil
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import java.util.*

interface TournamentService {

    @POST("tournaments")
    fun createNewTournament(@Body tournamentForm : String, tournamentSize : String, tournamentName: String,
                            tournamentDetail: TournamentDetail,
                            @Header("currentUserId") ownUserId: String) : Call<Tournament>

    @GET("tournaments")
    fun getTournamentById(@Query("id") tourneyId : String,
                          @Header("currentUserId") ownUserId: String) : Call<Tournament>

    @GET("tournaments/{tournamentName}")
    fun getTournamentByName(@Path("tournamentName") tournamentName : String,
                            @Header("currentUserId") ownUserId: String) : Call<Tournament>

    @GET("tournaments/{tournamentName}/participants")
    fun getTournamentParticipants(@Path("tournamentName") tournamentName : String,
                                  @Header("currentUserId") ownUserId: String) : Call<Array<User>>

    @PUT("tournaments/{tournamentName}")
    fun updateTournamentDetailById(@Path("tournamentName") tournamentName : String,
                                   @Body participantForm: ParticipantFormUtil, adminId : String,
                                   tournamentTypes: TournamentTypesUtil, typeOfGame : String, location : String,
                                   registrationDeadline : Date, startTime : Date, endTime : Date,
                                   @Header("currentUserId") ownUserId: String) : Call<Tournament>

    @DELETE("tournaments/{tournamentName}")
    fun deleteTournament(@Path("tournamentName") tournamentName : String,
                         @Header("currentUserId") ownUserId: String) : Call<Boolean>

    @POST("tournaments/{tournamentName}")
    fun handleParticipation(@Path("tournamentName") tournamentName : String, @Body participate : Map<String, Boolean>,
                            @Header("currentUserId") ownUserId: String) : Call<Boolean>

    @GET("tournaments/{tournamentName}/games")
    fun getTournamentsGames(@Path("tournamentName") tournamentName : String,
                            @Header("currentUserId") ownUserId: String) : Call<Array<Game>>

    @POST("tournaments/{tournamentName}/games")
    fun createGames(@Path("tournamentName") tournamentName : String,
                    @Header("currentUserId") ownUserId: String) : Call<Array<Game>>
}