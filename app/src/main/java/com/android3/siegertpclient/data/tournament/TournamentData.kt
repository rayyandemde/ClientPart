package com.android3.siegertpclient.data.tournament

data class TournamentData(
    var tournamentId: String,
    var participantForm: String,
    var adminId:String,
    var tournamentTypes: String,
    var TypeOfGame: String,
    var location: String,
    var registrationDeadline: String,
    var startTime: String,
    var endTime: String,
    var tournamentName: String,

    var participantList: ParticipantList?,

    var gameList: GameList?
)
