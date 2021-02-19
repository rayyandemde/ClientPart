package com.android3.siegertpclient.ui.userprofile

import android.content.Intent
import android.os.Bundle
import com.android3.siegertpclient.R
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.homepage.HomepageActivity
import com.android3.siegertpclient.ui.setting.SettingActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class UserProfileActivity : BaseActivity(), UserProfileContract.IUserProfileView {

    private val userProfilePresenter: UserProfilePresenter = UserProfilePresenter()

    private val myTeamsFragment: MyTeamsFragment
    private val myTournamentsFragment: MyTournamentsFragment

    init {
        myTeamsFragment = MyTeamsFragment()
        myTournamentsFragment = MyTournamentsFragment()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)

        when(item.itemId){
            R.id.navigation_my_tournament -> transaction.replace(R.id.fragment_container, myTournamentsFragment)
            R.id.navigation_my_team -> transaction.replace(R.id.fragment_container, myTeamsFragment)
        }

        transaction.commit()

        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userprofile)

        val navigationBar: BottomNavigationView = findViewById(R.id.navigation_user) as BottomNavigationView

        navigationBar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, myTournamentsFragment)
        transaction.commit()
    }

    override fun onResume() {
        super.onResume()
        userProfilePresenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        userProfilePresenter.onDetach()
    }

    override fun showMyTournamentsFragment() {
        //Will not be implemented
    }

    override fun showMyTeamsFragment() {
        //Will not be implemented
    }

    override fun navigateToHomepageActivity() {
        val hIntent = Intent(this, HomepageActivity::class.java)
        startActivity(hIntent)
    }

    override fun navigateToSettingActivity() {
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

    override fun showError(errorId: Int) {
        TODO("Not yet implemented")
    }

}