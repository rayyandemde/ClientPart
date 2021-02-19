package com.android3.siegertpclient.ui.tournament

import androidx.fragment.app.Fragment
import com.android3.siegertpclient.data.game.Game

class TournamentSchedulesFragment : Fragment() , TournamentContract.ITournamentView{

    private val tournamentPresenter: TournamentPresenter = TournamentPresenter()

    fun showScheduleList(games: List<Game>) {
        TODO("Not yet implemented")
    }

    fun showDeleteScheduleBtn() {
        TODO("Not yet implemented")
    }

    fun showAddScheduleBtn() {
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