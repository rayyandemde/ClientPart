package com.android3.siegertpclient.ui.tournament

import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.ui.base.BasePresenter

class TournamentPresenter : BasePresenter<TournamentContract.ITournamentView>(), TournamentContract.ITeamPresenter {

    fun onDeleteTournamentBtnClicked() {
        //Do something to remote
        view?.navigateToHomepageActivity()
    }

    fun onJoinBtnClicked() {

    }

    fun onKickParticipantBtnClicked() {

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

    fun getGameList() {

    }

    override fun checkIfAdmin(userId: String) {
        TODO("Not yet implemented")
    }

    override fun checkAlreadyJoined(uerId: String) {
        TODO("Not yet implemented")
    }

    override fun onBackBtnClicked() {
        view?.navigateToHomepageActivity()
    }

    override fun onTournamentDetailsTabClicked() {
       view?.showTournamentDetailsFragment()
    }

    override fun onParticipantListTabClicked() {
        view?.showTournamentParticipantsFragment()
    }

    override fun onScheduleTabClicked() {
        view?.showTournamentScheduleFragment()
    }

    override fun onStageSliderClicked() {
        TODO("Not yet implemented")
    }

    override fun onMatchesSliderClicked() {

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