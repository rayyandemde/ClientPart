package com.android3.siegertpclient.ui.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android3.siegertpclient.R

class FeedFragment : Fragment() {

    private val homepagePresenter: HomepagePresenter = HomepagePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_feed, container, false)
    }

    fun navigateToTournamentActivity() {
        TODO("Not yet implemented")
    }
}