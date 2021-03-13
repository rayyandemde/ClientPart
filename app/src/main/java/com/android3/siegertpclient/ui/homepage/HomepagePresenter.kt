package com.android3.siegertpclient.ui.homepage

import android.content.Context
import com.android3.siegertpclient.data.user.usersource.UserRepo
import com.android3.siegertpclient.data.user.usersource.UserRepo2
import com.android3.siegertpclient.ui.base.BasePresenter
import com.android3.siegertpclient.utils.PreferencesProvider

class HomepagePresenter(private val context: Context) : BasePresenter<HomepageContract.IHomepageView>(), HomepageContract.IHomepagePresenter{

    private var userRepo = UserRepo2()

    private var preferencesProvider = PreferencesProvider(context)

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

    override fun onInvitationBtnClicked() {
        view?.navigateToInvitationActivity()
    }

    override fun getUserInfo(token: String?) {

    }

    /*
    fun createDummyAccount(email : String,
                           password : String,
                           username: String,
                           firstName: String,
                           surname: String) {
        userRepo.register(email,password, username,firstName, surname)
    }*/

    fun goToTournament() {
       view?.goToTournamentScreen()
    }
}