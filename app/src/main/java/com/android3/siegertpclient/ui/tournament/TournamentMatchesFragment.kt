package com.android3.siegertpclient.ui.tournament

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android3.siegertpclient.R
import com.android3.siegertpclient.data.tournament.Game
import com.android3.siegertpclient.data.tournament.Result
import com.android3.siegertpclient.databinding.FragmentTournamentmatchesBinding
import com.android3.siegertpclient.databinding.FragmentTournamentschedulesBinding
import com.android3.siegertpclient.utils.recyclerviewadapters.GameAdapter
import com.android3.siegertpclient.utils.recyclerviewadapters.ScheduleAdapter
import com.android3.siegertpclient.utils.recyclerviewadapters.TournamentAdapter

class TournamentMatchesFragment : Fragment() , TournamentContract.ITournamentView, GameAdapter.OnGameItemClickListener{
    private var _binding: FragmentTournamentmatchesBinding? = null
    private val binding get() = _binding!!

    private var tournamentPresenter: TournamentPresenter? = null

    private val noSchedule by lazy {
        val noResult = Result("", "","")
        listOf(Game("There is", "", noResult, "no schedule", ""))
    }

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

    fun showGames(games: List<Game>) {
        TODO("Not yet implemented")
    }

    fun showEditGamesBtn() {
        TODO("Not yet implemented")
    }

    fun showAddGameBtn() {
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

    override fun onGameItemClick(position: Int) {
        TODO("Not yet implemented")
    }

//    fun showListOfParticipant(participants: Participant[]) {
//        TODO("Not yet implemented")
//    }
}