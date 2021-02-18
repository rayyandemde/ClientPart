package com.android3.siegertpclient.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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

        val emailTxt : EditText = findViewById(R.id.email)
        val passwordTxt: EditText = findViewById(R.id.password)

        val registerTv: TextView = findViewById(R.id.registerClickable)
        registerTv.setOnClickListener {
            loginPresenter.onRegisterTextClicked()
        }

        val loginBtn: Button = findViewById(R.id.loginBtn)
        loginBtn.setOnClickListener{
            loginPresenter.onLoginBtnClicked(emailTxt.text.toString(), passwordTxt.text.toString())
        }

        val forgotPasswordTv: TextView = findViewById(R.id.forgotPassword)
        forgotPasswordTv.setOnClickListener {
            loginPresenter.onForgotPasswordTextClicked()
        }

    }

    override fun onResume() {
        super.onResume()
        loginPresenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        loginPresenter.onDetach()
    }

    override fun navigateToHomepageActivity() {
        val hIntent = Intent(this, HomepageActivity::class.java)
        startActivity(hIntent)
    }

    override fun navigateToForgotPasswordActivity() {
        val fpIntent = Intent(this, ForgotPasswordActivity::class.java)
        startActivity(fpIntent)
    }

    override fun navigateToRegisterActivity() {
        val fpIntent2 = Intent(this, RegisterActivity::class.java)
        startActivity(fpIntent2)
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hideProgress() {
        TODO("Not yet implemented")
    }

    override fun showError(errorMessage: String) {
        Toast.makeText(applicationContext, errorMessage, Toast.LENGTH_LONG).show()
    }

    override fun showError(errorId: Int) {
        TODO("Not yet implemented")
    }

}