package com.android3.siegertpclient.ui.register

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android3.siegertpclient.R
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.homepage.HomepageActivity
import com.android3.siegertpclient.ui.login.LoginActivity

class RegisterActivity : BaseActivity(), RegisterContract.IRegisterView {

    lateinit var registerPresenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerPresenter = RegisterPresenter()

        val username : EditText = findViewById(R.id.username)
        val forename : EditText = findViewById(R.id.firstName)
        val surname : EditText = findViewById(R.id.lastName)
        val email : EditText = findViewById(R.id.email)
        val password : EditText = findViewById(R.id.password)
        val retypePassword : EditText = findViewById(R.id.retypePassword)

        val signUpBtn: Button = findViewById(R.id.signUpBtn)
        signUpBtn.setOnClickListener {
            val usernameString = username.text.toString()
            val emailString = email.text.toString()
            val passwordString = password.text.toString()
            val retypePasswordString = retypePassword.text.toString()
            val forenameString = forename.text.toString()
            val surnameString = surname.text.toString()
            registerPresenter.onRegisterBtnClicked(emailString, passwordString,
                retypePasswordString, surnameString, forenameString, usernameString)
        }

        val loginTv: TextView = findViewById(R.id.loginClickable)
        loginTv.setOnClickListener {
            registerPresenter.onLoginTxtClicked()
        }
    }

    override fun onResume() {
        super.onResume()
        registerPresenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        registerPresenter.onDetach()
    }

    override fun showErrorOnEmail(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }

    override fun showErrorOnPassword(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }

    override fun showErrorOnUsername(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }

    override fun navigateToHomepageActivity() {
        val intent = Intent(this, HomepageActivity::class.java)
        startActivity(intent)
    }

    override fun navigateToLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
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