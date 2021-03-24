package com.android3.siegertpclient.ui.invitation

import android.content.Context
import com.android3.siegertpclient.data.invitation.invitationsource.InvitationRepo
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.data.tournament.tournamentsource.TournamentRepo
import com.android3.siegertpclient.data.user.usersource.UserRepo
import com.android3.siegertpclient.ui.base.BasePresenter
import com.android3.siegertpclient.utils.Constants
import com.android3.siegertpclient.utils.OnlineChecker
import com.android3.siegertpclient.utils.PreferencesProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class InvitationPresenter(private val context: Context) : BasePresenter<InvitationContract.IInvitationView>(), InvitationContract.IInvitationPresenter{
    private var onlineChecker = OnlineChecker(context)
    private var userRepo = UserRepo(context)
    private var invitationRepo = InvitationRepo(context)
    private var localData = PreferencesProvider(context)
    private var tournamentRepo = TournamentRepo(context)
    override fun onBackBtnClicked() {
        view?.navigateToHomepageActivity()
    }

    override fun onInvitationRefresh() {
        if (!onlineChecker.isOnline()) {
            view?.showNoInternetConnection()
            view?.hideProgress()
            return
        }

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val invitations = userRepo.getUsersInvitations()
                if (invitations == null) {
                    withContext(Dispatchers.Main) {
                        view?.showError("You don't have any invitation")
                        view?.hideProgress()
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        view?.showTournamentInvitation(invitations)
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

    override fun onAcceptBtnClicked(tournament: Tournament) {
        TODO("Not yet implemented")
    }

    override fun onDeclineBtnClicked(tournament: Tournament) {
        TODO("Not yet implemented")
    }

    override fun onInvitationItemClicked(position: Int) {
        val savedInvitations = invitationRepo.getCurrentUserInvitations()!!

        val tournamentName = savedInvitations[position].tournamentName
        localData.putString(Constants.KEY_TOURNAMENT_NAME, tournamentName)
        view?.navigateToTournamentActivity()
    }
}