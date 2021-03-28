package com.android3.siegertpclient.ui.team

import android.os.Bundle
import com.android3.siegertpclient.R
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.databinding.ActivityTeamBinding
import com.android3.siegertpclient.ui.base.BaseActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class TeamActivity : BaseActivity(), TeamContract.ITeamView {
    private lateinit var binding: ActivityTeamBinding
    private lateinit var teamPresenter: TeamPresenter

    private val teamMemberFragment: TeamMemberFragment
    private val teamTournamentsFragment: TeamTournamentsFragment
    private val teamInvitationFragment: TeamInvitationFragment

    init {
        teamMemberFragment = TeamMemberFragment()
        teamTournamentsFragment = TeamTournamentsFragment()
        teamInvitationFragment = TeamInvitationFragment()
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->

            val transaction = supportFragmentManager.beginTransaction()
            transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)

            when (item.itemId) {
                R.id.navigation_team_member -> transaction.replace(
                    R.id.container_team_fragments,
                    teamMemberFragment
                )
                R.id.navigation_team_tournaments -> transaction.replace(
                    R.id.container_team_fragments,
                    teamTournamentsFragment
                )
                R.id.navigation_team_invitation -> transaction.replace(
                    R.id.container_team_fragments,
                    teamInvitationFragment
                )
                R.id.navigation_delete_team -> showDeleteAlert()
            }

            transaction.commit()

            true
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        teamPresenter = TeamPresenter(this)

        binding.bnvTeam.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container_team_fragments, teamMemberFragment)
        transaction.commit()
    }

    override fun onResume() {
        super.onResume()
        teamPresenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        teamPresenter.onDetach()
    }

    override fun navigateToTournamentActivity() {
        //Not implemented here
    }

    override fun showDeleteAlert() {
        //Needs to be implemented *Just a placeholder comment so the app can run
    }

    override fun showMembers(teamMembers: List<User>?) {
        //Not implemented here
    }

    override fun showProgress() {
        //Not implemented here
    }

    override fun hideProgress() {
        //Not implemented here
    }

    override fun showError(errorMessage: String) {
        //Not implemented here
    }

    override fun showNoInternetConnection() {
        //Not implemented here
    }
}