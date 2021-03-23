package com.android3.siegertpclient.ui.invitation

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android3.siegertpclient.R
import com.android3.siegertpclient.data.team.Team
import com.android3.siegertpclient.data.tournament.Tournament
import com.android3.siegertpclient.databinding.ActivityInvitationBinding
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.homepage.HomepageActivity
import com.android3.siegertpclient.utils.recyclerviewadapters.InvitationAdapter
import com.android3.siegertpclient.utils.recyclerviewadapters.TeamAdapter


class InvitationActivity : BaseActivity(), InvitationContract.IInvitationView,
    InvitationAdapter.OnInvitationItemClickListener {

    private lateinit var binding: ActivityInvitationBinding
    private lateinit var invitationPresenter: InvitationPresenter

    private val noInvitation by lazy {
        listOf(Team("", emptyList(), emptyList(), "", getString(R.string.user_no_team), "", emptyList()))
    }

    private val invitationAdapter by lazy { InvitationAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInvitationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        invitationPresenter = InvitationPresenter(this)

        binding.fabBack.setOnClickListener{
            invitationPresenter.onBackBtnClicked()
        }

        binding.rvUserInvitation.adapter = invitationAdapter

        invitationPresenter.onInvitationRefresh()

        binding.srlRvInvitation.setOnRefreshListener {
            invitationPresenter.onInvitationRefresh()
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

    override fun onInvitationItemClick(position: Int) {
        TODO("Not yet implemented")
    }
}