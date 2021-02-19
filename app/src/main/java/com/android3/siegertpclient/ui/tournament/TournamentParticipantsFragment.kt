package com.android3.siegertpclient.ui.tournament

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android3.siegertpclient.R
import com.android3.siegertpclient.ui.homepage.TournamentOverviewCardRecyclerAdapter

class TournamentParticipantsFragment : Fragment(), TournamentContract.ITournamentView {

    private val tournamentPresenter: TournamentPresenter = TournamentPresenter()

    var tournamentParticipantsRecycler: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        var view = inflater.inflate(R.layout.fragment_tournamentparticipants, container, false)

        tournamentParticipantsRecycler = view.findViewById<RecyclerView>(R.id.participants_recycler)

        tournamentParticipantsRecycler!!.layoutManager = LinearLayoutManager(context)
        tournamentParticipantsRecycler!!.adapter = TournamentOverviewCardRecyclerAdapter()

        return view
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
}