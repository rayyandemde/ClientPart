package com.android3.siegertpclient.ui.tournament

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.android3.siegertpclient.R

class TournamentParticipantsFragment : Fragment(), TournamentContract.ITournamentView {

    private val tournamentPresenter: TournamentPresenter = TournamentPresenter()

    var centerBt : Button? =null
    var linkEt : EditText? =null
    var openBt : Button?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        var view = inflater.inflate(R.layout.fragment_tournamentparticipants, container, false)

        centerBt = view.findViewById(R.id.buttonCenter)
        linkEt = view.findViewById(R.id.stagesImagesLink)
        openBt = view.findViewById(R.id.openLinkBtn)
        return view
    }
    override fun onResume() {
        super.onResume()
        tournamentPresenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        tournamentPresenter.onDetach()
    }
//    fun showParticipantList(participants: List<Participant>) {
//        TODO("Not yet implemented")
//    }

    fun showKickParticipantBtn() {
        TODO("Not yet implemented")
    }

    fun showAddParticipantBtn() {
        TODO("Not yet implemented")
    }

    override fun showTournamentDetailsFragment() {
        TODO("Not yet implemented")
    }

    override fun showTournamentParticipantsFragment() {
        TODO("Not yet implemented")
    }

    override fun showTournamentScheduleFragment() {
        TODO("Not yet implemented")
    }

    override fun showResultFragment() {
        TODO("Not yet implemented")
    }

    override fun showTournamentUpdatesFragment() {
        TODO("Not yet implemented")
    }

    override fun navigateToHomepageActivity() {
        TODO("Not yet implemented")
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hideProgress() {
        TODO("Not yet implemented")
    }

    override fun showError(errorMessage: String) {
        TODO("Not yet implemented")
    }

    override fun showError(errorId: Int) {
        TODO("Not yet implemented")
    }
}