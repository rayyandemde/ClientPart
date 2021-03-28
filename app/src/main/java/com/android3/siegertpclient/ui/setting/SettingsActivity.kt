
package com.android3.siegertpclient.ui.setting

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Toast
import com.android3.siegertpclient.databinding.ActivitySettingsBinding
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.login.LoginActivity
import com.android3.siegertpclient.ui.userprofile.UserProfileActivity
import com.android3.siegertpclient.utils.LocalCache

class SettingsActivity : BaseActivity(), SettingsContract.ISettingView {
    private lateinit var binding: ActivitySettingsBinding
    private lateinit var settingsPresenter: SettingsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        settingsPresenter = SettingsPresenter(this)

        binding.fabBack.setOnClickListener {
            settingsPresenter.onBackBtnClicked()
        }
        binding.etUsername.setText(LocalCache.getCurrentUsername(this))

        val changeUsernameEt = binding.etUsername
        val changeForenameEt = binding.etFirstName
        val changeSurnameEt = binding.etLastName

        var language = ""
        binding.spChangeLanguages.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    adapterView: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    language = adapterView?.getItemAtPosition(position).toString()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }
            }

        binding.btnSaveSettings.setOnClickListener {
            val changedUsername = editTextTrimmer(changeUsernameEt)
            val changedForename = editTextTrimmer(changeForenameEt)
            val changedSurname = editTextTrimmer(changeSurnameEt)

            settingsPresenter.onSaveBtnClicked(
                changedUsername,
                changedForename,
                changedSurname
            )
        }

        binding.tvLogout.setOnClickListener {
            settingsPresenter.onLogoutTextClicked()
        }

        setCurrentUserEt()
    }

    override fun onResume() {
        super.onResume()
        settingsPresenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        settingsPresenter.onDetach()
    }

    override fun setCurrentUserEt() {
        binding.etUsername.setText(LocalCache.getCurrentUsername(this))
        binding.etFirstName.setText(LocalCache.getCurrentFirstName(this))
        binding.etLastName.setText(LocalCache.getCurrentLastName(this))
    }

    override fun showSuccessful() {
        doToast("Your data has been successfully updated")
    }

    override fun navigateToUserProfileActivity() {
        val intent = Intent(this, UserProfileActivity::class.java)
        startActivity(intent)
    }

    override fun navigateToLoginActivity() {
        val intent = Intent(this@SettingsActivity, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }

    override fun showProgress() {
        binding.pbRequest.visibility = View.VISIBLE
        binding.btnSaveSettings.isEnabled = false
    }

    override fun hideProgress() {
        binding.pbRequest.visibility = View.GONE
        binding.btnSaveSettings.isEnabled = true
    }

    override fun showError(errorMessage: String) {
        doToast(errorMessage)
    }

    override fun showNoInternetConnection() {
        doToast("There's no internet connection to make the request.")
    }

    private fun editTextTrimmer(editText: EditText): String {
        return editText.text.toString().trim { it <= ' ' }
    }

    private fun doToast(message: String) {
        Toast.makeText(this@SettingsActivity, message, Toast.LENGTH_LONG).show()
    }
}