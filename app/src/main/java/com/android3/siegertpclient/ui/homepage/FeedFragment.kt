package com.android3.siegertpclient.ui.homepage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.databinding.FragmentFeedBinding
import com.android3.siegertpclient.ui.invitation.InvitationActivity
import com.android3.siegertpclient.ui.tournament.TournamentActivity
import com.android3.siegertpclient.utils.LocalCache
import com.android3.siegertpclient.utils.recyclerviewadapters.TournamentAdapter

class FeedFragment : Fragment(), HomepageContract.IHomepageView, TournamentAdapter.OnTournamentItemClickListener {
    private var _binding: FragmentFeedBinding? = null
    private val binding get() = _binding!!

    private var homepagePresenter: HomepagePresenter? = null

    private val tournamentAdapter by lazy { TournamentAdapter(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFeedBinding.inflate(inflater, container, false)
        homepagePresenter = HomepagePresenter(requireContext())

        binding.tvWelcomeUsername.text = "Welcome " + LocalCache.getCurrentUsername(requireContext())

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
        //Needs to be implemented *Just a placeholder comment so the app can run
    }

    override fun showSuccess(message: String) {
        TODO("Not yet implemented")
    }

    override fun showIncompleteInput() {
        //Not implemented here
    }

    override fun navigateToInvitationActivity() {
        val intent = Intent(activity, InvitationActivity::class.java)
        startActivity(intent)
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
        val intent = Intent(activity, TournamentActivity::class.java)
        startActivity(intent)
    }

    override fun navigateToTeamActivity() {
        //Not implemented here
    }

    override fun showProgress() {
        //Not needed for plain swipe refresh layout
    }

    override fun hideProgress() {
        binding.srlRvFeed.isRefreshing = false
    }

    override fun showError(errorMessage: String) {
        doToast(errorMessage)
    }

    override fun showNoInternetConnection() {
        doToast("There's no internet connection to make the request.")
    }

    override fun onTournamentItemClick(position: Int) {
        homepagePresenter?.onTournamentOverviewClicked(position)
    }

    private fun doToast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }
}