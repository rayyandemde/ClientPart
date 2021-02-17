package com.android3.siegertpclient.ui.register

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.android3.siegertpclient.R
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.forgotpassword.ForgotPasswordActivity
import com.android3.siegertpclient.ui.login.LoginActivity

class RegisterActivity : BaseActivity() {

    private val registerPresenter: RegisterPresenter = RegisterPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val signUpBtn: Button = findViewById(R.id.signUpBtn) as Button
        signUpBtn.setOnClickListener {
            signUpBtnPressed()
        }

        val loginTv: TextView = findViewById(R.id.loginClickable) as TextView
        loginTv.setOnClickListener {
            openLoginActivity()
        }
    }

    private fun openLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    private fun signUpBtnPressed() {
        Toast.makeText(baseContext, "Your account has been created please login", Toast.LENGTH_LONG).show()
        openLoginActivity()
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