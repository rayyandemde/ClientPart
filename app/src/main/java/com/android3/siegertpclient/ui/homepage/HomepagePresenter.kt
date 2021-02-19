package com.android3.siegertpclient.ui.homepage

import com.android3.siegertpclient.data.user.usersource.UserRepo
import com.android3.siegertpclient.ui.base.BasePresenter

class HomepagePresenter() : BasePresenter<HomepageContract.IHomepageView>(), HomepageContract.IHomepagePresenter{

    private val userRepo: UserRepo = UserRepo()

    override fun onMailBtnClicked() {
        TODO("Not yet implemented")
    }

    override fun onHomeBtnClicked() {
        TODO("Not yet implemented")
    }

    override fun onCreateTournamentBtnClicked() {
        view?.navigateToCreateTournamentActivity()
    }

    override fun onCreateTeamBtnClicked() {
        view?.navigateToCreateTeamActivity()
    }

    override fun onJoinTeamBtnClicked() {
        TODO("Not yet implemented")
    }

    override fun onUserBtnClicked() {
        view?.navigateToUserActivity()
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

    fun goToTournament() {
       view?.goToTournamentScreen()
    }
}