package com.android3.siegertpclient.ui.team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android3.siegertpclient.R
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.ui.homepage.TournamentOverviewCardRecyclerAdapter

class TeamInvitationFragment : Fragment(), TeamContract.ITeamView  {

    private val teamPresenter: TeamPresenter = TeamPresenter()

    var teamInvitationRecycler: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        var view = inflater!!.inflate(R.layout.fragment_team_invitation, container, false)

        teamInvitationRecycler = view.findViewById<RecyclerView>(R.id.team_invitation_recycler)

        teamInvitationRecycler!!.layoutManager = LinearLayoutManager(context)
        teamInvitationRecycler!!.adapter = TournamentOverviewCardRecyclerAdapter()

        return view
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

    override fun showNoInternetConnection() {
        TODO("Not yet implemented")
    }

}