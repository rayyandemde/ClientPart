package com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote

import com.android3.siegertpclient.data.game.Game
import com.android3.siegertpclient.utils.TournamentState

 class TournamentKnockOutWithGroup (
    val tournamentId : String,
    val tournamentDetail : TournamentDetail,
    //game and participantList are Strings and can be converted to GameList and ParticipantList with the Converters
    val gameList : List<String>,
    val participantList : List<String>,
    val tournamentName : String,
    val maxParticipantNumber : Int,
    val type : String,
    val currentState : TournamentState,
    val currentGames:List<Game>,
    val koMapping: KnockOutMapping,
    val open : Boolean,
    val tables: List<LeagueTable>
)