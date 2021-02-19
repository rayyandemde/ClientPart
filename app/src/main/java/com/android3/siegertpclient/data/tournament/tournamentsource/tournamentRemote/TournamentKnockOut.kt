package com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote

import com.android3.siegertpclient.data.game.Game
import com.android3.siegertpclient.utils.TournamentState
import com.google.gson.annotations.SerializedName

 class TournamentKnockOut constructor(tournamentId: String,tournamentDetail: TournamentDetail,
                                      gameList: List<String>,participantList: List<String>,
                                      tournamentName: String,maxParticipantNumber: Int,
                                      type: String,currentState: TournamentState,
                                      open: Boolean, currentGames:List<Game>,koMapping: KnockOutMapping)
    : Tournament(tournamentId,tournamentDetail,gameList,participantList,
    tournamentName,maxParticipantNumber,currentState) {

    val currentGames: List<Game>
    val koMapping: KnockOutMapping

    init {
       this.currentGames =currentGames
       this.koMapping = koMapping
    }
 }