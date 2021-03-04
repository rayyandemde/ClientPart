package com.android3.siegertpclient.ui.register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.android3.siegertpclient.databinding.ActivityRegisterBinding
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.homepage.HomepageActivity
import com.android3.siegertpclient.ui.homepage.HomepageDummyActivity
import com.android3.siegertpclient.ui.login.LoginActivity
import com.android3.siegertpclient.ui.userprofile.UserProfileActivity
import com.android3.siegertpclient.utils.TokenUtil

import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

/**
 * Testing javadoc here
 */
class RegisterActivity : BaseActivity(), RegisterContract.IRegisterView {
    private lateinit var binding: ActivityRegisterBinding
    lateinit var registerPresenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerPresenter = RegisterPresenter()

        val username = binding.etUsername.text.toString()
        val forename = binding.etFirstName.text.toString()
        val surname = binding.etLastName.text.toString()
        val email = binding.etEmail
        val password = binding.etPassword
        val retypePassword = binding.etRetypePassword.text.toString()

        binding.buttonSignUp.setOnClickListener {
            //registerPresenter.onRegisterBtnClicked(email, password, retypePassword, surname, forename, username)

            val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()

            val emailString = email.text.toString().trim { it <= ' ' }
            val passwordString = password.text.toString().trim { it <= ' ' }
            when {
                TextUtils.isEmpty(emailString) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Please enter email.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(passwordString) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Please enter password.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    FirebaseAuth.getInstance()
                        .createUserWithEmailAndPassword(emailString, passwordString)
                        .addOnCompleteListener({ task ->
                            if (task.isSuccessful) {
                                val firebaseUser = task.result!!.user!!

                                Toast.makeText(
                                    this@RegisterActivity,
                                    "You are registered successfully.",
                                    Toast.LENGTH_SHORT
                                ).show()

                                val token = TokenUtil.getBearerToken()

                                editor.apply {
                                    putString("userId", firebaseUser.uid)
                                    putString("email", emailString)
                                    putString("token", token)
                                }.apply()

                                val intent =
                                    Intent(this@RegisterActivity, HomepageDummyActivity::class.java)
                                intent.flags =
                                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                intent.putExtra("user_id", firebaseUser.uid)
                                intent.putExtra("email_id", emailString)
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(
                                    this@RegisterActivity,
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                        })
                }
            }
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
        onBackPressed()
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