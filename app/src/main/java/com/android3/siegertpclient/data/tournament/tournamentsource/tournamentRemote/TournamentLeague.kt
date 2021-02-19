package com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote


import com.android3.siegertpclient.data.tournament.TournamentData
import com.android3.siegertpclient.utils.TournamentState

  class TournamentLeague constructor(tournamentId: String,tournamentDetail: TournamentDetail,
                                     gameList: List<String>,participantList: List<String>,
                                     tournamentName: String, maxParticipantNumber: Int,
                                     currentState: TournamentState,
                                     leagueTable: LeagueTable) : Tournament(tournamentId,tournamentDetail,gameList,participantList,
      tournamentName,maxParticipantNumber,currentState){
     val leagueTable: LeagueTable
     init{
         this.leagueTable = leagueTable
     }

  }

