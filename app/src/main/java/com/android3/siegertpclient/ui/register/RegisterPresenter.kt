package com.android3.siegertpclient.ui.register

import com.android3.siegertpclient.ui.base.BasePresenter

class RegisterPresenter : BasePresenter<RegisterContract.IRegisterView>(), RegisterContract.IRegisterPresenter{
    override fun onRegisterBtnClicked(email: String, password: String, username: String) {
        TODO("Not yet implemented")
    }

    override fun onBackBtnClicked() {
        TODO("Not yet implemented")
    }
}