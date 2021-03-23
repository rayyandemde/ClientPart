package com.android3.siegertpclient.ui.invitation

import android.content.Context
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.ui.base.BasePresenter

class InvitationPresenter(private val context: Context) : BasePresenter<InvitationContract.IInvitationView>(), InvitationContract.IInvitationPresenter{
    override fun onBackBtnClicked() {
        view?.navigateToHomepageActivity()
    }

    override fun onInvitationRefresh() {
        view?.showError("Not yet implemented")
    }

    override fun onAcceptBtnClicked(tournament: Tournament) {
        TODO("Not yet implemented")
    }

    override fun onDeclineBtnClicked(tournament: Tournament) {
        TODO("Not yet implemented")
    }
}