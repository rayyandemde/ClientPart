package com.android3.siegertpclient.ui.createteam

import android.content.Context
import android.text.TextUtils
import android.util.Patterns
import com.android3.siegertpclient.data.team.teamsource.TeamRepo
import com.android3.siegertpclient.data.user.usersource.UserRepo
import com.android3.siegertpclient.ui.base.BasePresenter
import com.android3.siegertpclient.utils.OnlineChecker
import com.android3.siegertpclient.utils.PreferencesProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * The presenter to create a team, which connect to the createTeamActivity and implement a CreateTeamContract
 */
class CreateTeamPresenter(private val context: Context) : BasePresenter<CreateTeamContract.ICreateTeamView>(), CreateTeamContract.ICreateTeamPresenter {

    private var onlineChecker = OnlineChecker(context)
    private var teamRepo = TeamRepo(context)
    private var userRepo = UserRepo(context)

    //The method to do something when click the create button.
    override fun onCreateBtnClicked(teamName: String, teamPassword: String) {
        //This is only for UI testing
        //view?.navigateToTeamActivity()
        view?.showProgress()

        val userId = userRepo.getCurrentUserId()
        val token = userRepo.getToken()

        when {
            TextUtils.isEmpty(teamName) or TextUtils.isEmpty(teamPassword) -> {
                view?.showIncompleteInput()
                view?.hideProgress()
            }
            !onlineChecker.isOnline() -> {
                view?.showNoInternetConnection()
                view?.hideProgress()
            } else -> {
            GlobalScope.launch(Dispatchers.IO) {
                try {
                    val team = teamRepo.createNewTeam(userId!!, teamName, teamPassword, token!!)
                    if (team != null) {
                        withContext(Dispatchers.Main) {
                            view?.navigateToTeamActivity()
                        }
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        view?.hideProgress()
                        view?.showError("Oops... It seems there's unexpected error. Please try again.")
                    }
                }
            }
            }

        }
    }
}