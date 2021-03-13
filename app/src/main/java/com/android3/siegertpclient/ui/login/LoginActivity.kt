package com.android3.siegertpclient.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.android3.siegertpclient.R
import com.android3.siegertpclient.databinding.ActivityLoginBinding
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.dummyretrofit.util.Constants
import com.android3.siegertpclient.ui.forgotpassword.ForgotPasswordActivity
import com.android3.siegertpclient.ui.homepage.HomepageActivity
import com.android3.siegertpclient.ui.register.RegisterActivity


class LoginActivity : BaseActivity(), LoginContract.ILoginView {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setTheme(R.style.Theme_SiegerTPClient)
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginPresenter = LoginPresenter(this)

        val emailEt = binding.etEmail
        val passwordEt = binding.etPassword

        binding.tvRegister.setOnClickListener {
            loginPresenter.onRegisterTextClicked()
        }

        binding.btnLogin.setOnClickListener {
            loginPresenter.onLoginBtnClicked(
                emailEt.text.toString().trim { it <= ' ' },
                passwordEt.text.toString().trim { it <= ' ' })
        }

        binding.tvForgotPassword.setOnClickListener {
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

    override fun showIncompleteInput() {
        doToast("Please fill in all of the field")
    }

    override fun showErrorOnEmail() {
        doToast("Email is not valid")
    }

    override fun navigateToHomepageActivity(userId: String, token: String) {
        doToast("You are logged in successfully.")
        val intent = Intent(this@LoginActivity, HomepageActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        intent.putExtra(Constants.KEY_USER_ID, userId)
        intent.putExtra(Constants.KEY_TOKEN, token)
        startActivity(intent)
        finish()
    }

    override fun navigateToForgotPasswordActivity() {
        val intent = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
        startActivity(intent)
    }

    override fun navigateToRegisterActivity() {
        val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
        startActivity(intent)
    }

    override fun showProgress() {
        binding.pbRequest.visibility = View.VISIBLE
        binding.btnLogin.isEnabled = false
    }

    override fun hideProgress() {
        binding.pbRequest.visibility = View.GONE
        binding.btnLogin.isEnabled = true
    }

    override fun showError(errorMessage: String) {
        doToast(errorMessage)
    }

    override fun showNoInternetConnection() {
        doToast("There's no internet connection to make the request.")
    }

    private fun doToast(message: String) {
        Toast.makeText(this@LoginActivity, message, Toast.LENGTH_LONG).show()
    }
}