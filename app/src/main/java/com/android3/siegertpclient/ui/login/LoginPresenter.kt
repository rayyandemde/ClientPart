package com.android3.siegertpclient.ui.login

import LoginContract
import android.content.Context
import android.text.TextUtils
import android.util.Patterns
import com.android3.siegertpclient.ui.base.BasePresenter
import com.android3.siegertpclient.utils.OnlineChecker
import com.google.firebase.auth.FirebaseAuth


class LoginPresenter(private val context: Context) : BasePresenter<LoginContract.ILoginView>(),
    LoginContract.ILoginPresenter {

    private var onlineChecker = OnlineChecker(context)

    override fun onLoginBtnClicked(email: String, password: String) {
        view?.showProgress()

        when {
            TextUtils.isEmpty(email) or TextUtils.isEmpty(password) -> {
                view?.showIncompleteInput()
                view?.hideProgress()
            }

            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                view?.showErrorOnEmail()
                view?.hideProgress()
            }
            else -> {
                if (onlineChecker.isOnline()) {
                    FirebaseAuth.getInstance()
                        .signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener({ task ->
                            if (task.isSuccessful) {
                                view?.navigateToHomepageActivity()
                            } else {
                                view?.hideProgress()
                                view?.showError(task.exception!!.message.toString())
                            }
                        })
                } else {
                    view?.hideProgress()
                    view?.showNoInternetConnection()
                }
            }
        }
    }

    override fun onForgotPasswordTextClicked() {
        view?.navigateToForgotPasswordActivity()
    }

    override fun onRegisterTextClicked() {
        view?.navigateToRegisterActivity()
    }
}