package com.android3.siegertpclient.ui.team

import com.android3.siegertpclient.ui.base.BasePresenter

class TeamPresenter : BasePresenter<TeamContract.ITeamView>(), TeamContract.ITeamPresenter{

    fun onHomeBtnClicked() {
        view?.navigateToHomepageActivity()
    }

    override fun onBackBtnClicked() {
        //Will not be implemented
    }

    override fun onMemberBtnClicked() {
        //Will not be implemented
    }

    override fun onTeamTournamentBtnClicked() {
        //Will not be implemented
    }

    override fun checkIfAdmin(userId: String) {
        TODO("Not yet implemented")
    }

}