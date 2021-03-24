package com.android3.siegertpclient.ui.tournament

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android3.siegertpclient.R
import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.data.tournament.Game
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.databinding.FragmentTeamMemberBinding
import com.android3.siegertpclient.databinding.FragmentTournamentparticipantsBinding
import com.android3.siegertpclient.ui.team.TeamPresenter
import com.android3.siegertpclient.utils.Constants.Companion.SINGLE
import com.android3.siegertpclient.utils.Constants.Companion.TEAM
import com.android3.siegertpclient.utils.recyclerviewadapters.TeamAdapter
import com.android3.siegertpclient.utils.recyclerviewadapters.UserAdapter

class TournamentParticipantsFragment : Fragment(), TournamentContract.ITournamentView, UserAdapter.OnUserItemClickListener, TeamAdapter.OnTeamItemClickListener {
    private var _binding: FragmentTournamentparticipantsBinding? = null
    private val binding get() = _binding!!

    private var tournamentPresenter: TournamentPresenter? = null

    private val userAdapter by lazy { UserAdapter(this) }

    private val teamAdapter by lazy { TeamAdapter(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTournamentparticipantsBinding.inflate(inflater, container, false)
        tournamentPresenter = TournamentPresenter(requireContext())

        tournamentPresenter?.initParticipantAdapter()

        tournamentPresenter?.onParticipantRefresh()

        binding.srlRvTournamentParticipants.setOnRefreshListener {
            tournamentPresenter?.onParticipantRefresh()
        }

        binding.btnAddParticipants.setOnClickListener {

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


    override fun showCurrentTournamentDetails(
        tournamentName: String,
        typeOfGame: String,
        matchType: String,
        tournamentType: String,
        participantForm: String,
        registrationDeadline: String,
        startDate: String,
        endDate: String,
        location: String,
        maxPlayer: Int
    ) {
        //Not implemented here
    }

    override fun disableEdits() {
        //Not implemented here
    }

    override fun showIncompleteInput() {
        //Not implemented here
    }

    override fun initParticipantAdapter(participantType: String) {
        when {
            participantType == SINGLE -> binding.rvTournamentParticipants.adapter = userAdapter
            participantType == TEAM -> binding.rvTournamentParticipants.adapter = teamAdapter
        }
    }

    override fun showSingleParticipants(participants: List<User>?) {
        TODO("Not yet implemented")
    }

    override fun showTeamParticipants(participants: List<Team>?) {
        TODO("Not yet implemented")
    }

    override fun showSchedules(schedules: List<Game>?) {
        //Not implemented here
    }

    override fun showGames(games: List<Game>?) {
        //Not implemented here
    }

    override fun navigateToHomepageActivity() {
        //Not implemented here
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hideProgress() {
        //TO DO FOR ADD PARTICIPANT
        binding.srlRvTournamentParticipants.isRefreshing = false
    }

    override fun showError(errorMessage: String) {
        doToast(errorMessage)
    }

    override fun showNoInternetConnection() {
        doToast("There's no internet connection to make the request.")
    }

    override fun onUserItemClick(position: Int) {
        //Do Nothing
    }

    override fun onTeamItemClick(position: Int) {
        //Do Nothing
    }

    private fun doToast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }
}