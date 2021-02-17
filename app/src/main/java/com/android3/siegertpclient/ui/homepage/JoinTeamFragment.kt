package com.android3.siegertpclient.ui.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android3.siegertpclient.R

class JoinTeamFragment : Fragment() {

    private val homepagePresenter: HomepagePresenter = HomepagePresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_jointeam, container, false)
    }

    fun navigateToTeamActivity() {
        TODO("Not yet implemented")
    }
}