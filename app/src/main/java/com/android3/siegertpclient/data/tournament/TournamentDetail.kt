package com.android3.siegertpclient.data.tournament

data class TournamentDetail(
    val adminId: String,
    val endTime: String,
    val location: String,
    val participantForm: String,
    val registrationDeadline: String,
    val startTime: String,
    val tournamentTypes: String,
    val typeOfGame: String
)