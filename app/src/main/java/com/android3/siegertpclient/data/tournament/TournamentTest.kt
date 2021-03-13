package com.android3.siegertpclient.data.tournament

data class TournamentTest(
    val currentState: String,
    val gameList: List<String>,
    val maxParticipantNumber: Int,
    val `open`: Boolean,
    val participantList: List<String>,
    val specifiedAttributes: Map<String, Any>,
    val tournamentDetail: TournamentDetailXX,
    val tournamentId: String,
    val tournamentName: String,
    val type: String
)