package com.android3.siegertpclient.ui.tournament

import android.content.Intent
import android.os.Bundle
import android.widget.*
import com.android3.siegertpclient.R
import com.android3.siegertpclient.databinding.ActivityTournamentBinding
import com.android3.siegertpclient.databinding.ActivityUserprofileBinding
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.createteam.CreateTeamActivity
import com.android3.siegertpclient.ui.forgotpassword.ForgotPasswordActivity
import com.android3.siegertpclient.ui.homepage.FeedFragment
import com.android3.siegertpclient.ui.homepage.HomepageActivity
import com.android3.siegertpclient.ui.homepage.JoinTeamFragment
import com.android3.siegertpclient.ui.register.RegisterActivity
import com.android3.siegertpclient.ui.userprofile.UserProfilePresenter
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * This tournament
 */
class TournamentActivity() : BaseActivity(), TournamentContract.ITournamentView {
    private lateinit var binding: ActivityTournamentBinding
    private lateinit var tournamentPresenter: TournamentPresenter

    private val tournamentMatchesFragment: TournamentMatchesFragment

    private val tournamentParticipantsFragment: TournamentParticipantsFragment

    private val tournamentSchedulesFragment: TournamentSchedulesFragment

    private val deleteTournamentFragment: DeleteTournamentFragment

    private val tournamentDetailsFragment: TournamentDetailsFragment

    init {
        tournamentMatchesFragment = TournamentMatchesFragment()
        tournamentSchedulesFragment = TournamentSchedulesFragment()
        tournamentParticipantsFragment = TournamentParticipantsFragment()
        deleteTournamentFragment = DeleteTournamentFragment()
        tournamentDetailsFragment = TournamentDetailsFragment()
    }


    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->

            val transaction = supportFragmentManager.beginTransaction()
            transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)

            when (item.itemId) {
                R.id.navigation_tournament_info -> transaction.replace(
                    R.id.container_tournament_fragments,
                    tournamentDetailsFragment
                ).addToBackStack(null)
                R.id.navigation_participants -> transaction.replace(
                    R.id.container_tournament_fragments,
                    tournamentParticipantsFragment
                ).addToBackStack(null)
                R.id.navigation_schedule -> transaction.replace(
                    R.id.container_tournament_fragments,
                    tournamentSchedulesFragment
                ).addToBackStack(null)
                R.id.navigation_match_info -> transaction.replace(
                    R.id.container_tournament_fragments,
                    tournamentMatchesFragment
                ).addToBackStack(null)
                R.id.navigation_changelogs -> transaction.replace(
                    R.id.container_tournament_fragments,
                    deleteTournamentFragment
                ).addToBackStack(null)
            }

            transaction.commit()

            true
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTournamentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tournamentPresenter = TournamentPresenter(this)

        binding.bnvTournament.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container_tournament_fragments, tournamentDetailsFragment)
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

    override fun showCurrentTournamentDetails(
        tournamentName: String,
        typeOfGame: String,
        matchType: String,
        tournamentType: String,
        participantForm: String,
        registrationDeadline: String,
        startDate: String,
        endDate: String,
        location: String,
        maxPlayer: Int
    ) {

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

    override fun showNoInternetConnection() {
        TODO("Not yet implemented")
    }

}