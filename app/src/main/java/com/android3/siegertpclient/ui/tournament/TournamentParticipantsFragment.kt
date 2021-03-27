package com.android3.siegertpclient.ui.tournament

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android3.siegertpclient.R
import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.data.tournament.Game
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.databinding.FragmentTournamentparticipantsBinding
import com.android3.siegertpclient.utils.Constants.Companion.SINGLE
import com.android3.siegertpclient.utils.Constants.Companion.TEAM
import com.android3.siegertpclient.utils.recyclerviewadapters.TeamAdapter
import com.android3.siegertpclient.utils.recyclerviewadapters.UserAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class TournamentParticipantsFragment : Fragment(), TournamentContract.ITournamentView, UserAdapter.OnUserItemClickListener, TeamAdapter.OnTeamItemClickListener {
    private var _binding: FragmentTournamentparticipantsBinding? = null
    private val binding get() = _binding!!

    private var tournamentPresenter: TournamentPresenter? = null

    private val userAdapter by lazy { UserAdapter(this) }

    private val teamAdapter by lazy { TeamAdapter(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTournamentparticipantsBinding.inflate(inflater, container, false)
        tournamentPresenter = TournamentPresenter(requireContext())

        initParticipantAdapter()

        tournamentPresenter?.onParticipantRefresh()

        binding.srlRvTournamentParticipants.setOnRefreshListener {
            tournamentPresenter?.onParticipantRefresh()
        }

        binding.btnAddParticipants.setOnClickListener {
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.edit_text_layout, null)
            val etParticipant = dialogLayout.findViewById<EditText>(R.id.et_for_dialog)

            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Add Participant")
                .setMessage("Please input username or team name")
                .setNegativeButton("Cancel") {dialog, which ->
                    //Do Nothing
                }
                .setPositiveButton("Add") {dialog, which ->
                    tournamentPresenter?.onAddParticipantBtnClicked(etParticipant.text.toString().trim { it <= ' ' })
                }
                .setView(dialogLayout)
                .show()
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

    override fun showCurrentTournamentDetails() {
        //Not implemented here
    }

    override fun setEditRights() {
        if (!tournamentPresenter!!.isAdmin()) {
            disableEdits()
        }
    }

    override fun disableEdits() {
        binding.btnAddParticipants.isEnabled = false
    }

    override fun showIncompleteInput() {
        doToast("Please input a username or team name")
    }

    override fun showSuccess(message: String) {
        doToast(message)
    }

    override fun initParticipantAdapter() {
        val participantType = tournamentPresenter?.getCurrentTournament()!!.tournamentDetail.participantForm
        when {
            participantType == SINGLE -> binding.rvTournamentParticipants.adapter = userAdapter
            participantType == TEAM -> binding.rvTournamentParticipants.adapter = teamAdapter
        }
    }

    override fun showSingleParticipants(participants: List<User>?) {
        if (participants != null) {
            userAdapter.setData(participants!!)
        }
    }

    override fun showTeamParticipants(participants: List<Team>?) {
        if (participants != null) {
            teamAdapter.setData(participants!!)
        }
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
        //Not implemented here
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