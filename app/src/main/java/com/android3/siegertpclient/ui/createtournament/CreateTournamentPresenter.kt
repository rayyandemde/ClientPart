package com.android3.siegertpclient.ui.createtournament

import android.content.Context
import com.android3.siegertpclient.data.tournament.tournamentsource.TournamentRepo
import com.android3.siegertpclient.ui.base.BasePresenter
import com.android3.siegertpclient.utils.OnlineChecker

class CreateTournamentPresenter(private val context: Context) : BasePresenter<CreateTournamentContract.ICreateTournamentView>(), CreateTournamentContract.ICreateTournamentPresenter{
    private var onlineChecker = OnlineChecker(context)

    private var tournamentRepo = TournamentRepo(context)

    override fun onBackBtnClicked() {
        view?.navigateToHomepageActivity()
    }

    override fun onCreateBtnClicked(
        name: String,
        typeOfGame: String,
        matchType: String,
        tournamentType: String,
        participantForm: String,
        registrationDeadline: String,
        startTime: String,
        endTime: String,
        location: String,
        maxParticipantNumber: Int
    ) {
        // view?.navigateToTournamentActivity()
    }
}