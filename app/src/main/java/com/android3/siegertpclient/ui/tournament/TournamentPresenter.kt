package com.android3.siegertpclient.ui.tournament

import android.content.Context
import com.android3.siegertpclient.data.tournament.tournamentsource.TournamentRepo
import com.android3.siegertpclient.ui.base.BasePresenter
import com.android3.siegertpclient.utils.OnlineChecker

class TournamentPresenter(private val context: Context) : BasePresenter<TournamentContract.ITournamentView>(), TournamentContract.ITeamPresenter {
    private var onlineChecker = OnlineChecker(context)
    private var tournamentRepo = TournamentRepo(context)

    override fun initTournamentDetails() {
        val tournament = tournamentRepo.getCurrentTournament()
        val tournamentDetail = tournament.tournamentDetail

        val tournamentName = tournament.tournamentName
        val typeOfGame = tournamentDetail.typeOfGame
        val matchType = tournament.type
        val tournamentType = tournamentDetail.tournamentTypes
        val participantForm = tournamentDetail.participantForm
        val registrationDeadline = tournamentDetail.registrationDeadline
        val startDate = tournamentDetail.startTime
        val endDate = tournamentDetail.endTime
        val location = tournamentDetail.location
        val maxPlayer = tournament.maxParticipantNumber

        view?.showCurrentTournamentDetails(tournamentName, typeOfGame, matchType, tournamentType, participantForm, registrationDeadline, startDate, endDate, location, maxPlayer)
    }

    override fun checkIfAdmin(userId: String) {

    }


    override fun onBackBtnClicked() {
        view?.navigateToHomepageActivity()
    }
}