package com.android3.siegertpclient.ui.team

import android.content.Context
import android.text.TextUtils
import com.android3.siegertpclient.data.team.teamsource.TeamRepo
import com.android3.siegertpclient.data.user.usersource.UserRepo
import com.android3.siegertpclient.ui.base.BasePresenter
import com.android3.siegertpclient.utils.OnlineChecker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TeamPresenter(private val context: Context) : BasePresenter<TeamContract.ITeamView>(), TeamContract.ITeamPresenter {

    private var onlineChecker = OnlineChecker(context)

    private var teamRepo = TeamRepo(context)

    override fun onMembersRefresh() {
        if (!onlineChecker.isOnline()) {
            view?.showNoInternetConnection()
            view?.hideProgress()
        } else {
            GlobalScope.launch(Dispatchers.IO) {
                try {
                    val teamMembers = teamRepo.getTeamMembers()
                    if (teamMembers != null) {
                        withContext(Dispatchers.Main) {
                            view?.showMembers(teamMembers)
                            view?.hideProgress()
                        }
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        view?.showError(e.message.toString())
                        view?.showMembers(null)
                        //view?.showError("Oops... It seems there's unexpected error. Please try again.")
                        view?.hideProgress()
                    }
                }
            }
        }
    }

    override fun onTournamentsRefresh() {
        TODO("Not yet implemented")
    }

    override fun onInvitationRefresh() {
        TODO("Not yet implemented")
    }

    override fun onAddBtnClicked() {
        TODO("Not yet implemented")
    }

    override fun onHomeBtnClicked() {
        TODO("Not yet implemented")
    }

}