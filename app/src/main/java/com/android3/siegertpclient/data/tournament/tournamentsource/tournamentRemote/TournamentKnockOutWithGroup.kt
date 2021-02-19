package com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote

import com.android3.siegertpclient.data.game.Game
import com.android3.siegertpclient.utils.TournamentState

 class TournamentKnockOutWithGroup constructor(tournamentId: String,tournamentDetail: TournamentDetail,
                                               gameList: List<String>,participantList: List<String>,
                                               tournamentName: String,maxParticipantNumber: Int,
                                               type: String,currentState: TournamentState,
                                               open: Boolean, currentGames:List<Game>,koMapping: KnockOutMapping,tables: List<LeagueTable>)
    : Tournament(tournamentId,tournamentDetail,gameList,participantList,
    tournamentName,maxParticipantNumber,currentState) {

    val currentGames: List<Game>
    val koMapping: KnockOutMapping
    val tables: List<LeagueTable>

    init {
       this.currentGames = currentGames
       this.koMapping = koMapping
       this.tables = tables
    }
 }