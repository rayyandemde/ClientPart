package com.android3.siegertpclient.ui.team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android3.siegertpclient.data.invitation.Invitation
import com.android3.siegertpclient.data.user.User
import com.android3.siegertpclient.databinding.FragmentTeamInvitationBinding
import com.android3.siegertpclient.utils.recyclerviewadapters.InvitationAdapter

class TeamInvitationFragment : Fragment(), TeamContract.ITeamView, InvitationAdapter.OnInvitationItemClickListener {
    private var _binding: FragmentTeamInvitationBinding? = null
    private val binding get() = _binding!!

    private var teamPresenter: TeamPresenter? = null

    private val noInvitation by lazy {
        listOf(Invitation("", "", "", "", "There are no", "", "invitation for now"))
    }

    private val invitationAdapter by lazy { InvitationAdapter(this) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTeamInvitationBinding.inflate(inflater, container, false)
        teamPresenter = TeamPresenter(requireContext())

        binding.rvTeamInvitation.adapter = invitationAdapter

        binding.srlRvTeamInvitations.setOnRefreshListener {
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        teamPresenter?.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        teamPresenter?.onDetach()
        _binding = null
    }

    override fun navigateToTournamentActivity() {
        TODO("Not yet implemented")
    }

    override fun showMembers(teamMembers: List<User>?) {
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

    override fun showNoInternetConnection() {
        TODO("Not yet implemented")
    }

    override fun onInvitationItemClick(position: Int) {
        TODO("Not yet implemented")
    }
}