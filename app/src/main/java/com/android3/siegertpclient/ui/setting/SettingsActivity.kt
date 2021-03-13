package com.android3.siegertpclient.ui.setting

import android.content.Intent
import android.os.Bundle
import com.android3.siegertpclient.databinding.ActivitySettingsBinding
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.login.LoginActivity
import com.android3.siegertpclient.ui.userprofile.UserProfileActivity
import com.google.firebase.auth.FirebaseAuth

class SettingsActivity : BaseActivity() , SettingsContract.ISettingView {
    private lateinit var binding: ActivitySettingsBinding
    private val settingPresenter: SettingsPresenter = SettingsPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabBack.setOnClickListener{
            settingPresenter.onBackBtnClicked()
        }

        binding.tvLogout.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this@SettingsActivity, LoginActivity::class.java))
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