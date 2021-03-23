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
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.databinding.FragmentTeamMemberBinding
import com.android3.siegertpclient.databinding.FragmentTournamentparticipantsBinding
import com.android3.siegertpclient.ui.team.TeamPresenter
import com.android3.siegertpclient.utils.recyclerviewadapters.UserAdapter

class TournamentParticipantsFragment : Fragment(), TournamentContract.ITournamentView, UserAdapter.OnUserItemClickListener {
    private var _binding: FragmentTournamentparticipantsBinding? = null
    private val binding get() = _binding!!

    private var tournamentPresenter: TournamentPresenter? = null

    private val noUser by lazy {
        listOf(User("There's no participant at the moment", emptyList(), "...", emptyList(), emptyList(), "","..."))
    }

    private val userAdapter by lazy { UserAdapter(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTournamentparticipantsBinding.inflate(inflater, container, false)
        tournamentPresenter = TournamentPresenter(requireContext())

        binding.rvTournamentParticipants.adapter = userAdapter

        binding.srlRvTournamentParticipants.setOnRefreshListener {
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
//    fun showParticipantList(participants: List<Participant>) {
//        TODO("Not yet implemented")
//    }

    fun showKickParticipantBtn() {
        TODO("Not yet implemented")
    }

    fun showAddParticipantBtn() {
        TODO("Not yet implemented")
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

    override fun onUserItemClick(position: Int) {
        TODO("Not yet implemented")
    }
}