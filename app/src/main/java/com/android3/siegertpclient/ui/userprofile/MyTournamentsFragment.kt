package com.android3.siegertpclient.ui.userprofile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.android3.siegertpclient.R
import com.android3.siegertpclient.ui.homepage.HomepageActivity
import com.android3.siegertpclient.ui.setting.SettingActivity

class MyTournamentsFragment : Fragment(), UserProfileContract.IUserProfileView {

    private val userProfilePresenter: UserProfilePresenter = UserProfilePresenter()

    var settingBtn: Button? = null
    var homeBtn: Button? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        var view = inflater!!.inflate(R.layout.fragment_mytournaments, container, false)

        settingBtn = view.findViewById(R.id.settingsButton)
        settingBtn?.setOnClickListener{
            userProfilePresenter.onSettingBtnClicked()
        }

        homeBtn = view.findViewById(R.id.homeButton)
        homeBtn?.setOnClickListener{
            userProfilePresenter.onHomeBtnClicked()
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        userProfilePresenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        userProfilePresenter.onDetach()
    }

    fun showTournaments() {
        TODO("Not yet implemented")
    }

    fun navigateToTournamentActivity()  {
        TODO("Not yet implemented")
    }

    override fun showMyTournamentsFragment() {
        TODO("Not yet implemented")
    }

    override fun showMyTeamsFragment() {
        //Will not be implemented
    }

    override fun navigateToHomepageActivity() {
        val hIntent = Intent(activity, HomepageActivity::class.java)
        startActivity(hIntent)
    }

    override fun navigateToSettingActivity() {
        val sIntent = Intent(activity, SettingActivity::class.java)
        startActivity(sIntent)
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