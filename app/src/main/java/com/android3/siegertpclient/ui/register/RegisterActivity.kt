package com.android3.siegertpclient.ui.register

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.android3.siegertpclient.databinding.ActivityRegisterBinding
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.dummyretrofit.util.Constants.Companion.KEY_TOKEN
import com.android3.siegertpclient.ui.dummyretrofit.util.Constants.Companion.KEY_USER_ID
import com.android3.siegertpclient.ui.homepage.HomepageActivity

/**
 * Testing javadoc here
 */
class RegisterActivity : BaseActivity(), RegisterContract.IRegisterView {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var registerPresenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerPresenter = RegisterPresenter(this)

        val usernameEt = binding.etUsername
        val forenameEt = binding.etFirstName
        val surnameEt = binding.etLastName
        val emailEt = binding.etEmail
        val passwordEt = binding.etPassword
        val retypePasswordEt = binding.etRetypePassword

        binding.btnSignUp.setOnClickListener {
            val email = editTextTrimmer(emailEt)
            val password = editTextTrimmer(passwordEt)
            val retypePassword = editTextTrimmer(retypePasswordEt)
            val surname = editTextTrimmer(surnameEt)
            val forename = editTextTrimmer(forenameEt)
            val username = editTextTrimmer(usernameEt)

            registerPresenter.onRegisterBtnClicked(
                email,
                password,
                retypePassword,
                surname,
                forename,
                username
            )
        }

        binding.tvLogin.setOnClickListener {
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

    override fun showIncompleteInput() {
        doToast("Please fill in all of the field")
    }

    override fun showErrorOnEmail() {
        doToast("Email is not valid")
    }

    override fun showErrorOnPassword() {
        doToast("Password doesn't match")
    }

    override fun showErrorOnUsername() {
        doToast("Username already exist")
    }

    override fun navigateToHomepageActivity(userId: String, token: String) {
        doToast("You are registered successfully.")
        val intent = Intent(this@RegisterActivity, HomepageActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        intent.putExtra(KEY_USER_ID, userId)
        intent.putExtra(KEY_TOKEN, token)
        startActivity(intent)
        finish()
    }

    override fun navigateToLoginActivity() {
        onBackPressed()
    }

    override fun showNoInternetConnection() {
        doToast("There's no internet connection to make the request.")
    }

    override fun showProgress() {
        binding.pbRequest.visibility = View.VISIBLE
        binding.btnSignUp.isEnabled = false
    }

    override fun hideProgress() {
        binding.pbRequest.visibility = View.GONE
        binding.btnSignUp.isEnabled = true
    }

    override fun showError(errorMessage: String) {
        doToast(errorMessage)
    }

    private fun editTextTrimmer(editText: EditText): String {
        return editText.text.toString().trim { it <= ' ' }
    }

    private fun doToast(message: String) {
        Toast.makeText(this@RegisterActivity, message, Toast.LENGTH_LONG).show()
    }
}