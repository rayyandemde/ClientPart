package com.android3.siegertpclient.ui.userprofile

import android.content.Context
import com.android3.siegertpclient.data.team.teamsource.TeamRepo
import com.android3.siegertpclient.data.user.usersource.UserRepo
import com.android3.siegertpclient.ui.base.BasePresenter
import com.android3.siegertpclient.utils.OnlineChecker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserProfilePresenter(private val context: Context) :
    BasePresenter<UserProfileContract.IUserProfileView>(),
    UserProfileContract.IUserProfilePresenter {

    private var onlineChecker = OnlineChecker(context)

    private var userRepo = UserRepo(context)

    override fun onSettingBtnClicked() {
        view?.navigateToSettingActivity()
    }

    override fun onHomeBtnClicked() {
        view?.navigateToHomepageActivity()
    }

    override fun onTournamentsRefresh() {
        TODO("Not yet implemented")
    }

    override fun onTeamsRefresh() {
        if (!onlineChecker.isOnline()) {
            view?.showNoInternetConnection()
            view?.hideProgress()
        } else {
            GlobalScope.launch(Dispatchers.IO) {
                try {
                    val myTeams = userRepo.getUserTeams()
                    if (myTeams != null) {
                        withContext(Dispatchers.Main) {
                            view?.showMyTeams(myTeams)
                            view?.hideProgress()
                        }
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        view?.showMyTeams(null)
                        view?.showError("Oops... It seems there's unexpected error. Please try again.")
                        view?.hideProgress()
                    }
                }
            }
        }
    }
}