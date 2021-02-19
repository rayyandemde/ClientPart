package com.android3.siegertpclient.ui.team

import androidx.fragment.app.Fragment
import com.android3.siegertpclient.data.tournament.Tournament

class TeamTournamentsFragment : Fragment() , TeamContract.ITeamView {

    private val teamPresenter: TeamPresenter = TeamPresenter()

    fun showTournaments(tournaments: List<Tournament>) {
        TODO("Not yet implemented")
    }
    override fun onResume() {
        super.onResume()
        teamPresenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        teamPresenter.onDetach()
    }
    override fun showAdminFragment() {
        TODO("Not yet implemented")
    }

    override fun showMemberFragment() {
        TODO("Not yet implemented")
    }

    override fun showTeamTournamentsFragment() {
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