package com.android3.siegertpclient.ui.team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android3.siegertpclient.R
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.tournament.TournamentDetail
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.databinding.FragmentTeamMemberBinding
import com.android3.siegertpclient.databinding.FragmentTeamtournamentsBinding
import com.android3.siegertpclient.utils.recyclerviewadapters.TournamentAdapter
import com.android3.siegertpclient.utils.recyclerviewadapters.UserAdapter

class TeamTournamentsFragment : Fragment(), TeamContract.ITeamView, TournamentAdapter.OnTournamentItemClickListener {
    private var _binding: FragmentTeamtournamentsBinding? = null
    private val binding get() = _binding!!

    private var teamPresenter: TeamPresenter? = null

    private val noTournaments by lazy {
        var noTournamentDetail = TournamentDetail("", "YYYY-MM-DD", "", "", "", "YYYY-MM-DD", "", "")
        listOf(Tournament("", emptyList(), 0, false, emptyList(), emptyMap(), noTournamentDetail, "", "No Tournament Available", ""))
    }

    private val tournamentAdapter by lazy { TournamentAdapter(this) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTeamtournamentsBinding.inflate(inflater, container, false)
        teamPresenter = TeamPresenter(requireContext())

        binding.rvTeamTournaments.adapter = tournamentAdapter

        binding.srlRvTeamTournaments.setOnRefreshListener {
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

    override fun showMembers(teamMembers: List<User>?) {
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