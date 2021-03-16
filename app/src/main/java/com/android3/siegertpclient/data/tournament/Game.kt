package com.android3.siegertpclient.data.tournament

data class Game(
    val firstParticipantId: String,
    val gameId: String,
    val result: Result,
    val secondParticipantId: String,
    val time: String
)