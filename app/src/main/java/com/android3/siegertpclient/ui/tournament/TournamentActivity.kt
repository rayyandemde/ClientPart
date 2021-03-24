package com.android3.siegertpclient.ui.tournament

import android.content.Intent
import android.os.Bundle
import android.widget.*
import com.android3.siegertpclient.R
import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.data.tournament.Game
import com.android3.siegertpclient.data.user.User
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
        //Not implemented here
    }

    override fun disableEdits() {
        //Not implemented here
    }

    override fun showIncompleteInput() {
        //Not implemented here
    }

    override fun showSingleParticipants(participants: List<User>?) {
        //Not implemented here
    }

    override fun showTeamParticipants(participants: List<Team>?) {
        //Not implemented here
    }

    override fun showSchedules(schedules: List<Game>?) {
        //Not implemented here
    }

    override fun showGames(games: List<Game>?) {
        //Not implemented here
    }

    override fun navigateToHomepageActivity() {
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