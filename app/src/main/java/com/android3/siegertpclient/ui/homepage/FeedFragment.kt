package com.android3.siegertpclient.ui.homepage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android3.siegertpclient.R
import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.tournament.TournamentDetail
import com.android3.siegertpclient.databinding.FragmentFeedBinding
import com.android3.siegertpclient.ui.invitation.InvitationActivity
import com.android3.siegertpclient.utils.recyclerviewadapters.TournamentAdapter

class FeedFragment : Fragment(), HomepageContract.IHomepageView, TournamentAdapter.OnTournamentItemClickListener {
    private var _binding: FragmentFeedBinding? = null
    private val binding get() = _binding!!

    private var homepagePresenter: HomepagePresenter? = null

    private val noTournaments by lazy {
        var noTournamentDetail = TournamentDetail("", "YYYY-MM-DD", "", "", "", "YYYY-MM-DD", "", "")
        listOf(Tournament("", emptyList(), 0, false, emptyList(), emptyMap(), noTournamentDetail, "", "No Tournament Available", ""))
    }

    private val tournamentAdapter by lazy { TournamentAdapter(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        _binding = FragmentFeedBinding.inflate(inflater, container, false)
        homepagePresenter = HomepagePresenter(requireContext())

        binding.rvFeed.adapter = tournamentAdapter

        homepagePresenter?.onFeedRefresh()

        binding.srlRvFeed.setOnRefreshListener {
            homepagePresenter?.onFeedRefresh()
        }

        binding.btnInvitation.setOnClickListener{
            homepagePresenter?.onInvitationBtnClicked()
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
        TODO("Not yet implemented")
    }

    override fun showSuccess(message: String) {
        TODO("Not yet implemented")
    }

    override fun showIncompleteInput() {
        TODO("Not yet implemented")
    }

    override fun navigateToInvitationActivity() {
        val invIntent = Intent(activity, InvitationActivity::class.java)
        startActivity(invIntent)
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
        TODO("Not yet implemented")
    }

    override fun navigateToTeamActivity() {
        //Not implemented here
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

    override fun onTournamentItemClick(position: Int) {
        homepagePresenter?.onTournamentOverviewClicked(position)
    }
}