package com.android3.siegertpclient.ui.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.android3.siegertpclient.R
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.databinding.FragmentFeedBinding
import com.android3.siegertpclient.databinding.FragmentJointeamBinding

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

    fun navigateToTeamActivity() {
        TODO("Not yet implemented")
    }

    override fun showFeed(feed: List<Tournament>?) {
        TODO("Not yet implemented")
    }

    override fun navigateToInvitationActivity() {
        TODO("Not yet implemented")
    }

    override fun navigateToUserActivity() {
        TODO("Not yet implemented")
    }

    override fun navigateToCreateTournamentActivity() {
        TODO("Not yet implemented")
    }

    override fun navigateToCreateTeamActivity() {
        TODO("Not yet implemented")
    }

    override fun navigateToTournamentActivity() {
        TODO("Not yet implemented")
    }

    override fun showSearchResult(tournaments: List<Tournament>) {
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
}