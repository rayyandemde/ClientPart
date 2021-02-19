package com.android3.siegertpclient.ui.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android3.siegertpclient.R
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.databinding.FragmentFeedBinding

class FeedFragment : Fragment(), HomepageContract.IHomepageView {
/*
    private var _binding: FragmentFeedBinding? = null
    private val binding get() = _binding!!
    */

    var feedRecycler: RecyclerView? = null

    private val homepagePresenter: HomepagePresenter = HomepagePresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        var view = inflater.inflate(R.layout.fragment_feed, container, false)

        feedRecycler = view.findViewById<RecyclerView>(R.id.feed_recycler)

        feedRecycler!!.layoutManager = LinearLayoutManager(context)
        feedRecycler!!.adapter = TournamentOverviewCardRecyclerAdapter()

    /*
        _binding = FragmentFeedBinding.inflate(inflater, container, false)
       binding.feedRecycler.layoutManager = LinearLayoutManager(context)
       binding.feedRecycler.adapter = TournamentOverviewListRecyclerAdapter()
        return binding.root
        */

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
//        _binding = null
    }

    fun navigateToTournamentActivity() {
        //Not implemented here
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

    override fun showFeedFragment() {
        TODO("Not yet implemented")
    }

    override fun showJoinTeamFragment() {
        //Not implemented here
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

    override fun showError(errorId: Int) {
        TODO("Not yet implemented")
    }
}