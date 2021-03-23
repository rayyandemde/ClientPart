package com.android3.siegertpclient.ui.tournament

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android3.siegertpclient.R
import com.android3.siegertpclient.data.tournament.Game
import com.android3.siegertpclient.data.tournament.Result
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.databinding.FragmentTeamMemberBinding
import com.android3.siegertpclient.databinding.FragmentTournamentparticipantsBinding
import com.android3.siegertpclient.databinding.FragmentTournamentschedulesBinding
import com.android3.siegertpclient.ui.team.TeamPresenter
import com.android3.siegertpclient.utils.recyclerviewadapters.ScheduleAdapter
import com.android3.siegertpclient.utils.recyclerviewadapters.UserAdapter

class TournamentSchedulesFragment : Fragment() , TournamentContract.ITournamentView, ScheduleAdapter.OnScheduleItemClickListener {
    private var _binding: FragmentTournamentschedulesBinding? = null
    private val binding get() = _binding!!

    private var tournamentPresenter: TournamentPresenter? = null

    private val noSchedule by lazy {
        val noResult = Result("", "","")
        listOf(Game("There is", "", noResult, "no schedule", ""))
    }

    private val scheduleAdapter by lazy { ScheduleAdapter(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTournamentschedulesBinding.inflate(inflater, container, false)
        tournamentPresenter = TournamentPresenter(requireContext())

        binding.rvTournamentSchedules.adapter = scheduleAdapter

        binding.srlRvTournamentSchedules.setOnRefreshListener {
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        tournamentPresenter?.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        tournamentPresenter?.onDetach()
        _binding = null
    }
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

    override fun showNoInternetConnection() {
        TODO("Not yet implemented")
    }

    override fun onScheduleItemClick(position: Int) {
        TODO("Not yet implemented")
    }
}