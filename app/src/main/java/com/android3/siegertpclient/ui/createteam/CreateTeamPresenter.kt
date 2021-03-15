package com.android3.siegertpclient.ui.createteam

import android.content.Context
import com.android3.siegertpclient.ui.base.BasePresenter

/**
 * The presenter to create a team, which connect to the createTeamActivity and implement a CreateTeamContract
 */
class CreateTeamPresenter(private val context: Context) : BasePresenter<CreateTeamContract.ICreateTeamView>(), CreateTeamContract.ICreateTeamPresenter{

    //The method to do something when click the create button.
    override fun onCreateBtnClicked(teamName: String, teamPassword: String) {
        //Do something//

        //This is only for UI testing
        //view?.navigateToTeamActivity()
    }
}