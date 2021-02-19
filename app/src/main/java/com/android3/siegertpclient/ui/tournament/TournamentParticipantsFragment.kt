package com.android3.siegertpclient.ui.tournament

import androidx.fragment.app.Fragment

class TournamentParticipantsFragment : Fragment(), TournamentContract.ITournamentView {

    private val tournamentPresenter: TournamentPresenter = TournamentPresenter()

//    fun showParticipantList(participants: List<Participant>) {
//        TODO("Not yet implemented")
//    }

    fun showKickParticipantBtn() {
        TODO("Not yet implemented")
    }

    fun showAddParticipantBtn() {
        TODO("Not yet implemented")
    }

    override fun showTournamentDetailsFragment() {
        TODO("Not yet implemented")
    }

    override fun showTournamentParticipantsFragment() {
        TODO("Not yet implemented")
    }

    override fun showTournamentScheduleFragment() {
        TODO("Not yet implemented")
    }

    override fun showResultFragment() {
        TODO("Not yet implemented")
    }

    override fun showTournamentUpdatesFragment() {
        TODO("Not yet implemented")
    }

    override fun navigateToHomepageActivity() {
        TODO("Not yet implemented")
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hideProgress() {
        TODO("Not yet implemented")
    }

    override fun showError(errorMessage: String) {
        TODO("Not yet implemented")
    }

    override fun showError(errorId: Int) {
        TODO("Not yet implemented")
    }
}