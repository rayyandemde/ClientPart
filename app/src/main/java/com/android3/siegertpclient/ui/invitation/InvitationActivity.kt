package com.android3.siegertpclient.ui.invitation

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android3.siegertpclient.R
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.databinding.ActivityInvitationBinding
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.homepage.HomepageActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class InvitationActivity : BaseActivity(), InvitationContract.IInvitationView {

    private lateinit var binding: ActivityInvitationBinding
    private lateinit var invitationPresenter: InvitationPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invitation)

        var teamInvitationRecycler: RecyclerView = findViewById<RecyclerView>(R.id.user_invitation_recycler)

        teamInvitationRecycler!!.layoutManager = LinearLayoutManager(applicationContext)
        teamInvitationRecycler!!.adapter = TournamentOverviewCardRecyclerAdapter()

        val backBtn: FloatingActionButton = findViewById(R.id.backBtnInvitation)
        backBtn.setOnClickListener{
            invitationPresenter.onBackBtnClicked()
        }
    }

    override fun onResume() {
        super.onResume()
        invitationPresenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        invitationPresenter.onDetach()
    }

    override fun showTournamentInvitation(tournaments: List<Tournament>) {
        TODO("Not yet implemented")
    }

    override fun navigateToHomepageActivity() {
        val hIntent = Intent(this, HomepageActivity::class.java)
        startActivity(hIntent)
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

    override fun showNoInternetConnection() {
        TODO("Not yet implemented")
    }
}