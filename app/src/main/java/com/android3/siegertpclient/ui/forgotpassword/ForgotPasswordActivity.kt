package com.android3.siegertpclient.ui.forgotpassword

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.android3.siegertpclient.databinding.ActivityForgotpasswordBinding
import com.android3.siegertpclient.ui.base.BaseActivity

class ForgotPasswordActivity : BaseActivity(), ForgotPasswordContract.IForgotPasswordView {

    private lateinit var binding: ActivityForgotpasswordBinding
    private lateinit var forgotPasswordPresenter: ForgotPasswordPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityForgotpasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        forgotPasswordPresenter = ForgotPasswordPresenter(this)
        val emailEt = binding.etEmail

        binding.btnBack.setOnClickListener {
            forgotPasswordPresenter.onBackBtnClicked()
        }

        binding.btnSend.setOnClickListener {
            forgotPasswordPresenter.onSendBtnClicked(
                emailEt.getText().toString().trim { it <= ' ' })
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

    override fun showErrorOnEmail() {
        doToast("Email address is not valid")
    }

    override fun showSuccess() {
        doToast("Email for changing password sent.")
    }

    override fun showNoInternetConnection() {
        doToast("There's no internet connection to make the request.")
    }

    private fun doToast(message: String) {
        Toast.makeText(this@ForgotPasswordActivity, message, Toast.LENGTH_LONG).show()
    }


    override fun navigateToLoginActivity() {
        onBackPressed()
    }

    override fun showProgress() {
        binding.pbRequest.visibility = View.VISIBLE
        binding.btnSend.isEnabled = false
    }

    override fun hideProgress() {
        binding.pbRequest.visibility = View.GONE
        binding.btnSend.isEnabled = true
    }

    override fun showError(errorMessage: String) {
    }

    override fun showError(errorId: Int) {
    }
}