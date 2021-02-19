package com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote

import com.android3.siegertpclient.utils.TournamentState

open class Tournament constructor(tournamentId: String, tournamentDetail: TournamentDetail,
                                     gameList: List<String>, participantList: List<String>,
                                     tournamentName: String, maxParticipantNumber: Int, currentState: TournamentState) {
    val tournamentId: String
    val tournamentDetail: TournamentDetail
    val gameList: List<String>
    val participantList: List<String>
    val tournamentName: String
    val maxParticipantNumber: Int
    val currentState: TournamentState

    init {
        this.currentState = currentState
        this.gameList = gameList
        this.maxParticipantNumber = maxParticipantNumber
        this.participantList = participantList
        this.tournamentDetail = tournamentDetail
        this.tournamentId = tournamentId
        this.tournamentName = tournamentName
    }
}