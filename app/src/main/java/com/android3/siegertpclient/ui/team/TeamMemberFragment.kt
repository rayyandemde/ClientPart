package com.android3.siegertpclient.ui.team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android3.siegertpclient.R
import com.android3.siegertpclient.data.user.User

class TeamMemberFragment : Fragment() , TeamContract.ITeamView {

    private val teamPresenter: TeamPresenter = TeamPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_feed, container, false)
    }

    fun showMember(users: List<User>) {
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