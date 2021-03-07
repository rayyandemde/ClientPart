package com.android3.siegertpclient.ui.register

import android.content.Context
import android.util.Patterns
import com.android3.siegertpclient.data.user.usersource.UserRepo
import com.android3.siegertpclient.ui.base.BasePresenter
import com.android3.siegertpclient.utils.OnlineChecker

class RegisterPresenter(context: Context) : BasePresenter<RegisterContract.IRegisterView>(), RegisterContract.IRegisterPresenter{

    private var onlineChecker = OnlineChecker(context)

    private var userRepo = UserRepo()

    override fun onRegisterBtnClicked(
        email: String,
        password: String,
        retypePassword: String,
        surname: String,
        forename: String,
        username: String
    ) {
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            view?.showErrorOnEmail("Email is not valid")
            //throw an exception
        }
        if (password == retypePassword) {
            view?.showErrorOnPassword("Password doesn't match")
            //throw exception
        }

        val user = userRepo.register(email, password, username, forename, surname)
        if (user == null) {
            view?.showError("Register failed")
        } else {
            view?.navigateToHomepageActivity()
        }


    }

    override fun onLoginTxtClicked() {
        view?.navigateToLoginActivity()

        /*
        if(onlineChecker.isOnline()) {
            view?.showError("There's Internet Connection")
        } else {
            view?.showError("There's no internet connection")
        }*/
    }
}