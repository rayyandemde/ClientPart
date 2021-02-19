package com.android3.siegertpclient.ui.createteam

import com.android3.siegertpclient.ui.base.BasePresenter

class CreateTeamPresenter : BasePresenter<CreateTeamContract.ICreateTeamView>(), CreateTeamContract.ICreateTeamPresenter{
    override fun onBackBtnClicked() {
        //Will not be impelmented
    }

    override fun onCreateBtnClicked() {
        //Do something//

        //This is only for UI testing
        view?.navigateToTeamActivity()
    }

}