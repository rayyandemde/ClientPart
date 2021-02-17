package com.android3.siegertpclient.ui.homepage

import android.os.Bundle
import android.widget.Button
import com.android3.siegertpclient.R
import com.android3.siegertpclient.ui.base.BaseActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomepageActivity : BaseActivity() {

    private val homepagePresenter: HomepagePresenter = HomepagePresenter()

    private val joinTeamFragment: JoinTeamFragment
    private val feedFragment: FeedFragment

    init {
        joinTeamFragment = JoinTeamFragment()
        feedFragment = FeedFragment()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)

        when(item.itemId){
            R.id.navigation_feed -> transaction.replace(R.id.fragment_container, feedFragment)
            R.id.navigation_jointeam -> transaction.replace(R.id.fragment_container, joinTeamFragment)
        }

        transaction.commit()

        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        val navigationBar: BottomNavigationView = findViewById(R.id.navigation) as BottomNavigationView

        navigationBar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, feedFragment)
        transaction.commit()
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