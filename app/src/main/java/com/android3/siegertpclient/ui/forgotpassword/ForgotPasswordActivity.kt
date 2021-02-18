package com.android3.siegertpclient.ui.forgotpassword

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.android3.siegertpclient.R
import com.android3.siegertpclient.ui.base.BaseActivity

class ForgotPasswordActivity : BaseActivity(), ForgotPasswordContract.IForgotPasswordView {

    private val forgotPasswordPresenter: ForgotPasswordPresenter = ForgotPasswordPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpassword)

    }

    override fun showErrorOnEmail(message: String) {
        TODO("Not yet implemented")
    }

    override fun showSuccess(message: String) {
        TODO("Not yet implemented")
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hideProgress() {
        TODO("Not yet implemented")
    }

    override fun showError(errorMessage: String) {
        TODO("Not yet implemented")
    }

    override fun showError(errorId: Int) {
        TODO("Not yet implemented")
    }

}