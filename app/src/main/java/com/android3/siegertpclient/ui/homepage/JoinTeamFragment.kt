package com.android3.siegertpclient.ui.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.android3.siegertpclient.R
import com.android3.siegertpclient.data.tournament.Tournament

class JoinTeamFragment : Fragment() , HomepageContract.IHomepageView {

    private val homepagePresenter: HomepagePresenter = HomepagePresenter()

    var dummyUsername: EditText? = null
    var dummySurname: EditText? = null
    var dummyForename: EditText? = null
    var dummyUserId: EditText? = null
    var dummyCreateBtn: Button? = null
    var dummyGetBtn: Button? = null
    var dummyInfoTv: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = inflater!!.inflate(R.layout.fragment_jointeam, container, false)

        dummyUsername = view.findViewById<EditText>(R.id.dummyUsername)
        dummySurname = view.findViewById<EditText>(R.id.dummySurname)
        dummyForename = view.findViewById<EditText>(R.id.dummyForename)
        dummyUserId = view.findViewById<EditText>(R.id.dummyId)
        dummyCreateBtn = view.findViewById<Button>(R.id.dummyCreateButton)
        dummyGetBtn = view.findViewById<Button>(R.id.giveMeTheUser)
        dummyInfoTv = view.findViewById<TextView>(R.id.thisIsTheTestUser)

        dummyCreateBtn?.setOnClickListener{
            homepagePresenter.createDummyAccount(dummyUsername?.getText().toString(),
                dummySurname?.getText().toString(),
                dummyForename?.getText().toString(),
                dummyUserId?.getText().toString())
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        homepagePresenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        homepagePresenter.onDetach()
    }

    fun navigateToTeamActivity() {
        TODO("Not yet implemented")
    }

    override fun navigateToInvitationActivity() {
        TODO("Not yet implemented")
    }

    override fun navigateToUserActivity() {
        TODO("Not yet implemented")
    }

    override fun navigateToCreateTournamentActivity() {
        TODO("Not yet implemented")
    }

    override fun showFeedFragment() {
        TODO("Not yet implemented")
    }

    override fun showJoinTeamFragment() {
        TODO("Not yet implemented")
    }

    override fun showSearchResult(tournaments: List<Tournament>) {
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