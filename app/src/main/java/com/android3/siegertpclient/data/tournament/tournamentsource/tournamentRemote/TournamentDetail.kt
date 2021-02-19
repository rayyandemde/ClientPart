package com.android3.siegertpclient.data.tournament.tournamentsource.tournamentRemote

import com.android3.siegertpclient.utils.ParticipantFormUtil
import com.android3.siegertpclient.utils.TournamentTypesUtil
import java.util.*


 data class TournamentDetail(
     val participantForm: ParticipantFormUtil,
     val adminId: String,
     val tournamentTypes: TournamentTypesUtil,
     val typeOfGame: String,
     val location: String,
     val registrationDeadline: Date,
     val startTime: Date,
     val endTime: Date

)
