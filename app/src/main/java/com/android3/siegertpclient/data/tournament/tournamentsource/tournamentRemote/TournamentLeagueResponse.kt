package com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote

import com.android3.siegertpclient.utils.ParticipantFormUtil
import com.android3.siegertpclient.utils.TournamentState
import com.android3.siegertpclient.utils.TournamentTypesUtil
import java.util.*

class TournamentLeagueResponse(
    val tournamentId : String
    val tournamentDetail : TournamentDetail,
    val gameList : List<String>
    val participantList : List<String>,
    val tournamentName : String,
    val maxParticipantNumber : Int,
    val type : String,
    val currentState : TournamentState,
    val open : Boolean,
    val leagueTable: LeagueTable
)

data class LeagueTable(
    val tables:List<ParticipantActualStanding>
)
data class ParticipantActualStanding(
    val participantId:String,
    val plays:Int,
    val win:Int,
    val lose:Int,
    val draw: Int,
    val points:Int
)
