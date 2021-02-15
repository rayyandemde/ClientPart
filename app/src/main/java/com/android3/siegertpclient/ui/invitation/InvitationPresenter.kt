package com.android3.siegertpclient.ui.invitation

import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.ui.base.BasePresenter

class InvitationPresenter : BasePresenter<InvitationContract.IInvitationView>(), InvitationContract.IInvitationPresenter{
    override fun getTournaments() {
        TODO("Not yet implemented")
    }

    override fun onBackBtnClicked() {
        TODO("Not yet implemented")
    }

    override fun onAcceptBtnClicked(tournament: Tournament) {
        TODO("Not yet implemented")
    }

    override fun onDeclineBtnClicked(tournament: Tournament) {
        TODO("Not yet implemented")
    }
}