package com.android3.siegertpclient.ui.team

import android.os.Bundle
import com.android3.siegertpclient.R
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.userprofile.MyTeamsFragment
import com.android3.siegertpclient.ui.userprofile.MyTournamentsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class TeamActivity : BaseActivity(), TeamContract.ITeamView {

    private val teamPresenter: TeamPresenter = TeamPresenter()

    private val teamMemberFragment: TeamMemberFragment
    private val teamTournamentsFragment: TeamTournamentsFragment
    private val teamInvitationFragment: TeamInvitationFragment

    init {
        teamMemberFragment = TeamMemberFragment()
        teamTournamentsFragment = TeamTournamentsFragment()
        teamInvitationFragment = TeamInvitationFragment()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)

        when(item.itemId){
            R.id.navigation_team_member -> transaction.replace(R.id.fragment_container, teamMemberFragment)
            R.id.navigation_team_tournaments -> transaction.replace(R.id.fragment_container, teamTournamentsFragment)
            R.id.navigation_team_invitation -> transaction.replace(R.id.fragment_container, teamInvitationFragment)
        }

        transaction.commit()

        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)

        val navigationBar: BottomNavigationView = findViewById(R.id.navigation_team) as BottomNavigationView

        navigationBar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, teamMemberFragment)
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

    override fun showAdminFragment() {
        //Will not be implemented
    }

    override fun showMemberFragment() {
        //Will not be implemented
    }

    override fun showTeamTournamentsFragment() {
        //Will not be implemented
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