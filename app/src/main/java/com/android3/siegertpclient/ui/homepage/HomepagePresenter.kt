package com.android3.siegertpclient.ui.homepage

import com.android3.siegertpclient.data.userdummy.usersource.UserRepoDummy
import com.android3.siegertpclient.ui.base.BasePresenter

class HomepagePresenter : BasePresenter<HomepageContract.IHomepageView>(), HomepageContract.IHomepagePresenter{

    private val userRepo: UserRepoDummy = UserRepoDummy()

    override fun onMailBtnClicked() {
        TODO("Not yet implemented")
    }

    override fun onHomeBtnClicked() {
        TODO("Not yet implemented")
    }

    override fun onCreateTournamentBtnClicked() {
        TODO("Not yet implemented")
    }

    override fun onCreateTeamBtnClicked() {
        TODO("Not yet implemented")
    }

    override fun onJoinTeamBtnClicked() {
        TODO("Not yet implemented")
    }

    override fun onUserBtnClicked() {
        TODO("Not yet implemented")
    }

    override fun onTournamentOverviewClicked() {
        TODO("Not yet implemented")
    }

    override fun loadTournamentOverviews() {
        TODO("Not yet implemented")
    }

    fun createDummyAccount(email : String,
                           password : String,
                           username: String,
                           firstName: String,
                           surname: String) {
        userRepo.register(email,password, username,firstName, surname)
    }

}