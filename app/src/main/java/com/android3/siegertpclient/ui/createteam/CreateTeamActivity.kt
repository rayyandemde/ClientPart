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

class CreateTeamActivity : BaseActivity(), CreateTeamContract.ICreateTeamView {

    private val createTeamPresenter: CreateTeamPresenter = CreateTeamPresenter()

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

    override fun onResume() {
        super.onResume()
        createTeamPresenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        createTeamPresenter.onDetach()
    }

    override fun showErrorOnPassword(message: String) {
        TODO("Not yet implemented")
    }

    override fun navigateToHomepageActivity() {
        //Will not be implemented
    }

    override fun navigateToTeamActivity() {
        val hIntent = Intent(this, TeamActivity::class.java)
        startActivity(hIntent)
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