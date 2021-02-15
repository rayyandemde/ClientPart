package com.android3.siegertpclient.ui.tournament

import android.os.Bundle
import com.android3.siegertpclient.R
import com.android3.siegertpclient.ui.base.BaseActivity

class TournamentActivity : BaseActivity() {

    private val tournamentPresenter: TournamentPresenter = TournamentPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
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