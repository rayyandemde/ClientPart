package com.android3.siegertpclient.ui.userprofile

import com.android3.siegertpclient.ui.base.BasePresenter

class UserProfilePresenter : BasePresenter<UserProfileContract.IUserProfileView>(), UserProfileContract.IUserProfilePresenter{
    override fun onSettingBtnClicked() {
        view?.navigateToSettingActivity()
    }

    override fun onHomeBtnClicked() {
        view?.navigateToHomepageActivity()
    }

    override fun onMyTournamentBtnClicked() {
        //Will not be Implemented
    }

    override fun onMyTeamsBtnClicked() {
        //Will not be Implemented
    }

    override fun getTournaments() {
        TODO("Not yet implemented")
    }

    override fun getTeams() {
        TODO("Not yet implemented")
    }

}