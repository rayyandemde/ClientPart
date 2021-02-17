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
        val registerTv: TextView = findViewById(R.id.loginClickable) as TextView
        registerTv.setOnClickListener {
            openRegisterActivity()
        }
        val loginBtn: Button = findViewById(R.id.signUpBtn) as Button
        loginBtn.setOnClickListener{
            openHomepageActivity()
        }
        val fogotPasswordTv: TextView = findViewById(R.id.forgotPassword) as TextView
        registerTv.setOnClickListener {
            openForgotPasswordActivity()
        }
    }

    private fun openForgotPasswordActivity() {
        val intent = Intent(this, ForgotPasswordActivity::class.java)
        startActivity(intent)
    }

    private fun openHomepageActivity() {
        val intent = Intent(this, HomepageActivity::class.java)
        startActivity(intent)
    }

    private fun openRegisterActivity() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
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