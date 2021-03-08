package com.android3.siegertpclient.ui.createtournament

import android.content.Context
import com.android3.siegertpclient.ui.base.BasePresenter

class CreateTournamentPresenter(private val context: Context) : BasePresenter<CreateTournamentContract.ICreateTournamentView>(), CreateTournamentContract.ICreateTournamentPresenter{
    override fun onBackBtnClicked() {
        view?.navigateToHomepageActivity()
    }

    override fun onCreateBtnClicked() {
        view?.navigateToTournamentActivity()
    }
}