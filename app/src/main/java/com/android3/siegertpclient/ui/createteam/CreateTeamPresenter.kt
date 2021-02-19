package com.android3.siegertpclient.ui.createteam

import com.android3.siegertpclient.ui.base.BasePresenter

/**
 * The presenter to create a team, which connect to the createTeamActivity and implement a CreateTeamContract
 */
class CreateTeamPresenter : BasePresenter<CreateTeamContract.ICreateTeamView>(), CreateTeamContract.ICreateTeamPresenter{
    //The method to go back to the homepage.
    override fun onBackBtnClicked() {
        //Will not be impelmented
    }

    //The method to do something when click the create button.
    override fun onCreateBtnClicked() {
        //Do something//

        //This is only for UI testing
        view?.navigateToTeamActivity()
    }

}