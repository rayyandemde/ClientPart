package com.android3.siegertpclient.ui.createtournament

import com.android3.siegertpclient.ui.base.BasePresenter

class CreateTournamentPresenter : BasePresenter<CreateTournamentContract.ICreateTournamentView>(), CreateTournamentContract.ICreateTournamentPresenter{
    override fun onBackBtnClicked() {
        view?.navigateToHomepageActivity()
    }

    override fun onCreateBtnClicked() {
        view?.navigateToTournamentActivity()
    }
}