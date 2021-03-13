package com.android3.siegertpclient.data.tournament

class LeagueTournament(
    val currentState: String,
    val gameList: List<Any>,
    val leagueTable: Any,
    val `open`: Boolean,
    val participantList: List<String>,
    val tournamentId: String
) : Tournament2(0, TournamentDetail("","","","","","","",""), "", "")