package com.android3.siegertpclient.ui.userprofile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android3.siegertpclient.R
import com.android3.siegertpclient.ui.homepage.TournamentOverviewCardRecyclerAdapter

class MyTeamsFragment : Fragment() , UserProfileContract.IUserProfileView{

    private val userProfilePresenter: UserProfilePresenter = UserProfilePresenter()

    var myTeamsRecycler: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        var view = inflater!!.inflate(R.layout.fragment_myteams, container, false)

        myTeamsRecycler = view.findViewById<RecyclerView>(R.id.my_teams_recycler)

        myTeamsRecycler!!.layoutManager = LinearLayoutManager(context)
        myTeamsRecycler!!.adapter = TournamentOverviewCardRecyclerAdapter()

        return view
    }
    override fun onResume() {
        super.onResume()
        userProfilePresenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        userProfilePresenter.onDetach()
    }
    fun showTeams() {
        TODO("Not yet implemented")
    }

    fun navigateToTeamActivity()  {
        TODO("Not yet implemented")
    }

    override fun showMyTournamentsFragment() {
        TODO("Not yet implemented")
    }

    override fun showMyTeamsFragment() {
        TODO("Not yet implemented")
    }

    override fun navigateToHomepageActivity() {
        TODO("Not yet implemented")
    }

    override fun navigateToSettingActivity() {
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