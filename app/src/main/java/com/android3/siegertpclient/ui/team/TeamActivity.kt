package com.android3.siegertpclient.ui.team

import android.os.Bundle
import android.widget.Toast
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
                    R.id.container_team_fragment,
                    teamMemberFragment
                )
                R.id.navigation_team_tournaments -> transaction.replace(
                    R.id.container_team_fragment,
                    teamTournamentsFragment
                )
                R.id.navigation_team_invitation -> transaction.replace(
                    R.id.container_team_fragment,
                    teamInvitationFragment
                )
            }

            transaction.commit()

            true
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        teamPresenter = TeamPresenter(this)


        binding.navigationTeam.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container_team_fragment, teamMemberFragment)
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
        TODO("Not yet implemented")
    }

    override fun showMembers(teamMembers: List<User>) {
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

    private fun doToast(message: String) {
        Toast.makeText(this@TeamActivity, message, Toast.LENGTH_LONG).show()
    }
}