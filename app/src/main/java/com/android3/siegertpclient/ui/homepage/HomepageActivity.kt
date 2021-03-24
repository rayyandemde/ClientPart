package com.android3.siegertpclient.ui.homepage

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.android3.siegertpclient.R
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.databinding.ActivityHomepageBinding
import com.android3.siegertpclient.databinding.ActivityUserprofileBinding
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.createteam.CreateTeamActivity
import com.android3.siegertpclient.ui.createtournament.CreateTournamentActivity
import com.android3.siegertpclient.ui.invitation.InvitationActivity
import com.android3.siegertpclient.ui.tournament.TournamentActivity
import com.android3.siegertpclient.ui.userprofile.UserProfileActivity
import com.android3.siegertpclient.ui.userprofile.UserProfilePresenter
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomepageActivity : BaseActivity(), HomepageContract.IHomepageView {

    private lateinit var binding: ActivityHomepageBinding
    private lateinit var homepagePresenter: HomepagePresenter

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
            R.id.navigation_feed -> transaction.replace(R.id.container_homepage_fragments, feedFragment)
            R.id.navigation_createtournament -> homepagePresenter.onCreateTournamentBtnClicked()

            R.id.navigation_createteam -> homepagePresenter.onCreateTeamBtnClicked()
            R.id.navigation_jointeam -> transaction.replace(R.id.container_homepage_fragments, joinTeamFragment)
            R.id.navigation_userprofile -> homepagePresenter.onUserBtnClicked()

        }

        transaction.commit()

        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        homepagePresenter = HomepagePresenter(this)

        binding.bnvHomepage.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container_homepage_fragments, feedFragment)
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

    override fun showFeed(feed: List<Tournament>?) {
        //Not implemented here
    }

    override fun showSuccess(message: String) {
        TODO("Not yet implemented")
    }

    override fun showIncompleteInput() {
        TODO("Not yet implemented")
    }

    override fun navigateToInvitationActivity() {
        val intent = Intent(this, InvitationActivity::class.java)
        startActivity(intent)
    }

    override fun navigateToUserActivity() {
        val intent = Intent(this, UserProfileActivity::class.java)
        startActivity(intent)
    }

    override fun navigateToCreateTournamentActivity() {
        val intent = Intent(this, CreateTournamentActivity::class.java)
        startActivity(intent)
    }

    override fun navigateToCreateTeamActivity() {
        val intent = Intent(this, CreateTeamActivity::class.java)
        startActivity(intent)
    }

    override fun navigateToTournamentActivity() {
        //Not implemented here
    }

    override fun navigateToTeamActivity() {
        TODO("Not yet implemented")
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