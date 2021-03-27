package com.android3.siegertpclient.ui.tournament

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.data.tournament.Game
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.databinding.FragmentTournamentmatchesBinding
import com.android3.siegertpclient.utils.recyclerviewadapters.GameAdapter

<<<<<<< HEAD

class TournamentMatchesFragment : Fragment() , TournamentContract.ITournamentView{
=======
class TournamentMatchesFragment : Fragment() , TournamentContract.ITournamentView, GameAdapter.OnGameItemClickListener{
    private var _binding: FragmentTournamentmatchesBinding? = null
    private val binding get() = _binding!!
>>>>>>> origin

    private var tournamentPresenter: TournamentPresenter? = null

    private val gameAdapter by lazy { GameAdapter(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTournamentmatchesBinding.inflate(inflater, container, false)
        tournamentPresenter = TournamentPresenter(requireContext())

        binding.rvTournamentMatches.adapter = gameAdapter

        binding.srlRvTournamentMatches.setOnRefreshListener {
        }

        binding.btnAddMatches.setOnClickListener {

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
        TODO("Not yet implemented")
    }

    override fun setEditRights() {
        TODO("Not yet implemented")
    }

    override fun disableEdits() {
        //Not implemented here
    }

    override fun showIncompleteInput() {
        //Not implemented here
    }

    override fun showSuccess(message: String) {
        TODO("Not yet implemented")
    }

    override fun initParticipantAdapter() {
        TODO("Not yet implemented")
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
        TODO("Not yet implemented")
    }

    override fun navigateToHomepageActivity() {
        //Not implemented here
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hideProgress() {
        TODO("Not yet implemented")
    }

    override fun showError(errorMessage: String) {
        doToast(errorMessage)
    }

    override fun showNoInternetConnection() {
        doToast("There's no internet connection to make the request.")
    }

    override fun onGameItemClick(position: Int) {
        TODO("Not yet implemented")
    }

    private fun doToast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }
}