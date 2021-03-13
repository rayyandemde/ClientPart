package com.android3.siegertpclient.ui.setting

import android.content.Context
import android.content.Intent
import com.android3.siegertpclient.ui.base.BasePresenter
import com.android3.siegertpclient.ui.dummyretrofit.util.Constants.Companion.KEY_FORENAME
import com.android3.siegertpclient.ui.dummyretrofit.util.Constants.Companion.KEY_SURNAME
import com.android3.siegertpclient.ui.dummyretrofit.util.Constants.Companion.KEY_USERNAME
import com.android3.siegertpclient.ui.login.LoginActivity
import com.android3.siegertpclient.utils.OnlineChecker
import com.android3.siegertpclient.utils.PreferencesProvider
import com.google.firebase.auth.FirebaseAuth

class SettingsPresenter(private val context: Context) : BasePresenter<SettingsContract.ISettingView>(), SettingsContract.ISettingPresenter{

    private var onlineChecker = OnlineChecker(context)
    private var preferencesProvider = PreferencesProvider(context)

    fun getUser() : String {
        val username = preferencesProvider.getString(KEY_USERNAME)!!
        val forename = preferencesProvider.getString(KEY_FORENAME)!!
        val surname = preferencesProvider.getString(KEY_SURNAME)!!
        return "Username :: $username \nFirst Name :: $forename \nLast Name :: $surname"
    }

    override fun onBackBtnClicked() {
        view?.navigateToUserProfileActivity()
    }

    override fun onChangeLanguageBtnClicked() {
        view?.showError("This feature is still under development. " +
                "Let us know if there's any language that you would love for us to support in future updates!")
    }

    override fun onSaveBtnClicked(
        changedUsername: String,
        changedForename: String,
        changedSurname: String
    ) {
        view?.showProgress()


    }

    override fun onLogoutTextClicked() {
        FirebaseAuth.getInstance().signOut()
        preferencesProvider.clearData()
        view?.navigateToLoginActivity()
    }

}