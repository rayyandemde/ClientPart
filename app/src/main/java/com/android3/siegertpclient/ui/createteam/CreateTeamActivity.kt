package com.android3.siegertpclient.ui.createteam

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android3.siegertpclient.R
import com.android3.siegertpclient.databinding.ActivityCreateteamBinding
import com.android3.siegertpclient.databinding.ActivityRegisterBinding
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.homepage.HomepageActivity
import com.android3.siegertpclient.ui.register.RegisterPresenter
import com.android3.siegertpclient.ui.team.TeamActivity

/**
 * CreateTeamActivity class is use to show and implement the activity that create a team.
 */
class CreateTeamActivity : BaseActivity(), CreateTeamContract.ICreateTeamView {
    private lateinit var binding: ActivityCreateteamBinding
    //Connection with the create Team Presenter.
    private lateinit var createTeamPresenter: CreateTeamPresenter

    //OnCreate method is to create the view of the
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCreateteamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createTeamPresenter = CreateTeamPresenter(this)

        val teamNameEt = binding.etTeamName
        val teamPasswordEt = binding.etPassword

        binding.btnCreate.setOnClickListener {
            createTeamPresenter.onCreateBtnClicked(
                teamNameEt.text.toString().trim { it <= ' ' },
                teamPasswordEt.text.toString().trim { it <= ' ' })
        }


    }

    //The instance state is to be created now.
    override fun onResume() {
        super.onResume()
        createTeamPresenter.onAttach(this)
    }

    //The instance state is to be destroyed now.
    override fun onDestroy() {
        super.onDestroy()
        createTeamPresenter.onDetach()
    }

    //The method is to show the error when the password has an error and show the error message with the gived parameter
        override fun showErrorOnPassword(message: String) {
        TODO("Not yet implemented")
    }

    override fun showIncompleteInput() {
        doToast("Please fill in all of the field")
    }

    //navigate to the Home Activity.
    override fun navigateToHomepageActivity() {
        val intent = Intent(this@CreateTeamActivity, HomepageActivity::class.java)
        startActivity(intent)
    }

    //navigate to the team Activity.
    override fun navigateToTeamActivity() {
        val intent = Intent(this@CreateTeamActivity, TeamActivity::class.java)
        startActivity(intent)
    }

    //show the progress of the execution.
    override fun showProgress() {
        binding.pbRequest.visibility = View.VISIBLE
        binding.btnCreate.isEnabled = false
    }

    //hide the progress of the execution。
    override fun hideProgress() {
        binding.pbRequest.visibility = View.GONE
        binding.btnCreate.isEnabled = true
    }

    //show the error message
    override fun showError(errorMessage: String) {
        doToast(errorMessage)
    }

    override fun showNoInternetConnection() {
        doToast("There's no internet connection to make the request.")
    }

    private fun doToast(message: String) {
        Toast.makeText(this@CreateTeamActivity, message, Toast.LENGTH_LONG).show()
    }
}