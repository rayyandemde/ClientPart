package com.android3.siegertpclient.ui.setting

import android.content.Context
import com.android3.siegertpclient.ui.base.BasePresenter
import com.android3.siegertpclient.utils.OnlineChecker

class SettingsPresenter(private val context: Context) : BasePresenter<SettingsContract.ISettingView>(), SettingsContract.ISettingPresenter{

    private var onlineChecker = OnlineChecker(context)

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

    override fun onLogoutBtnClicked() {
        view?.navigateToLoginActivity()
    }

}