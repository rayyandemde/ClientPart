package com.android3.siegertpclient.ui.tournament

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.data.tournament.Game
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.databinding.FragmentDeleteTournamentBinding
import com.android3.siegertpclient.ui.homepage.HomepageActivity

class DeleteTournamentFragment : Fragment(), TournamentContract.ITournamentView {
    private var _binding: FragmentDeleteTournamentBinding? = null
    private val binding get() = _binding!!

    private var tournamentPresenter: TournamentPresenter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDeleteTournamentBinding.inflate(inflater, container, false)
        tournamentPresenter = TournamentPresenter(requireContext())

        binding.btnDeleteTournament.setOnClickListener {
            tournamentPresenter?.onCancelTournamentBtnClicked()
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

    override fun showSuccess(message: String) {
        doToast(message)
    }

    override fun initParticipantAdapter(participantForm: String) {
        //Not implemented here
    }

    override fun showSingleParticipants(participants: List<User>?) {
        //Not implemented here
    }

    override fun showTeamParticipants(participants: List<Team>?) {
        //Not implemented here
    }

    override fun showSchedules(schedules: List<Game>?) {
        //Not implemented here
    }

    override fun showGames(games: List<Game>?) {
        //Not implemented here
    }

    override fun navigateToHomepageActivity() {
        doToast("Tournament have been cancelled")
        val intent = Intent(activity, HomepageActivity::class.java)
        startActivity(intent)
    }

    override fun showProgress() {
        binding.pbRequest.visibility = View.VISIBLE
        binding.btnDeleteTournament.isEnabled = false
    }

    override fun hideProgress() {
        binding.pbRequest.visibility = View.VISIBLE
        binding.btnDeleteTournament.isEnabled = false
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
}