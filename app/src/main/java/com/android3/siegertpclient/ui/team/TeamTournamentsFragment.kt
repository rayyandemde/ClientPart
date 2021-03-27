package com.android3.siegertpclient.ui.team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.databinding.FragmentTeamtournamentsBinding
import com.android3.siegertpclient.utils.LocalCache
import com.android3.siegertpclient.utils.recyclerviewadapters.TournamentAdapter

class TeamTournamentsFragment : Fragment(), TeamContract.ITeamView, TournamentAdapter.OnTournamentItemClickListener {
    private var _binding: FragmentTeamtournamentsBinding? = null
    private val binding get() = _binding!!

    private var teamPresenter: TeamPresenter? = null

    private val tournamentAdapter by lazy { TournamentAdapter(this) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTeamtournamentsBinding.inflate(inflater, container, false)
        teamPresenter = TeamPresenter(requireContext())

        binding.tvTeamName.text = "Team : " + LocalCache.getCurrentTeamName(requireContext())

        binding.rvTeamTournaments.adapter = tournamentAdapter

        binding.srlRvTeamTournaments.setOnRefreshListener {
        }

        binding.btnHome.setOnClickListener {
            teamPresenter?.onHomeBtnClicked()
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        teamPresenter?.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        teamPresenter?.onDetach()
        _binding = null
    }

    override fun navigateToTournamentActivity() {
        TODO("Not yet implemented")
    }

    override fun showDeleteAlert() {
        //Not implemented here
    }

    override fun showMembers(teamMembers: List<User>?) {
        //Not implemented here
    }

    override fun showProgress() {
        //Not needed for plain swipe refresh layout
    }

    override fun hideProgress() {
        binding.srlRvTeamTournaments.isRefreshing = false
    }

    override fun showError(errorMessage: String) {
        doToast(errorMessage)
    }

    override fun showNoInternetConnection() {
        doToast("There's no internet connection to make the request.")
    }

    override fun onTournamentItemClick(position: Int) {
        TODO("Not yet implemented")
    }

    private fun doToast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }
}