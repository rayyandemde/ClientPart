package com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote

import com.android3.siegertpclient.data.game.Game
import com.android3.siegertpclient.utils.TournamentState
import com.google.gson.annotations.SerializedName

 class TournamentKnockOut(
    @SerializedName("tournamentId")
    val tournamentId : String,
    @SerializedName("tournamentDetail")
    val tournamentDetail : TournamentDetail,
    @SerializedName("gameList")
    val gameList : List<String>,
    @SerializedName("participantList")
    val participantList : List<String>,
    @SerializedName("tournamentName")
    val tournamentName : String,
    @SerializedName("maxParticipantNumber")
    val maxParticipantNumber : Int,
    @SerializedName("type")
    val type : String,
    @SerializedName("currentState")
    val currentState : TournamentState,
    @SerializedName("open")
    val open : Boolean,
    @SerializedName("currentGames")
    val currentGames:List<Game>,
    @SerializedName("koMapping")
    val koMapping: KnockOutMapping
)