package com.android3.siegertpclient.ui.userprofile

import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.data.user.usersource.UserRepo
import com.android3.siegertpclient.ui.base.BasePresenter

class UserProfilePresenter : BasePresenter<UserProfileContract.IUserProfileView>(), UserProfileContract.IUserProfilePresenter{

    private var userRepo = UserRepo()

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

    fun getDummyUser() : User {
        return userRepo.register("dummyEmail",
            "dummyPassword",
            "dummyUserName",
            "dummyFirstName",
            "dummySurname")
    }

}