package com.android3.siegertpclient.ui.homepage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.android3.siegertpclient.data.tournament.tournamentsource.TournamentRepo2
import com.android3.siegertpclient.data.user.usersource.UserRepo
import com.android3.siegertpclient.databinding.ActivityHomepageDummyBinding
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.dummyretrofit.util.Constants
import com.android3.siegertpclient.ui.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomepageDummyActivity : BaseActivity() {
    private lateinit var binding: ActivityHomepageDummyBinding

    private var tournamentRepo = TournamentRepo2()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomepageDummyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val userId = intent.getStringExtra("user_id")
        val emailId = intent.getStringExtra("email_id")

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val savedUserID = sharedPreferences.getString("userId", null)
        val savedEmail = sharedPreferences.getString("email", null)


        val user = FirebaseAuth.getInstance().currentUser!!
        user.getIdToken(true)
            .addOnCompleteListener({ task ->
            if (task.isSuccessful()) {
                val token = task.result!!.token!!
                val tokenBearer = "Bearer ".plus(token)
                Log.e("TokenSuccess", tokenBearer)
                editor.putString("token", tokenBearer)
                editor.commit()
                //binding.tvTestId.text = "User Token :: " + token.toString()
            } else {
                Toast.makeText(
                    this@HomepageDummyActivity,
                    task.exception!!.message.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        //binding.tvTestId.text = "User ID :: $userId"
        //binding.tvTestId.text = "User Token :: " + token
        //binding.tvTestId.text = "User ID :: ".plus(savedUserID)
        binding.tvTestId.text = "Token :: "
        binding.tvTestEmail.text = "Email ID :: ".plus(savedEmail)

        val previousIntent = intent
        val token = previousIntent.getStringExtra(Constants.KEY_TOKEN)

        binding.buttonTestLogout.setOnClickListener {
            editor.apply {
                editor.remove("userId")
                editor.remove("email")
                editor.remove("token")
            }.apply()

            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this@HomepageDummyActivity, LoginActivity::class.java))
            finish()
        }

        binding.buttonTestToken.setOnClickListener {
            //binding.tvTestId.text = sharedPreferences.getString("token", "doesn't got anything yet")
            binding.tvTestId.text = "Token :: ".plus(token)
        }

        binding.buttonGoTest.setOnClickListener {
            showProgress()
            GlobalScope.launch(Dispatchers.IO) {
                try {
                    val response = tournamentRepo
                        .getTournamentById("f7822baf-1960-458d-b035-d4186c6fdee3", token)
                    if (response.isSuccessful) {
                        withContext(Dispatchers.Main) {
                            //binding.tvTestId.text = "Success"
                            showError("Success")
                            binding.tvTestId.text = response.body()!!.toString()
                            hideProgress()
                        }
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        binding.tvTestId.text = "Oops... It seems there's unexpected error"
                        showError("Oops... It seems there's unexpected error")
                        hideProgress()
                    }
                }
            }
        }

    }

    override fun showProgress() {
        binding.pbRequest.visibility = View.VISIBLE
        binding.buttonGoTest.isEnabled = false
    }

    override fun hideProgress() {
        binding.pbRequest.visibility = View.INVISIBLE
        binding.buttonGoTest.isEnabled = true
    }

    override fun showError(errorMessage: String) {
        doToast(errorMessage)
    }

    override fun showNoInternetConnection() {
        TODO("Not yet implemented")
    }

    private fun doToast(message: String) {
        Toast.makeText(this@HomepageDummyActivity, message, Toast.LENGTH_LONG).show()
    }
}