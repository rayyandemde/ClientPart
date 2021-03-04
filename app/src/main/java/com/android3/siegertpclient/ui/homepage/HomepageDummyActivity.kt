package com.android3.siegertpclient.ui.homepage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.android3.siegertpclient.databinding.ActivityHomepageDummyBinding
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GetTokenResult

class HomepageDummyActivity : BaseActivity() {
    private lateinit var binding: ActivityHomepageDummyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomepageDummyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userId = intent.getStringExtra("user_id")
        val emailId = intent.getStringExtra("email_id")

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedUserID = sharedPreferences.getString("userId", null)



        /*
        val user = FirebaseAuth.getInstance().currentUser!!
        user.getIdToken(true)
            .addOnCompleteListener({ task ->
                if (task.isSuccessful()) {
                    val token = task.result!!.token!!
                    binding.tvTestId.text = "User Token :: " + token.toString()
                } else {
                    Toast.makeText(
                        this@HomepageDummyActivity,
                        task.exception!!.message.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
*/

        //binding.tvTestId.text = "User ID :: $userId"
        //binding.tvTestId.text = "User Token :: " + token
        binding.tvTestId.text = "User ID :: "
        binding.tvTestEmail.text = "Email ID :: $emailId"

        binding.buttonTestLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this@HomepageDummyActivity, LoginActivity::class.java))
            finish()
        }

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