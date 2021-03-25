package com.android3.siegertpclient.data.tournament

data class CreateTournament(
    val maxParticipantNumber: Int,
    val tournamentDetail: TournamentDetail,
    val tournamentName: String,
    val type: String
)