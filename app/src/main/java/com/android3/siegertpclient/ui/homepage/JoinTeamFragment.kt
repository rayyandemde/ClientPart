package com.android3.siegertpclient.ui.homepage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android3.siegertpclient.R
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.databinding.FragmentFeedBinding
import com.android3.siegertpclient.databinding.FragmentJointeamBinding
import com.android3.siegertpclient.ui.forgotpassword.ForgotPasswordActivity
import com.android3.siegertpclient.ui.team.TeamActivity

class JoinTeamFragment : Fragment() , HomepageContract.IHomepageView {
    private var _binding: FragmentJointeamBinding? = null
    private val binding get() = _binding!!

    private var homepagePresenter: HomepagePresenter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentJointeamBinding.inflate(inflater, container, false)
        homepagePresenter = HomepagePresenter(requireContext())

        val teamNameEt = binding.etTeamName
        val teamPasswordEt = binding.etTeamPassword

        binding.btnJoinTeam.setOnClickListener {

        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        homepagePresenter?.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        homepagePresenter?.onDetach()
        _binding = null
    }

    override fun showFeed(feed: List<Tournament>?) {
        //Not implemented here
    }

    override fun showSuccess(message: String) {
        doToast(message)
    }

    override fun navigateToInvitationActivity() {
        //Not implemented here
    }

    override fun navigateToUserActivity() {
        //Not implemented here
    }

    override fun navigateToCreateTournamentActivity() {
        //Not implemented here
    }

    override fun navigateToCreateTeamActivity() {
        //Not implemented here
    }

    override fun navigateToTournamentActivity() {
        //Not implemented here
    }

    override fun navigateToTeamActivity() {
        val intent = Intent(activity, TeamActivity::class.java)
        startActivity(intent)
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hideProgress() {
        TODO("Not yet implemented")
    }

    override fun showError(errorMessage: String) {
        doToast(errorMessage)
    }

    override fun showNoInternetConnection() {
        doToast("There's no internet connection to make the request.")
    }

    private fun doToast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }
}