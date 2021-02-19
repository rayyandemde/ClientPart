package com.android3.siegertpclient.ui.setting

import com.android3.siegertpclient.ui.base.BasePresenter

class SettingPresenter : BasePresenter<SettingContract.ISettingView>(), SettingContract.ISettingPresenter{
    override fun onBackBtnClicked() {
        view?.navigateToUserProfileActivity()
    }

    override fun onSaveBtnClicked() {
        TODO("Not yet implemented")
    }

    override fun onLogoutBtnClicked() {
        view?.navigateToLoginActivity()
    }

}