package com.android3.siegertpclient.ui.homepage

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.android3.siegertpclient.R
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.createteam.CreateTeamActivity
import com.android3.siegertpclient.ui.invitation.InvitationActivity
import com.android3.siegertpclient.ui.register.RegisterActivity
import com.android3.siegertpclient.ui.tournament.TournamentActivity
import com.android3.siegertpclient.ui.userprofile.UserProfileActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomepageActivity : BaseActivity(), HomepageContract.IHomepageView {

    private val homepagePresenter: HomepagePresenter = HomepagePresenter()

    private val joinTeamFragment: JoinTeamFragment
    private val feedFragment: FeedFragment

    init {
        joinTeamFragment = JoinTeamFragment()
        feedFragment = FeedFragment()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)

        when(item.itemId){
            R.id.navigation_feed -> transaction.replace(R.id.fragment_container, feedFragment)
            //R.id.navigation_createtournament -> homepagePresenter.onCreateTournamentBtnClicked()
            R.id.navigation_createtournament -> homepagePresenter.goToTournament()
            R.id.navigation_createteam -> homepagePresenter.onCreateTeamBtnClicked()
            R.id.navigation_jointeam -> transaction.replace(R.id.fragment_container, joinTeamFragment)
            R.id.navigation_userprofile -> homepagePresenter.onUserBtnClicked()

        }

        transaction.commit()

        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        val navigationBar: BottomNavigationView = findViewById(R.id.navigation) as BottomNavigationView

        navigationBar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, feedFragment)
        transaction.commit()
    }

    override fun onResume() {
        super.onResume()
        homepagePresenter.onAttach(this)
    }


    override fun onDestroy() {
        super.onDestroy()
        homepagePresenter.onDetach()
    }

    override fun navigateToInvitationActivity() {
        val invIntent = Intent(this, InvitationActivity::class.java)
        startActivity(invIntent)
    }

    override fun navigateToUserActivity() {
        val upIntent = Intent(this, UserProfileActivity::class.java)
        startActivity(upIntent)
    }

    override fun navigateToCreateTournamentActivity() {
        val cTournamentIntent = Intent(this, CreateTeamActivity::class.java)
        startActivity(cTournamentIntent)
    }

    override fun navigateToCreateTeamActivity() {
        val cTeamIntent = Intent(this, CreateTeamActivity::class.java)
        startActivity(cTeamIntent)
    }

    override fun showFeedFragment() {
        //Will not be implemented
    }

    override fun showJoinTeamFragment() {
        //Will not be implemented
    }

    override fun showSearchResult(tournaments: List<Tournament>) {
        //Open tournament feature will not be implemented
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
    override fun goToTournamentScreen() {
        val tournamentIntent = Intent(this, TournamentActivity::class.java)
        startActivity(tournamentIntent )
    }
}