package com.android3.siegertpclient.ui.tournament

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import com.android3.siegertpclient.R
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.forgotpassword.ForgotPasswordActivity
import com.android3.siegertpclient.ui.login.LoginPresenter
import com.android3.siegertpclient.ui.register.RegisterActivity


class TournamentActivity : BaseActivity() {

    private val tournamentPresenter: TournamentPresenter = TournamentPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tournament)
    }
    override fun onResume() {
        super.onResume()
        TournamentPresenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        TournamentPresenter.onDetach()
    }



        val loginBtn: Button = findViewById(R.id.loginBtn)
        loginBtn.setOnClickListener{
            openHomepageActivity()
        }

        val registerTv: TextView = findViewById(R.id.registerClickable)
        registerTv.setOnClickListener {
            loginPresenter.onRegisterTextClicked()
//            openRegisterActivity()
        }

        val letsGoRegister: TextView = findViewById(R.id.forgotPassword)
        letsGoRegister.setOnClickListener {
            openForgotPasswordActivity()
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

    private fun openRegisterActivity() {
        val rIntent = Intent(this, RegisterActivity::class.java)
        startActivity(rIntent)
    }

    private fun openForgotPasswordActivity() {
        val fpIntent = Intent(this, ForgotPasswordActivity::class.java)
        startActivity(fpIntent)
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