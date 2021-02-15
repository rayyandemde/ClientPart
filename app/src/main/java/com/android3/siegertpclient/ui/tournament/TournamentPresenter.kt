package com.android3.siegertpclient.ui.tournament

import com.android3.siegertpclient.data.game.Game
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.ui.base.BasePresenter

class TournamentPresenter : BasePresenter<TournamentContract.ITournamentView>(), TournamentContract.ITeamPresenter {

    fun onJoinBtnClicked() {
        TODO("Not yet implemented")
    }

    fun onKickParticipantBtnClicked() {
        TODO("Not yet implemented")
    }

    fun onAddParticipantBtnClicked() {
        TODO("Not yet implemented")
    }

    fun onDeleteScheduleBtnClicked() {
        TODO("Not yet implemented")
    }

    fun onCreateTableBtnClicked() {
        TODO("Not yet implemented")
    }

    fun onEditTableBtnClicked() {
        TODO("Not yet implemented")
    }

    fun onEditBranchBtnClicked() {
        TODO("Not yet implemented")
    }

    fun onAddGamesBtnClicked() {
        TODO("Not yet implemented")
    }

    fun onEditGamesBtnClciked() {
        TODO("Not yet implemented")
    }

    fun getTOurnament() : Tournament {
        TODO("Not yet implemented")
    }

 //   fun getParticipantList() : List<Participant> {
 //       TODO("Not yet implemented")
 //   }

    fun getGameList() : List<Game> {
        TODO("Not yet implemented")
    }

    override fun checkIfAdmin(userId: String) {
        TODO("Not yet implemented")
    }

    override fun checkAlreadyJoined(uerId: String) {
        TODO("Not yet implemented")
    }

    override fun onBackBtnClicked() {
        TODO("Not yet implemented")
    }

    override fun onTournamentDetailsTabClicked() {
        TODO("Not yet implemented")
    }

    override fun onParticipantListTabClicked() {
        TODO("Not yet implemented")
    }

    override fun onScheduleTabClicked() {
        TODO("Not yet implemented")
    }

    override fun onStageSliderClicked() {
        TODO("Not yet implemented")
    }

    override fun onMatchesSliderClicked() {
        TODO("Not yet implemented")
    }

    override fun onTournamentUpdatesTabClicked() {
        TODO("Not yet implemented")
    }

//   fun getTable() : LeagueTable {
//       TODO("Not yet implemented")
//    }

//    fun getBranch() : KnockOutMapping {
//        TODO("Not yet implemented")
//    }
}