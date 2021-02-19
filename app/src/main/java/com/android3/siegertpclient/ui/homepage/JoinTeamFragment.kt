package com.android3.siegertpclient.ui.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.android3.siegertpclient.R
import com.android3.siegertpclient.data.tournament.Tournament

class JoinTeamFragment : Fragment() , HomepageContract.IHomepageView {

    private val homepagePresenter: HomepagePresenter = HomepagePresenter()

    var teamNameEt: EditText? = null
    var teamPassword: EditText? = null
    var joinTeamBtn: Button? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = inflater!!.inflate(R.layout.fragment_jointeam, container, false)

        teamNameEt = view.findViewById<EditText>(R.id.teamName)
        teamPassword = view.findViewById<EditText>(R.id.teamPassword)
        joinTeamBtn = view.findViewById<Button>(R.id.joinTeamBtn)

        return view
    }

    override fun onResume() {
        super.onResume()
        homepagePresenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        homepagePresenter.onDetach()
    }

    fun navigateToTeamActivity() {
        TODO("Not yet implemented")
    }

    override fun navigateToInvitationActivity() {
        TODO("Not yet implemented")
    }

    override fun navigateToUserActivity() {
        TODO("Not yet implemented")
    }

    override fun navigateToCreateTournamentActivity() {
        TODO("Not yet implemented")
    }

    override fun navigateToCreateTeamActivity() {
        TODO("Not yet implemented")
    }

    override fun showFeedFragment() {
        TODO("Not yet implemented")
    }

    override fun showJoinTeamFragment() {
        TODO("Not yet implemented")
    }

    override fun showSearchResult(tournaments: List<Tournament>) {
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