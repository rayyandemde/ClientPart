package com.android3.siegertpclient.ui.invitation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.databinding.ActivityInvitationBinding
import com.android3.siegertpclient.ui.base.BaseActivity
import com.android3.siegertpclient.ui.homepage.HomepageActivity
import com.android3.siegertpclient.ui.tournament.TournamentActivity
import com.android3.siegertpclient.utils.recyclerviewadapters.InvitationAdapter

class InvitationActivity : BaseActivity(), InvitationContract.IInvitationView,
    InvitationAdapter.OnInvitationItemClickListener {

    private lateinit var binding: ActivityInvitationBinding
    private lateinit var invitationPresenter: InvitationPresenter

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

    override fun showTournamentInvitation(tournaments: List<Invitation>) {
        //Needs to be implemented *Just a placeholder comment so the app can run
    }

    override fun navigateToHomepageActivity() {
        val intent = Intent(this, HomepageActivity::class.java)
        startActivity(intent)
    }

    override fun navigateToTournamentActivity() {
        val intent = Intent(this, TournamentActivity::class.java)
        startActivity(intent)
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hideProgress() {
        binding.srlRvInvitation.isRefreshing = false
    }

    override fun showError(errorMessage: String) {
        doToast(errorMessage)
    }

    override fun showNoInternetConnection() {
        doToast("There's no internet connection to make the request.")
    }

    override fun onInvitationItemClick(position: Int) {
        invitationPresenter?.onInvitationItemClicked(position)
    }

    private fun doToast(message: String) {
        Toast.makeText(this@InvitationActivity, message, Toast.LENGTH_LONG).show()
    }
}