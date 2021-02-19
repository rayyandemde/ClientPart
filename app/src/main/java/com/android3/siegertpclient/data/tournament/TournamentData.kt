package com.android3.siegertpclient.data.tournament

import com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote.TournamentDetail
import com.android3.siegertpclient.utils.ParticipantFormUtil
import com.android3.siegertpclient.utils.TournamentState
import com.android3.siegertpclient.utils.TournamentTypesUtil
import java.util.*


//Replacement Class for Tournament without the connection to Room
data class TournamentData(
    val tournamentId : String,
    val participantForm : ParticipantFormUtil,
    val adminId : String,
    val tournamentTypes : TournamentTypesUtil,
    val typeOfGame : String,
    val location : String,
    val registrationDeadline : Date,
    val startTime : Date,
    val endTime : Date,
    val tournamentName : String,
    val maxParticipantNumber : Int,
    val type : String,
    val currentState : TournamentState,

    var participantList: ParticipantList?,

    var gameList: GameList?
)
