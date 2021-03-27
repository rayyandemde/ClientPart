package com.android3.siegertpclient.data.tournament

data class Tournament(
    val currentState: String,
    val gameList: List<String>,
    val maxParticipantNumber: Int,
    val `open`: Boolean,
    val participantList: List<String>,
    val specifiedAttributes: Map<String, Any>,
    val tournamentDetail: TournamentDetail,
    val tournamentId: String,
    val tournamentName: String,
    val type: String
)