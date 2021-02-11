package com.android3.siegertpclient.ui.login

import com.android3.siegertpclient.ui.base.BasePresenter

class LoginPresenter : BasePresenter<LoginContract.ILoginView>(), LoginContract.ILoginPresenter{
    override fun onLoginBtnClicked(username: String, password: String) {
        TODO("Not yet implemented")
    }

    override fun onForgotPasswordTextClicked() {
        TODO("Not yet implemented")
    }

    override fun onRegisterTextClicked() {
        TODO("Not yet implemented")
    }
}