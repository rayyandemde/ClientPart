package com.android3.siegertpclient.ui.forgotpassword

import android.util.Patterns
import com.android3.siegertpclient.ui.base.BasePresenter
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordPresenter : BasePresenter<ForgotPasswordContract.IForgotPasswordView>(), ForgotPasswordContract.IForgotPasswordPresenter{
    private lateinit var auth: FirebaseAuth

    override fun onBackBtnClicked() {
        TODO("Not yet implemented")
    }

    override fun onSendBtnClicked(email : String) {
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            view?.showErrorOnEmail("Email address is not valid")
        }
        auth = FirebaseAuth.getInstance()
        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    view?.showSuccess("Email for changing password sent.")
                }
            }
    }

}