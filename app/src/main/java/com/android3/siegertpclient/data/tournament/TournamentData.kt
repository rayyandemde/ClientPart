package com.android3.siegertpclient.data.tournament

import com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote.TournamentDetail
import com.android3.siegertpclient.utils.ParticipantFormUtil
import com.android3.siegertpclient.utils.TournamentState
import com.android3.siegertpclient.utils.TournamentTypesUtil
import java.util.*

/**
 * Tournament class is to shoe the attribute in Tournament
 */

//Replacement Class for Tournament without the connection to Room
data class TournamentData(
    val tournamentId : String,
    val tournamentDetail : TournamentDetail,
    val gameList : List<String>,
    val participantList : List<String>,
    val tournamentName : String,
    val maxParticipantNumber : Int,
    val type : String,
    val currentState : TournamentState,
    val open : Boolean
)
