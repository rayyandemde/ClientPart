package com.android3.siegertpclient.ui.team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android3.siegertpclient.R
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.ui.homepage.TournamentOverviewCardRecyclerAdapter

class TeamTournamentsFragment : Fragment() {

    private val teamPresenter: TeamPresenter = TeamPresenter()

    var teamTournamentsRecycler : RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        var view = inflater!!.inflate(R.layout.fragment_teamtournaments, container, false)

        teamTournamentsRecycler = view.findViewById<RecyclerView>(R.id.team_tournaments_recycler)

        teamTournamentsRecycler!!.layoutManager = LinearLayoutManager(context)
        teamTournamentsRecycler!!.adapter = TournamentOverviewCardRecyclerAdapter()

        return view
    }

    fun showTournaments(tournaments: List<Tournament>) {
        TODO("Not yet implemented")
    }
}