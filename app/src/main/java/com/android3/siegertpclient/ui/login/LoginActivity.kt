package com.android3.siegertpclient.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.android3.siegertpclient.R
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.forgotpassword.ForgotPasswordActivity
import com.android3.siegertpclient.ui.homepage.HomepageActivity
import com.android3.siegertpclient.ui.register.RegisterActivity

class LoginActivity : BaseActivity(), LoginContract.ILoginView {

    private val loginPresenter: LoginPresenter = LoginPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginBtn: Button = findViewById(R.id.loginBtn)
        loginBtn.setOnClickListener{
            openHomepageActivity()
        }

        val registerTv: TextView = findViewById(R.id.registerClickable)
        registerTv.setOnClickListener {
            openRegisterActivity()
        }

        val letsGoRegister: TextView = findViewById(R.id.letsgoRegister)
        letsGoRegister.setOnClickListener {
            openRegisterActivity()
        }

    }

    private fun openRegisterActivity() {
        val rIntent = Intent(this, RegisterActivity::class.java)
        startActivity(rIntent)
    }

    private fun openForgotPasswordActivity() {
        val fpIntent = Intent(this, ForgotPasswordActivity::class.java)
        startActivity(fpIntent)
    }

    private fun openHomepageActivity() {
        val hIntent = Intent(this, HomepageActivity::class.java)
        startActivity(hIntent)
    }

    override fun navigateToHomepageActivity() {
        TODO("Not yet implemented")
    }

    override fun navigateToForgotPasswordActivity() {
        TODO("Not yet implemented")
    }

    override fun navigateToRegisterActivity() {
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