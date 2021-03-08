package com.android3.siegertpclient.ui.forgotpassword

import android.content.Context
import android.text.TextUtils
import android.util.Patterns
import com.android3.siegertpclient.ui.base.BasePresenter
import com.android3.siegertpclient.utils.OnlineChecker
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordPresenter(private val context: Context) :
    BasePresenter<ForgotPasswordContract.IForgotPasswordView>(),
    ForgotPasswordContract.IForgotPasswordPresenter {

    private var onlineChecker = OnlineChecker(context)
    private lateinit var auth: FirebaseAuth

    override fun onBackBtnClicked() {
        view?.navigateToLoginActivity()
    }

    override fun onSendBtnClicked(email: String) {
        view?.showProgress()

        if (onlineChecker.isOnline()) {
            if (TextUtils.isEmpty(email) or !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                view?.hideProgress()
                view?.showErrorOnEmail()
            } else {
                auth = FirebaseAuth.getInstance()
                auth.sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            view?.hideProgress()
                            view?.showSuccess()
                        } else {
                            view?.hideProgress()
                            view?.showErrorOnEmail()
                        }
                    }
            }
        } else {
            view?.hideProgress()
            view?.showNoInternetConnection()
        }
    }
}