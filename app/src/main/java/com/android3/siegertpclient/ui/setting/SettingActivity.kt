package com.android3.siegertpclient.ui.setting

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.android3.siegertpclient.R
import com.android3.siegertpclient.databinding.ActivityRegisterBinding
import com.android3.siegertpclient.databinding.ActivitySettingBinding
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.homepage.HomepageActivity
import com.android3.siegertpclient.ui.login.LoginActivity
import com.android3.siegertpclient.ui.userprofile.UserProfileActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth

class SettingActivity : BaseActivity() , SettingContract.ISettingView {
    private lateinit var binding: ActivitySettingBinding
    private val settingPresenter: SettingPresenter = SettingPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabBack.setOnClickListener{
            settingPresenter.onBackBtnClicked()
        }

        binding.tvLogout.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this@SettingActivity, LoginActivity::class.java))
            finish()
        }
    }


    override fun onResume() {
        super.onResume()
        settingPresenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        settingPresenter.onDetach()
    }

    override fun navigateToUserProfileActivity() {
        val upIntent = Intent(this, UserProfileActivity::class.java)
        startActivity(upIntent)
    }

    override fun showMessageOnPage(message: String) {
        TODO("Not yet implemented")
    }

    override fun navigateToLoginActivity() {
        val loginIntent = Intent(this, LoginActivity::class.java)
        startActivity(loginIntent)
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

    override fun showNoInternetConnection() {
        TODO("Not yet implemented")
    }
}