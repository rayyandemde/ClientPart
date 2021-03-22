package com.android3.siegertpclient.ui.homepage

import android.content.Context
import com.android3.siegertpclient.data.user.usersource.UserRepo
import com.android3.siegertpclient.ui.base.BasePresenter

class HomepagePresenter(private val context: Context) :
    BasePresenter<HomepageContract.IHomepageView>(), HomepageContract.IHomepagePresenter {

    private var userRepo = UserRepo(context)


    override fun onCreateTournamentBtnClicked() {
        view?.navigateToCreateTournamentActivity()
    }

    override fun onCreateTeamBtnClicked() {
        view?.navigateToCreateTeamActivity()
    }


    override fun onUserBtnClicked() {
        view?.navigateToUserActivity()
    }

    override fun onFeedRefresh() {
        TODO("Not yet implemented")
    }

    override fun onInvitationBtnClicked() {
        view?.navigateToInvitationActivity()
    }
}