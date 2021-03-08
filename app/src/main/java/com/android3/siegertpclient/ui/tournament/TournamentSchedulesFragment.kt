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
import com.android3.siegertpclient.data.game.Game
import com.android3.siegertpclient.ui.homepage.TournamentOverviewCardRecyclerAdapter

class TournamentSchedulesFragment : Fragment() , TournamentContract.ITournamentView{

    private val tournamentPresenter: TournamentPresenter = TournamentPresenter()

    var tournamentsSchedulesRecycler: RecyclerView? = null

    var addBt : Button?= null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        var view = inflater.inflate(R.layout.fragment_tournamentschedules, container, false)

        tournamentsSchedulesRecycler = view.findViewById<RecyclerView>(R.id.schedules_recycler)
        tournamentsSchedulesRecycler!!.layoutManager = LinearLayoutManager(context)
        tournamentsSchedulesRecycler!!.adapter = TournamentOverviewCardRecyclerAdapter()

        addBt =view.findViewById(R.id.addBt)

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

    override fun showError(errorId: Int) {
        TODO("Not yet implemented")
    }

    override fun showNoInternetConnection() {
        TODO("Not yet implemented")
    }
}