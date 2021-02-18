package com.android3.siegertpclient.ui.login

import LoginContract
import com.android3.siegertpclient.data.userdummy.usersource.UserRepo
import com.android3.siegertpclient.ui.base.BasePresenter

class LoginPresenter : BasePresenter<LoginContract.ILoginView>(), LoginContract.ILoginPresenter{
    private var userRepo = UserRepo()

    override fun onLoginBtnClicked(email: String, password: String) {
        val user = userRepo.login(email, password)
        if (user == null) {
            //this is better implemented with exception
            view?.showError("Login failed.")
        } else {
            view?.navigateToHomepageActivity()
        }
    }

    override fun onForgotPasswordTextClicked() {
        view?.navigateToForgotPasswordActivity()
    }

    override fun onRegisterTextClicked() {
        view?.navigateToRegisterActivity()
    }
}