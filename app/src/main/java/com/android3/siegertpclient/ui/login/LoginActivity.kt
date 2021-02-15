package com.android3.siegertpclient.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.android3.siegertpclient.R
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.register.RegisterActivity

class LoginActivity : BaseActivity(), LoginContract.ILoginView {

    private val loginPresenter: LoginPresenter = LoginPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val registerTv: TextView = findViewById(R.id.registerClickable) as TextView
        registerTv.setOnClickListener {
            openRegisterActivity()
        }
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