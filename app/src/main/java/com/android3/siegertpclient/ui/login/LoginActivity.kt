package com.android3.siegertpclient.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.android3.siegertpclient.R
import com.android3.siegertpclient.databinding.ActivityLoginBinding
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.forgotpassword.ForgotPasswordActivity
import com.android3.siegertpclient.ui.homepage.HomepageActivity
import com.android3.siegertpclient.ui.homepage.HomepageDummyActivity
import com.android3.siegertpclient.ui.register.RegisterActivity
import com.android3.siegertpclient.utils.TokenUtil
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity : BaseActivity(), LoginContract.ILoginView {
    private lateinit var binding: ActivityLoginBinding

    private val loginPresenter: LoginPresenter = LoginPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setTheme(R.style.Theme_SiegerTPClient)
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = binding.etEmail
        val password = binding.etPassword

        binding.tvRegister.setOnClickListener {
            loginPresenter.onRegisterTextClicked()
        }

        binding.btnLogin.setOnClickListener{
            //loginPresenter.onLoginBtnClicked(emailTxt.text.toString(), passwordTxt.text.toString())
            //This is only test method
            //loginPresenter.onLoginBtnClickedDummy()

            //Dummy Login page
            val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()

            val emailString = email.text.toString().trim { it <= ' '}
            val passwordString = password.text.toString().trim { it <= ' '}
            when {
                TextUtils.isEmpty(emailString) -> {
                    Toast.makeText(
                        this@LoginActivity,
                        "Please enter email.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(passwordString) -> {
                    Toast.makeText(
                        this@LoginActivity,
                        "Please enter password.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(emailString, passwordString)
                        .addOnCompleteListener({ task ->
                            if (task.isSuccessful) {
                                val firebaseUser: FirebaseUser = task.result!!.user!!

                                Toast.makeText(
                                    this@LoginActivity,
                                    "You are logged in successfully.",
                                    Toast.LENGTH_SHORT
                                ).show()

                                editor.apply {
                                    putString("userId", firebaseUser.uid)
                                    putString("email", emailString)
                                }.apply()

                                val intent =
                                    Intent(this@LoginActivity, HomepageDummyActivity::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                intent.putExtra("user_id", FirebaseAuth.getInstance().currentUser!!.uid)
                                intent.putExtra("email_id", emailString)
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(
                                    this@LoginActivity,
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                        })
                }
            }
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

    override fun showNoInternetConnection() {
        TODO("Not yet implemented")
    }

}