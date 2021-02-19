package com.android3.siegertpclient.ui.tournament

import android.content.Intent
import android.os.Bundle
import android.widget.*
import com.android3.siegertpclient.R
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.createteam.CreateTeamActivity
import com.android3.siegertpclient.ui.forgotpassword.ForgotPasswordActivity
import com.android3.siegertpclient.ui.homepage.FeedFragment
import com.android3.siegertpclient.ui.homepage.HomepageActivity
import com.android3.siegertpclient.ui.homepage.JoinTeamFragment
import com.android3.siegertpclient.ui.register.RegisterActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


class TournamentActivity() : BaseActivity(),TournamentContract.ITournamentView{

    private val tournamentPresenter: TournamentPresenter = TournamentPresenter()

    private val tournamentMatchesFragment:TournamentMatchesFragment

    private  val tournamentParticipantsFragment : TournamentParticipantsFragment

    private val tournamentSchedulesFragment : TournamentSchedulesFragment

    private val tournamentUpdatesFragment:TournamentUpdatesFragment

    private val tournamentDetailsFragment: TournamentDetailsFragment
    init {
        tournamentMatchesFragment=TournamentMatchesFragment()
        tournamentSchedulesFragment = TournamentSchedulesFragment()
       tournamentParticipantsFragment = TournamentParticipantsFragment()
        tournamentUpdatesFragment=TournamentUpdatesFragment()
        tournamentDetailsFragment=TournamentDetailsFragment()
    }


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)

        when(item.itemId){
            R.id.navigation_tournament_info -> transaction.replace(R.id.fragment_container, tournamentDetailsFragment)
            R.id.navigation_participants -> transaction.replace(R.id.fragment_container, tournamentParticipantsFragment)
            R.id.navigation_schedule -> transaction.replace(R.id.fragment_container, tournamentSchedulesFragment)
            R.id.navigation_match_info -> transaction.replace(R.id.fragment_container, tournamentMatchesFragment)
            R.id.navigation_changelogs -> transaction.replace(R.id.fragment_container, tournamentUpdatesFragment)
        }

        transaction.commit()

        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tournament)

        val navigationBar: BottomNavigationView = findViewById(R.id.navigation) as BottomNavigationView

        navigationBar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container,tournamentDetailsFragment)
        transaction.commit()
    }

    override fun onResume() {
        super.onResume()
        tournamentPresenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        tournamentPresenter.onDetach()
    }

    private fun openRegisterActivity() {
        val rIntent = Intent(this, RegisterActivity::class.java)
        startActivity(rIntent)
    }

    private fun openForgotPasswordActivity() {
        val fpIntent = Intent(this, ForgotPasswordActivity::class.java)
        startActivity(fpIntent)
    }


    override fun showTournamentDetailsFragment() {

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
        val cTeamIntent = Intent(this, HomepageActivity::class.java)
        startActivity(cTeamIntent)
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hideProgress() {
        TODO("Not yet implemented")
    }

    override fun showError(errorMessage: String) {
        Toast.makeText(applicationContext, errorMessage, Toast.LENGTH_LONG).show()
    }

    override fun showError(errorId: Int) {
        Toast.makeText(applicationContext, errorId, Toast.LENGTH_LONG).show()
    }

}