package com.android3.siegertpclient.ui.userprofile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android3.siegertpclient.R
import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.tournament.TournamentDetail
import com.android3.siegertpclient.databinding.FragmentMyteamsBinding
import com.android3.siegertpclient.databinding.FragmentMytournamentsBinding
import com.android3.siegertpclient.ui.homepage.HomepageActivity
import com.android3.siegertpclient.ui.setting.SettingsActivity
import com.android3.siegertpclient.utils.recyclerviewadapters.TeamAdapter
import com.android3.siegertpclient.utils.recyclerviewadapters.TournamentAdapter

class MyTournamentsFragment : Fragment(), UserProfileContract.IUserProfileView, TournamentAdapter.OnTournamentItemClickListener {
    private var _binding: FragmentMytournamentsBinding? = null
    private val binding get() = _binding!!

    private var userProfilePresenter: UserProfilePresenter? = null

    private val noTournaments by lazy {
        var noTournamentDetail = TournamentDetail("", "YYYY-MM-DD", "", "", "", "YYYY-MM-DD", "", "")
        listOf(Tournament("", emptyList(), 0, false, emptyList(), emptyMap(), noTournamentDetail, "", "No Tournament Available", ""))
    }

    private val tournamentAdapter by lazy { TournamentAdapter(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMytournamentsBinding.inflate(inflater, container, false)
        userProfilePresenter = UserProfilePresenter(requireContext())

        binding.rvMyTournaments.adapter = tournamentAdapter

        binding.srlRvMyTournaments.setOnRefreshListener {

        }

        binding.btnSetttings.setOnClickListener{
            userProfilePresenter?.onSettingBtnClicked()
        }

        binding.btnHome.setOnClickListener{
            userProfilePresenter?.onHomeBtnClicked()
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        userProfilePresenter?.onAttach(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        userProfilePresenter?.onDetach()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        userProfilePresenter?.onDetach()
    }

    fun showTournaments() {
        TODO("Not yet implemented")
    }

    fun navigateToTournamentActivity()  {
        TODO("Not yet implemented")
    }

    override fun showMyTeams(myTeams: List<Team>?) {
        TODO("Not yet implemented")
    }

    override fun navigateToHomepageActivity() {
        val hIntent = Intent(activity, HomepageActivity::class.java)
        startActivity(hIntent)
    }

    override fun navigateToSettingActivity() {
        val sIntent = Intent(activity, SettingsActivity::class.java)
        startActivity(sIntent)
    }

    override fun navigateToTeamActivity() {
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

    override fun showNoInternetConnection() {
        TODO("Not yet implemented")
    }

    override fun onTournamentItemClick(position: Int) {
        TODO("Not yet implemented")
    }
}