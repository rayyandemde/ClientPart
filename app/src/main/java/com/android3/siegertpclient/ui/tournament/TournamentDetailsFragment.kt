package com.android3.siegertpclient.ui.tournament

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android3.siegertpclient.R
import com.android3.siegertpclient.ui.homepage.TournamentOverviewCardRecyclerAdapter

class TournamentDetailsFragment : Fragment() , TournamentContract.ITournamentView{

    private val tournamentPresenter: TournamentPresenter = TournamentPresenter()

    var  nameet : EditText? = null
    var dateet : EditText?=null
    var maxPlet : EditText?=null
    var locationet :EditText?=null
    var Regiet : EditText?=null
    var prizeet : EditText?=null
    var gametypeet :Spinner?=null
    var tournamenttypeet : Spinner?=null
    var participantFormet :Spinner?= null
    var cteateButtonet :Button ?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        var view = inflater.inflate(R.layout.fragment_tournamentdetails, container, false)


         nameet  = view.findViewById<EditText>(R.id.Name)
         dateet = view.findViewById<EditText>(R.id.Date)
         maxPlet= view.findViewById<EditText>(R.id.MaxPlayer)
         locationet = view.findViewById<EditText>(R.id.Location)
         Regiet = view.findViewById<EditText>(R.id.Regideadline)
          prizeet = view.findViewById<EditText>(R.id.Prize)
         gametypeet = view.findViewById<Spinner>(R.id.TypeOfGame1)
         tournamenttypeet = view.findViewById<Spinner>(R.id.TournamentType)
        participantFormet = view.findViewById<Spinner>(R.id.ParticipantForm)
         cteateButtonet = view.findViewById<Button>(R.id.buttonCreateTournament)


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
    fun showTournamentDetails() {
        TODO("Not yet implemented")
    }

    fun showJoinTournamentSuccessful(message: String) {
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

    override fun showNoInternetConnection() {
        TODO("Not yet implemented")
    }
}