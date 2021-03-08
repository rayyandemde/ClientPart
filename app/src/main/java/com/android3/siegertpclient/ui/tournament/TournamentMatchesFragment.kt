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
import com.android3.siegertpclient.data.game.Game
import com.android3.siegertpclient.ui.homepage.TournamentOverviewCardRecyclerAdapter

class TournamentMatchesFragment : Fragment() , TournamentContract.ITournamentView{

    private val tournamentPresenter: TournamentPresenter = TournamentPresenter()
    var centerBt : Button? =null
    var linkEt : EditText? =null
    var openBt : Button?=null

    var tournamentMatchesRecycler: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        var view = inflater.inflate(R.layout.fragment_tournamentmatches, container, false)

        tournamentMatchesRecycler = view.findViewById<RecyclerView>(R.id.tournament_matches_recycler)

        tournamentMatchesRecycler!!.layoutManager = LinearLayoutManager(context)
        tournamentMatchesRecycler!!.adapter = TournamentOverviewCardRecyclerAdapter()

        centerBt = view.findViewById(R.id.buttonCenter)
        linkEt = view.findViewById(R.id.stagesImagesLink)
        openBt = view.findViewById(R.id.openLinkBtn)

        return view
    }
    override fun onResume() {
        super.onResume()
        tournamentPresenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        tournamentPresenter.onDetach()
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

//    fun showListOfParticipant(participants: Participant[]) {
//        TODO("Not yet implemented")
//    }
}