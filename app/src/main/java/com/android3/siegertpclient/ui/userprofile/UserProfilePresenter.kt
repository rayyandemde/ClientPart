package com.android3.siegertpclient.ui.userprofile

import android.content.Context
import com.android3.siegertpclient.data.team.teamsource.TeamRepo
import com.android3.siegertpclient.data.user.usersource.UserRepo
import com.android3.siegertpclient.ui.base.BasePresenter
import com.android3.siegertpclient.utils.Constants.Companion.KEY_TEAM_NAME
import com.android3.siegertpclient.utils.OnlineChecker
import com.android3.siegertpclient.utils.PreferencesProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserProfilePresenter(private val context: Context) :
    BasePresenter<UserProfileContract.IUserProfileView>(),
    UserProfileContract.IUserProfilePresenter {

    private var onlineChecker = OnlineChecker(context)

    private var userRepo = UserRepo(context)

    private var teamRepo = TeamRepo(context)

    private var localData = PreferencesProvider(context)

    override fun userTeamClicked(position: Int) {
        val savedTeam = teamRepo.getCurrentTeamsList()!!

        val chosenTeamName = savedTeam[position].teamName
        localData.putString(KEY_TEAM_NAME, chosenTeamName)
        view?.navigateToTeamActivity()
    }

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
                    if (myTeams == null) {
                        withContext(Dispatchers.Main) {
                            view?.showError("It seems you haven't joined any team yet.")
                            view?.hideProgress()
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
}