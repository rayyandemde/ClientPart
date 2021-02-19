package com.android3.siegertpclient.ui.team

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android3.siegertpclient.R
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.ui.homepage.HomepageActivity
import com.android3.siegertpclient.ui.homepage.TournamentOverviewCardRecyclerAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TeamTournamentsFragment : Fragment(), TeamContract.ITeamView{

    private val teamPresenter: TeamPresenter = TeamPresenter()

    var teamTournamentsRecycler : RecyclerView? = null
    var homeBtn: ImageView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        var view = inflater!!.inflate(R.layout.fragment_teamtournaments, container, false)

        teamTournamentsRecycler = view.findViewById<RecyclerView>(R.id.team_tournaments_recycler)

        teamTournamentsRecycler!!.layoutManager = LinearLayoutManager(context)
        teamTournamentsRecycler!!.adapter = TournamentOverviewCardRecyclerAdapter()

        homeBtn = view.findViewById<ImageView>(R.id.homeBtnTeam)
        homeBtn?.setOnClickListener{
            teamPresenter.onHomeBtnClicked()
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        teamPresenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    fun showTournaments(tournaments: List<Tournament>) {
        TODO("Not yet implemented")
    }

    override fun navigateToHomepageActivity() {
        val hIntent = Intent(activity, HomepageActivity::class.java)
        startActivity(hIntent)
    }

    override fun showAdminFragment() {
        TODO("Not yet implemented")
    }

    override fun showMemberFragment() {
        TODO("Not yet implemented")
    }

    override fun showTeamTournamentsFragment() {
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