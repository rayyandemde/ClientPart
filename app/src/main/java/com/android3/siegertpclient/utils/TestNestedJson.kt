package com.android3.siegertpclient.utils

data class TestNestedJson(
    val currentState: String,
    val gameList: List<Any>,
    val leagueTable: Any,
    val maxParticipantNumber: Int,
    val `open`: Boolean,
    val participantList: List<Any>,
    val tournamentDetail: TournamentDetail,
    val tournamentId: String,
    val tournamentName: String,
    val type: String
)