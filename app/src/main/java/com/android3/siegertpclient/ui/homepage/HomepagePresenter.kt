package com.android3.siegertpclient.ui.homepage

import android.content.Context
import com.android3.siegertpclient.data.team.teamsource.TeamRepo
import com.android3.siegertpclient.data.user.usersource.UserRepo
import com.android3.siegertpclient.ui.base.BasePresenter
import com.android3.siegertpclient.utils.OnlineChecker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomepagePresenter(private val context: Context) :
    BasePresenter<HomepageContract.IHomepageView>(), HomepageContract.IHomepagePresenter {

    private var userRepo = UserRepo(context)
    private var teamRepo = TeamRepo(context)
    private var onlineChecker = OnlineChecker(context)

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
        //Not yet implemented
        view?.showError("")
    }

    override fun onJoinTeamBtnClicked(teamName: String, password: String) {
        if (!onlineChecker.isOnline()) {
            view?.showNoInternetConnection()
            view?.hideProgress()
        } else {
            GlobalScope.launch(Dispatchers.IO) {
                try {
                    val joinTeam = teamRepo.joinTeam(teamName, password)
                    if (joinTeam != null) {
                        withContext(Dispatchers.Main) {
                            view?.showSuccess(joinTeam.message)
                            view?.hideProgress()
                            view?.navigateToTeamActivity()
                        }
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        view?.showError("Oops... It seems there's unexpected error. Please try again.")
                        view?.hideProgress()
                    }
                }
            }
        }
    }

    override fun onInvitationBtnClicked() {
        view?.navigateToInvitationActivity()
    }
}