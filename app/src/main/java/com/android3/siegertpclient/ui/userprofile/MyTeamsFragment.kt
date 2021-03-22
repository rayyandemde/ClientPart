package com.android3.siegertpclient.ui.userprofile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android3.siegertpclient.R
import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.databinding.FragmentMyteamsBinding
import com.android3.siegertpclient.ui.homepage.HomepageActivity
import com.android3.siegertpclient.ui.team.TeamActivity
import com.android3.siegertpclient.utils.Constants.Companion.KEY_TEAM_NAME
import com.android3.siegertpclient.utils.recyclerviewadapters.TeamAdapter

class MyTeamsFragment : Fragment() , UserProfileContract.IUserProfileView,
    TeamAdapter.OnTeamItemClickListener {

    private var _binding: FragmentMyteamsBinding? = null
    private val binding get() = _binding!!

    private var userProfilePresenter: UserProfilePresenter? = null

    private val noTeam by lazy {
        listOf(Team("", emptyList(), emptyList(), "", getString(R.string.user_no_team), "", emptyList()))
    }

    private val teamAdapter by lazy { TeamAdapter(this) }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMyteamsBinding.inflate(inflater, container, false)
        userProfilePresenter = UserProfilePresenter(requireContext())

        binding.rvMyTeams.adapter = teamAdapter


        userProfilePresenter?.onTeamsRefresh()


        binding.srlRvMyTeams.setOnRefreshListener {
            userProfilePresenter?.onTeamsRefresh()
        }


        return binding.root
    }
    override fun onResume() {
        super.onResume()
        userProfilePresenter?.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        userProfilePresenter?.onDetach()
        _binding = null
    }
    fun showTeams() {
        TODO("Not yet implemented")
    }

    override fun navigateToTeamActivity()  {
        val intent = Intent(activity, TeamActivity::class.java)
        startActivity(intent)
    }

    override fun showMyTeams(myTeams: List<Team>?) {
        if (myTeams != null) {
            teamAdapter.setData(myTeams)
        } else {
            teamAdapter.setData(noTeam)
        }
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
        binding.srlRvMyTeams.isRefreshing = false
    }

    override fun showError(errorMessage: String) {
        doToast(errorMessage)
    }

    override fun showNoInternetConnection() {
        doToast("There's no internet connection to make the request.")
    }

    private fun doToast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

    override fun onTeamItemClick(position: Int) {
        val clickedTeam = userProfilePresenter?.userTeamClicked(position)
    }
}