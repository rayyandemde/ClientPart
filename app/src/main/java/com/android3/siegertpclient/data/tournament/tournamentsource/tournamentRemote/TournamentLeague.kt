package com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote

import com.android3.siegertpclient.utils.TournamentState

 class TournamentLeague(
    val tournamentId : String,
    val tournamentDetail : TournamentDetail,
    val gameList : List<String>,
    val participantList : List<String>,
    val tournamentName : String,
    val maxParticipantNumber : Int,
    val type : String,
    val currentState : TournamentState,
    val open : Boolean,
    val leagueTable: LeagueTable
)