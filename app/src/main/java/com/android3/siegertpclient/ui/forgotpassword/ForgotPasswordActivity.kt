package com.android3.siegertpclient.ui.forgotpassword

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android3.siegertpclient.R
import com.android3.siegertpclient.ui.base.BaseActivity

class ForgotPasswordActivity : BaseActivity(), ForgotPasswordContract.IForgotPasswordView {

    private val forgotPasswordPresenter: ForgotPasswordPresenter = ForgotPasswordPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpassword)

        val emailEt: EditText = findViewById(R.id.email)

        val signUpBtn: Button = findViewById(R.id.buttonSend)
        signUpBtn.setOnClickListener{
            forgotPasswordPresenter.onSendBtnClicked(emailEt.getText().toString())
        }
    }

    override fun onResume() {
        super.onResume()
        forgotPasswordPresenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        forgotPasswordPresenter.onDetach()
    }

    override fun showErrorOnEmail(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }

    override fun showSuccess(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
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