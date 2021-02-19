package com.android3.siegertpclient.ui.createteam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.android3.siegertpclient.R
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.homepage.HomepageActivity
import com.android3.siegertpclient.ui.team.TeamActivity

/**
 * CreateTeamActivity class is use to show and implement the activity that create a team.
 */
class CreateTeamActivity : BaseActivity(), CreateTeamContract.ICreateTeamView {

    //Connection with the create Team Presenter.
    private val createTeamPresenter: CreateTeamPresenter = CreateTeamPresenter()

    //OnCreate method is to create the view of the
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_createteam)

        val createTeamBtn: Button = findViewById(R.id.createTeamBtn)
        createTeamBtn.setOnClickListener {
            createTeamPresenter.onCreateBtnClicked()
        }

        val teamNameEt: EditText = findViewById(R.id.teamNameCreate)
        val teamPasswordEt: EditText = findViewById(R.id.teamPasswrodCreate)
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

    //navigate to the Home Activity.
    override fun navigateToHomepageActivity() {
        //Will not be implemented
    }

    //navigate to the team Activity.
    override fun navigateToTeamActivity() {
        val hIntent = Intent(this, TeamActivity::class.java)
        startActivity(hIntent)
    }

    //show the progress of the execution.
    override fun showProgress() {
        TODO("Not yet implemented")
    }

    //hide the progress of the execution。
    override fun hideProgress() {
        TODO("Not yet implemented")
    }

    //show the error message
    override fun showError(errorMessage: String) {
        TODO("Not yet implemented")
    }

    //show the error of a special id give as Integer.
    override fun showError(errorId: Int) {
        TODO("Not yet implemented")
    }
}